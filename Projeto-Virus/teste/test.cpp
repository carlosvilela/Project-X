#include "stdafx.h"
#include <iostream>
using namespace std;

// I'm using Vista ATM (it's evil), but GCC comes assuming the worst.
// If you haven't patched your compiler to agree with the actual version
// of the Windows OS, then you will need to make sure you do it like this.
//
#if       _WIN32_WINNT < 0x0500
#undef  _WIN32_WINNT
#define _WIN32_WINNT   0x0500
#endif
#include <windows.h>

// Here's some fun timer stuff for the user.
// (Notice how he won't see it work when the
//  console is hidden, but it will still work.)
void timeout()
{
	for (int cntr = 3; cntr > 0; cntr--)
	{
		cout << "\r" << cntr << flush;
		Sleep(1000);
	}
	cout << "\r" << flush;
}

// Demonstrate some fun stuff.
// Notice how hiding the console window causes it to disappear from
// the Windows task bar. If you only want to make it minimize, use
// SW_MINIMIZE instead of SW_HIDE.
//
int main()
{
	//ShowWindow(GetConsoleWindow(), SW_HIDE);
	cout << "Preparing to hide the console window\n";
	timeout();
	ShowWindow(GetConsoleWindow(), SW_HIDE);

	cout << "Preparing to show the console window\n";
	timeout();
	ShowWindow(GetConsoleWindow(), SW_RESTORE);

	cout << "All done!\n";

	system("pause");
	return 0;
}

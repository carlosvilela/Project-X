// Sistema de verificação de horario de funcionamento e conexão com a internet
// Desenvolvido em Visual Studio Community 2015 - Visual C++
/*
ATENÇÃO: ESSE PROGRAMA SISTEMA.EXE NÃO PODE SER COLOCADO NA RAIZ C:
POIS DÁ ERRO AO EXECUTAR O PING, POR CAUSA DA RAIZ C: SER PROTEGIDA,
PORTANTO COLOQUE O SISTEMA.EXE EM OUTRA PASTA SEM SER NA RAIZ C:,
caso os arquivos a.exe, a.bat e b.bat derem erros, pode ser
porque estão na raiz c:, caso isso ocorra mude os caminhos aqui no código-fonte
e faça uma nova compilação
*/

#include "stdafx.h" // biblioteca padrão do Visual Studio
#include <iostream>// entrada e saída de dados
#include <ctime>//manipular data e hora
#include <thread>//sleep - esperar alguns segundos
#include <ShellAPI.h>// ajuda no uso do comando ShellExecute
#include <windows.h>// ajuda no uso do comando ShellExecute

using namespace std;

// classe Desliga
class desliga {
public: // sinaliza que as variáveis da classe estão publicas para todo o programa
	int *hora1;
	int *hora2;
	int *minutos1;
	int *minutos2;
	int *conexao;
	int *ciclo;
};
static class desliga desligar;



int main(int argc, char** argv) {

	//alocar memória ao ponteiro
	desligar.hora1 = new int;
	desligar.hora2 = new int;
	desligar.minutos1 = new int; //os minutos não podem ser maiores que 55 para evitar erros
	desligar.minutos2 = new int; //os minutos não podem ser maiores que 55 para evitar erros
	desligar.ciclo = new int;

	//parametros
	*desligar.ciclo = 60 * 1; //em segundos - 1 minuto é o ideal para o ciclo
	// horario 1
	*desligar.hora1 = 18;
	*desligar.minutos1 = 55; //os minutos não podem ser maiores que 55 para evitar erros
	// horario 2
	*desligar.hora2 = 23;
	*desligar.minutos2 = 55; //os minutos não podem ser maiores que 55 para evitar erros



	for (;;) { // loop infinito

		// verifica a data e hora corrente do computador 
		struct tm agora;
		time_t tempo = time(NULL);
		localtime_s(&agora, &tempo);
		/*

		Member	Type	Meaning	Range
		tm_sec	int	seconds after the minute	0-61*
		tm_min	int	minutes after the hour	0-59
		tm_hour	int	hours since midnight	0-23
		tm_mday	int	day of the month	1-31
		tm_mon	int	months since January	0-11
		tm_year	int	years since 1900
		tm_wday	int	days since Sunday	0-6
		tm_yday	int	days since January 1	0-365
		tm_isdst	int	Daylight Saving Time flag
		*/

		//Teste lógico se está no horário de desligar
		if (((agora.tm_hour == *desligar.hora1) && (agora.tm_min >= *desligar.minutos1)) && ((agora.tm_wday != 6) && (agora.tm_wday != 0))) //desliga todos os dias menos sábados e domingos (6 é sábado e 0 é domingo, samendo que o dia 0 é domingo, 1 segunda e assim por diante até o 6 que é sábado)
		{
			// processo de desligar
			system("shutdown /s /f");
			system("pause>null");
		}

		// desliga pela ultima vez, independente se for sábado ou domingo
		if (((agora.tm_hour == *desligar.hora2) && (agora.tm_min >= *desligar.minutos2)))
		{
			// processo de desligar
			system("shutdown /s /f");
			system("pause>null");
		}

		// VERIFICAR CONEXAO COM A INTERNET
		/*
		verifica conexao com a internet usando o comando ping

		Caso use um Roteador:
		para o ping funcionar corretamente o proxy DNS do
		roteador deve estar desativado,
		deve ativar o DNS estatico e colocar primario 8.8.8.8
		e secundario 8.8.4.4, ISSO TUDO NA CONFIGURAÇÃO DO ROTEADOR.

		Mais ainda NO COMPUTADOR configure sua rede com numero de ip, sempre se atentar
		a habilitação do DNS cestático conforme o DNS primario e secundário acima
		descrito que é o servidor do google.
		*/
		// aloca os ponteiros
		desligar.conexao = new int;
		*desligar.conexao = system("ping www.google.com -n 1 > lastping"); // -n 1 é a quantidade de testes do ping, apenas 1 ping já e suficiente


		//Teste lógico se há conexão ou não
		if (*desligar.conexao == 0) { // sabendo que 0 é para conectado e 1 é para desconectado, os valores serão retornados do ping
			cout << ">>> Status da Internet: CONECTADO; Atualizado em: " << agora.tm_hour << "hs e " << agora.tm_min << "min <<<<<<< \r"; // imprime na tela as informações basicas se tem ou não internet e a hora da ultima verificação

				/* a.bat colocar sempre da raiz C: - esse bloco de comando IF é para o arquivo A.bat
				este arquivo BAT que são comandos em lote do MS-DOS faz o b.exe ser executado caso
				haja internet, como irá executar esse arquivo *.bet várias vezes, o codigo deste arquivo
				faz com que o b.exe seja executado e não seja executado novamente, evitando execuções
				duplicadas, caso o processo b.exe já esteja em execução, no final diz que o processo
				a.exe seja finalizado, caso não tenha o processo ativo retornará um erro mas só
				indicando que o processo a.exe nao existe

				>>>>>>>>codigos do arquivo está abaixo

				@ECHO OFF

				set PROC=b.exe
				set EXEPATH="C:\sistema\b.exe"

				TASKLIST /NH /FI "IMAGENAME eq %PROC%" | FIND /I "%PROC%" > NUL
				IF NOT %ERRORLEVEL%==0 start "" %EXEPATH%

				taskkill /f /im a.exe

				*/

				// cria uma instancia para executar o programa em lote *.bat de forma oculta
				HINSTANCE hInstance1;
			hInstance1 = ShellExecute(NULL, NULL, TEXT("C:\\sistema\\a.bat"), NULL, NULL, SW_HIDE);



		}
		else{
			cout << ">>> Status da Internet: DESCONECTADO; Atualizado em: " << agora.tm_hour << "hs e " << agora.tm_min << "min <<<<<<< \r"; // imprime na tela as informações basicas se tem ou não internet e a hora da ultima verificação

			/* b.bat colocar sempre da raiz C: - esse bloco de comando IF é para o arquivo B.bat
			este programa em lote *.bat abre o processo "a" e não permite que seja executado
			em duplicidade, melhor detalhado na descrição acima sobre o a.bat.
			no final fecha o programa b.exe caso esteja ativo retornando um
			erro indicativo caso esse processo nao exista, tambem melhor explicado
			no a.bat

			>>>>>>>>codigos do arquivo está abaixo

			@ECHO OFF

			set PROC=a.exe
			set EXEPATH="C:\sistema\a.exe"

			TASKLIST /NH /FI "IMAGENAME eq %PROC%" | FIND /I "%PROC%" > NUL
			IF NOT %ERRORLEVEL%==0 start "" %EXEPATH%

			taskkill /f /im b.exe

			*/

			// cria uma instancia para executar o programa em lote *.bat de forma oculta
			HINSTANCE hInstance2;
			hInstance2 = ShellExecute (NULL, NULL, TEXT("C:\\sistema\\b.bat"), NULL, NULL, SW_HIDE);


		}

		//desaloca memória do ponteiro
		delete desligar.conexao;

		//Esperar alguns segundos antes de continuar o ciclo
		std::this_thread::sleep_for(std::chrono::seconds(*desligar.ciclo));
	}

	// desalocar memória do ponteiro no termino do programa,
	//sendo que por ter um for infinito essa parte do programa
	//nunca será executada, mas é interessante ter mais para demonstrar
	//como o desalocamento de memoria dos ponteiros funcionam, pra efeito didatico
	delete desligar.ciclo;
	delete desligar.hora1;
	delete desligar.hora2;
	delete desligar.minutos1;
	delete desligar.minutos2;

	return 0;
	// retorna 0 a função main sinalizando que está tudo ok,
	//muito util na depuração caso tenha algum erro nos comandos acima,
	//sendo possivel identificar qual linha está o erro do programa,
	//espero que nunca de erro, caso de erro tem como identificar mais facilmente
	//graças ao parametro da função int main(int argc, char** argv)
}

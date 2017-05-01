import java.util.Scanner; // inserir dados através do console
import java.io.FileWriter; // Criar arquivo
import java.io.PrintWriter; // Inserir conteúdo ao arquivo

class EditConfig{
	
	// Variáveis do Banco de Dados
	private static Object hostname = new String(".");
	private static Object port = new String(".");
	private static Object database = new String(".");
	private static Object username = new String(".");
	private static Object password = new String(".");
	private static Object driver = new String(".");
	
	public static void main (String args[]){
	
	// Inserir dados às variáveis
	Scanner in = new Scanner(System.in);
		
	System.out.println("<Editar Configuração do Banco de Dados MySQL>====================================\n");
	
	System.out.print("Insira o hostname: ");
	hostname = in.next();
	
	System.out.print("Insira a porta do hostname: ");
	port = in.next();
		
	System.out.print("Insira o database: ");
	database = in.next();
	
	System.out.print("Insira o username: ");
	username = in.next();
	
	System.out.print("Insira o password: ");
	password = in.next();
	
	System.out.print("Insira o Driver do Banco de Dados (Class.forName): ");
	driver = in.next();
	
	// Criar arquivo referente as variáveis
	try{
		
		FileWriter arquivo_host = new FileWriter("hostname.config");
		PrintWriter inserir_host = new PrintWriter(arquivo_host);
		inserir_host.print(hostname);
		arquivo_host.close();
		
		FileWriter arquivo_porta = new FileWriter("port.config");
		PrintWriter inserir_porta = new PrintWriter(arquivo_porta);
		inserir_porta.print(port);
		arquivo_porta.close();
		
		FileWriter arquivo_database = new FileWriter("database.config");
		PrintWriter inserir_db = new PrintWriter(arquivo_database);
		inserir_db.print(database);
		arquivo_database.close();
		
		FileWriter arquivo_username = new FileWriter("username.config");
		PrintWriter inserir_user = new PrintWriter(arquivo_username);
		inserir_user.print(username);
		inserir_user.close();
		
		FileWriter arquivo_password = new FileWriter("password.config");
		PrintWriter inserir_passwrd = new PrintWriter(arquivo_password);
		inserir_passwrd.print(password);
		arquivo_password.close();
		
		FileWriter arquivo_driver = new FileWriter("driver.config");
		PrintWriter inserir_driver = new PrintWriter(arquivo_driver);
		inserir_driver.print(driver);
		arquivo_driver.close();		
		
		
		System.out.println("Arquivos de configuração gerados....");
	}catch(Exception e){
		System.out.println("Erro ao gerar arquivos de configuração...");
		System.out.println(e);
		}
		
	// Desalocar as variáveis da memória dinamica
	hostname = null;
	database = null;
	username = null;
	password = null;
	driver = null;
	
	Runtime.getRuntime().gc();

		
		
	}
	
}

import java.io.FileReader; // Ler Arquivo
import java.io.BufferedReader; // Ler Buffer do arquivo

public class config{
	
	
	public static String getHost(){

		String hostname = "";

		try{
			FileReader arquivo = new FileReader("hostname.config");
			BufferedReader ler = new BufferedReader(arquivo);
			
			hostname = ler.readLine();
			
			arquivo.close();
				
		}catch(Exception e){System.out.println(e);}
		
		return hostname;
	}
	
	
	public static String getPort(){
		String port = "";
		
		try{
			FileReader arquivo = new FileReader("port.config");
			BufferedReader ler = new BufferedReader(arquivo);
			
			port = ler.readLine();
			
			arquivo.close();
			
			
		}catch(Exception e){System.out.println(e);}
		return port;
	}
	
	public static String getDB(){
		String database = "";
		
		try{
			FileReader arquivo = new FileReader("database.config");
			BufferedReader ler = new BufferedReader(arquivo);
			
			database = ler.readLine();
			
			arquivo.close();
			
			
		}catch(Exception e){System.out.println(e);}
		return database;
	}

	public static String getUser(){
		String username = "";
		
		try{
			FileReader arquivo = new FileReader("username.config");
			BufferedReader ler = new BufferedReader(arquivo);
			
			username = ler.readLine();
			
			arquivo.close();
			
			
		}catch(Exception e){System.out.println(e);}
		return username;
	}
	
	public static String getPass(){
		String password = "";
		
		try{
			FileReader arquivo = new FileReader("password.config");
			BufferedReader ler = new BufferedReader(arquivo);
			
			password = ler.readLine();
			
			arquivo.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return password;
	}
	
	public static String getDriver(){
		String driver = "";
		
		try{
			FileReader arquivo = new FileReader("driver.config");
			BufferedReader ler = new BufferedReader(arquivo);
			
			driver = ler.readLine();
			
			arquivo.close();
			
		}catch(Exception e){System.out.println(e);}
		return driver;
	}
	
	public static void main (String[] args){
		
		String x = getDriver();
		
		System.out.println(x);
		
		
	}
	
	
	
	
	
	
	
	
}

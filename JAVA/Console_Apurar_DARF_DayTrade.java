
// DayTrade.java

import java.util.Scanner;

class DayTrade{
	
	public static void main (String args[]){
		
		// Variaveis
		Integer contador, i;
		Double valor = 0.0;
		Double DARF = 0.0;
		String GuiaDARF;
				
		// Acessa a Class config
		config invest = new config();
		
		// Cria entrada de dados
		Scanner in = new Scanner(System.in);
		
		// Limpar a Tela
		for (i=0; i<50; i++){
			System.out.print("\n");
		}
		
		// Exibe Informações da Class pelo toString
		System.out.println(invest);
		
		// Entrada de Dados
		
		System.out.print("Quantidade de Notas Corretagens a ser inseridas: ");
		contador = in.nextInt();
		
		i = 0;
		while(i<=(contador-1)){
			
			System.out.print("Insira o Valor Liquido da Nota "+(i+1)+": ");
			valor = in.nextDouble();
			
			DARF = DARF + valor;
			i++;
			
		}
		
		
		// Limpar a Tela
		for (i=0; i<50; i++){
			System.out.print("\n");
		}
		
		// Exibe Informações da Class pelo toString
		System.out.println(invest);
		
		GuiaDARF = "DARF \nCodigo da Receita: "+invest.getCodigo()+
		"\nPeriodo de Apuração: "+invest.getApuracao()+
		"\nVencimento: "+invest.getVencimento()+
		"\nValor Principal: "+String.format("%.2f",invest.IR(DARF));
		
		
		System.out.println(GuiaDARF);

		
		
		
	}
	
}

// config.java

public class config{
	
	private double taxaImposto = 0.2;
	private int codigo = 6015; //Codigo da Receita
	private String apuracao = "Último dia do mês anterior (mês das operações)"; //Periodo de Apuração
	private String vencimento = "Último dia do mês atual (mês de pagamento)"; //Vencimento
	

	//Valor Principal - usa-se o campo Valor Liquido da Nota na Nota Corretagem
	public double IR (double Valor_liquido_da_Nota){
		
		double calc;
		
		calc = Valor_liquido_da_Nota*this.taxaImposto;
		
		if (calc<0){
			calc = 0;
			
			System.out.println("ATENÇÂO - Não houve Lucro \n");
			}
		
		return calc;
		
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getApuracao(){
		return this.apuracao;
	}
	
	public String getVencimento(){
		return this.vencimento;
	}
	

	@Override
	public String toString(){

		// Exibe Titulo	
		String Titulo, Texto, Espaco, exibir;
		
		Titulo = "< DayTrade >=================================================================== \n";
		 Texto = "****************** Calcula o valor do Imposto de Renda a ser pago ************* \n";
		Espaco = "------------------------------------------------------------------------------- \n";
		
		exibir = Titulo+Texto+Espaco;
		
		return exibir;
		
	}
	
}

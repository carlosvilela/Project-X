import java.io.FileWriter; // Criar Arquivo
import java.io.PrintWriter; // Imprimir escrita dentro do arquivo / inserir conteudo no arquivo

import java.util.Date; // pegar data atual
import java.text.SimpleDateFormat; // formatar data


public class GerarRelatorio{
	
	// Variáveis - Receitas e Despesas
	private static String Modulo = new String(".");
	private static String AnoBase = new String(".");
	private static String GeradoEm = new String(".");
	private static String Objetivo = new String(".");
	private static String Apuracao = new String(".");
	private static String Programacao = new String(".");
	private static String Sistema = new String(".");
	
	private static String SituacaoFinanceira = new String(".");
	private static String Observacoes = new String(".");
	
	private static String Saldo = new String(".");
	private static Double Receitas = new Double(0.0);
	private static Double Despesas = new Double(0.0);
	
	private static Double Receitas_Salario = new Double(0.0);
	private static Double Receitas_Aluguel = new Double(0.0);
	private static Double Receitas_13Salario = new Double(0.0);
	private static Double Receitas_Investimentos = new Double(0.0);
	private static Double Receitas_Outros = new Double(0.0);

	private static Double Despesas_Moradia = new Double(0.0);
	private static Double Despesas_Educacao = new Double(0.0);
	private static Double Despesas_Transporte = new Double(0.0);
	private static Double Despesas_Alimentacao_Saude_Lazer = new Double(0.0);
	private static Double Despesas_Outros = new Double(0.0);



	public static void main (String args[]){
	CriarCSS();
	GerarRelatorio("ReceitasDespesas");
	}
	
	
	// Gerar Relatorio com dos dados obtidos
	public static void GerarRelatorio(String modulo){
		
		switch (modulo){
			
			case ("ReceitasDespesas"):
				
				Date DataAtual = new Date(); // Data Atual
				SimpleDateFormat Data_Ano = new SimpleDateFormat("yyyy"); // formata para mostrar o Ano Atual
				SimpleDateFormat Data_Atual = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat Data_MesAtual = new SimpleDateFormat("MMMMM 'de' yyyy");
				
					Modulo = modulo;
					AnoBase = Data_Ano.format(DataAtual);
					GeradoEm = Data_Atual.format(DataAtual);
					Objetivo = "Relatorio Simplificado sobre a Receita e Despesa das Financas Pessoais";
					Apuracao = Data_MesAtual.format(DataAtual);
					Programacao = "Mensal";
					Sistema = "Gerenciador Financeiro";

			
				CalcularReceitasDespesas(
					1000.0, 100.0, 10.00, 5.0, 1.0,
					500.0, 300.0, 100.0, 50.0, 30.0
					);
				
				break;
				
			default:
				
				System.out.println("Erro: Há erro relacionado ao comando GerarRelatorio no parametro String Modulo");
		}
	}
	
	
	// Lógica - Calculo das Receitas e Despesas
	private static void CalcularReceitasDespesas(
	Double Receita_Salario, Double Receita_Aluguel, Double Receita_13Salario, Double Receita_Investimentos, Double Receita_Outros,
	Double Despesa_Moradia, Double Despesa_Educacao, Double Despesa_Transporte, Double Despesa_Alimentacao_Saude_Lazer, Double Despesa_Outros){
	
	// Variáveis
	Double Calc_Saldo = new Double (0.0);
	Double Calc_Saldo_Total = new Double (0.0);
	Double Calc_Saldo_Percentual = new Double(0.0);
	
	Double Calc_Saldo_Percentual_Receita_Salario = new Double(0.0);
	Double Calc_Saldo_Percentual_Receita_Aluguel = new Double(0.0);
	Double Calc_Saldo_Percentual_Receita_13Salario = new Double(0.0);
	Double Calc_Saldo_Percentual_Receita_Investimentos = new Double(0.0);
	Double Calc_Saldo_Percentual_Receita_Outros = new Double(0.0);


	Double Calc_Saldo_Percentual_Despesa_Moradia = new Double(0.0);
	Double Calc_Saldo_Percentual_Despesa_Educacao = new Double(0.0);
	Double Calc_Saldo_Percentual_Despesa_Transporte = new Double(0.0);
	Double Calc_Saldo_Percentual_Despesa_Alimentacao_Saude_Lazer = new Double(0.0);
	Double Calc_Saldo_Percentual_Despesa_Outros = new Double(0.0);
	
	// Variaveis sobre a Logica
	Double Saldo_Nivelado = new Double (0.0); // Saldo Nivelado, nem lucro e nem prejuizo
	Double Saldo_Regular = new Double (20.00); // Saldo Regular entre 20% a 30%
	Double Saldo_Favoravel = new Double (30.0); // Saldo Favorável acima de 30%

	Double Despesas_Regular = new Double (80.0); // Despesas Regular de 70 a 80%
	Double Despesas_Favoravel = new Double (70.0); // Despesas Favorável abaixo de 70%
	
	// Atribuir valores as variáveis
	Receitas_Salario = Receita_Salario;
	Receitas_Aluguel = Receita_Aluguel;
	Receitas_13Salario = Receita_13Salario;
	Receitas_Investimentos = Receita_Investimentos;
	Receitas_Outros = Receita_Outros;
	
	// Calculos das Receitas e Despesas
	Receitas = Receitas_Salario + Receitas_Aluguel + Receitas_13Salario + Receitas_Investimentos + Receitas_Outros;
	
	Despesas_Moradia = Despesa_Moradia;
	Despesas_Educacao = Despesa_Educacao;
	Despesas_Transporte = Despesa_Transporte;
	Despesas_Alimentacao_Saude_Lazer = Despesa_Alimentacao_Saude_Lazer;
	Despesas_Outros = Despesa_Outros;
	
	Despesas = Despesas_Moradia + Despesas_Educacao + Despesas_Transporte + Despesas_Alimentacao_Saude_Lazer + Despesas_Outros;
	
	
	Calc_Saldo = Receitas - Despesas;
	Calc_Saldo_Total = Receitas;

	Calc_Saldo_Percentual = (Calc_Saldo/ (Receitas))*100;
	
	
	Calc_Saldo_Percentual_Receita_Salario = (Receitas_Salario/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Receita_Aluguel = (Receitas_Aluguel/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Receita_13Salario = (Receitas_13Salario/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Receita_Investimentos = (Receitas_Investimentos/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Receita_Outros = (Receitas_Outros/Calc_Saldo_Total)*100;


	Calc_Saldo_Percentual_Despesa_Moradia = (Despesas_Moradia/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Despesa_Educacao = (Despesas_Educacao/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Despesa_Transporte = (Despesas_Transporte/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Despesa_Alimentacao_Saude_Lazer = (Despesas_Alimentacao_Saude_Lazer/Calc_Saldo_Total)*100;
	Calc_Saldo_Percentual_Despesa_Outros = (Despesas_Outros/Calc_Saldo_Total)*100;

	// Lógica do Saldo
	if (Calc_Saldo_Percentual>Saldo_Favoravel) // Saldo Favorável
	{
		SituacaoFinanceira = "<font color=\"blue\">Adequado a Investimentos.</font>";
		Observacoes = "Invista seu dinheiro conforme seu Perfil de Investidor"; 
		Saldo = "Saldo Favorável acima de 30% ("+String.format("%.2f",Calc_Saldo_Percentual)+"%)";
	}else{
		if (Calc_Saldo_Percentual>=Saldo_Regular) // Saldo Regular
		{
			SituacaoFinanceira = "<font color=\"blue\">Adequado a Reserva Financeira.</font>";
			Observacoes = "Realize uma Reserva Financeira de preferencia em Renda Fixa com Liquidez Diária"; 
			Saldo = "Saldo Regular entre 20% a 30% ("+String.format("%.2f",Calc_Saldo_Percentual)+"%)";
		}else{
		if (Calc_Saldo_Percentual>=Saldo_Nivelado) //Atenção
		{
			SituacaoFinanceira = "<font color=\"brown\">Atenção! Cuidado para não se endividar, Faça Reserva Financeira.</font>";
			Observacoes = "Poupe seu dinheiro, faça uma reserva de segurança em Renda Fixa com Liquidez Diária"; 
			Saldo = "<font color=\"brown\">Atenção! Saldo Abaixo de 20% ("+String.format("%.2f",Calc_Saldo_Percentual)+"%)</font>";
		}else{// Perigo
			SituacaoFinanceira = "<font color=\"red\">Perigo! Suas despesas são maiores que suas receitas.</font>";
			Observacoes = "Verifique suas despesas e identifique quais gastos podem ser cortados"; 
			Saldo = "<font color=\"red\">Perigo! Saldo Negativo ("+String.format("%.2f",Calc_Saldo_Percentual)+"%)</font>";
		}
		}
		
	}
	
	
	// Logica das Receitas
	
	
	
	
	
	// Gerar Relatório				
	CriarRelatorio();
		
	}
	
	
	
		
	
	// criar o arquivo de formatação CSS
	private static void CriarCSS(){
	
		try{
	
			FileWriter arquivo = new FileWriter("relatorio.css");
			PrintWriter inserir = new PrintWriter(arquivo);
	
			inserir.println("/* Font Definitions */");
		    inserir.println("@font-face");
			inserir.println("{font-family:Wingdings;");
			inserir.println("panose-1:5 0 0 0 0 0 0 0 0 0;}");
			inserir.println("@font-face");
			inserir.println("{font-family:Wingdings;");
			inserir.println("panose-1:5 0 0 0 0 0 0 0 0 0;}");
			inserir.println("@font-face");
			inserir.println("{font-family:Tahoma;");
			inserir.println("panose-1:0 0 0 0 0 0 0 0 0 0;}");
			inserir.println("@font-face");
			inserir.println("{font-family:\"Arial Black\";");
			inserir.println("panose-1:2 11 10 4 2 1 2 2 2 4;}");
			inserir.println("/* Style Definitions */");
			inserir.println("p.MsoNormal, li.MsoNormal, div.MsoNormal");
			inserir.println("{margin-top:6.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:6.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:justify;");
			inserir.println("font-size:8.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println("h1");
			inserir.println("{margin-top:3.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:0cm;");
			inserir.println("margin-left:0cm;");
			inserir.println("margin-bottom:.0001pt;");
			inserir.println("text-align:center;");
			inserir.println("page-break-after:avoid;");
			inserir.println("font-size:8.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("font-weight:normal;}");
			inserir.println("h3");
			inserir.println("{margin-top:0cm;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:12.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:justify;");
			inserir.println("page-break-after:avoid;");
			inserir.println("font-size:6.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";}");
			inserir.println("p.MsoHeader, li.MsoHeader, div.MsoHeader");
			inserir.println("{margin-top:6.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:6.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:justify;");
			inserir.println("font-size:8.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println("p.MsoFooter, li.MsoFooter, div.MsoFooter");
			inserir.println("{margin-top:9.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:6.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:justify;");
			inserir.println("font-size:8.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;");
			inserir.println("font-weight:bold;}");
			inserir.println("p.MsoBodyText, li.MsoBodyText, div.MsoBodyText");
			inserir.println("{margin-top:6.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:6.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:justify;");
			inserir.println("font-size:12.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println("p.MsoBodyText3, li.MsoBodyText3, div.MsoBodyText3");
			inserir.println("{margin-top:6.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:6.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:justify;");
			inserir.println("font-size:10.0pt;");
			inserir.println("font-family:\"Times New Roman\",\"serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println("p.MsoAcetate, li.MsoAcetate, div.MsoAcetate");
			inserir.println("{mso-style-link:\"Texto de balão Char\";");
			inserir.println("margin:0cm;");
			inserir.println("margin-bottom:.0001pt;");
			inserir.println("text-align:justify;");
			inserir.println("font-size:8.0pt;");
			inserir.println("font-family:\"Tahoma\",\"sans-serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println("p.BoxText, li.BoxText, div.BoxText");
			inserir.println("{mso-style-name:\"Box Text\";");
			inserir.println("margin-top:3.0pt;");
			inserir.println("margin-right:4.3pt;");
			inserir.println("margin-bottom:3.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("font-size:10.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;}");
			inserir.println("p.Headingpg2, li.Headingpg2, div.Headingpg2");
			inserir.println("{mso-style-name:\"Heading pg 2\";");
			inserir.println("margin-top:6.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:6.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:center;");
			inserir.println("page-break-after:avoid;");
			inserir.println("font-size:10.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";}");
			inserir.println("p.BoxTitle, li.BoxTitle, div.BoxTitle");
			inserir.println("{mso-style-name:\"Box Title\";");
			inserir.println("margin-top:0cm;");
			inserir.println("margin-right:.75pt;");
			inserir.println("margin-bottom:0cm;");
			inserir.println("margin-left:0cm;");
			inserir.println("margin-bottom:.0001pt;");
			inserir.println("text-align:center;");
			inserir.println("font-size:8.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;");
			inserir.println("font-style:italic;}");
			inserir.println("p.BoxHeader, li.BoxHeader, div.BoxHeader");
			inserir.println("{mso-style-name:\"Box Header\";");
			inserir.println("margin:0cm;");
			inserir.println("margin-bottom:.0001pt;");
			inserir.println("text-align:center;");
			inserir.println("font-size:14.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;");
			inserir.println("font-weight:bold;}");
			inserir.println("p.FormHeader, li.FormHeader, div.FormHeader");
			inserir.println("{mso-style-name:\"Form Header\";");
			inserir.println("margin-top:0cm;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:6.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("font-size:10.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;");
			inserir.println("font-weight:bold;}");
			inserir.println("p.MainTitle, li.MainTitle, div.MainTitle");
			inserir.println("{mso-style-name:\"Main Title\";");
			inserir.println("margin-top:6.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:18.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:center;");
			inserir.println("page-break-after:avoid;");
			inserir.println("font-size:8.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println("p.BodyTextBullet, li.BodyTextBullet, div.BodyTextBullet");
			inserir.println("{mso-style-name:\"Body Text Bullet\";");
			inserir.println("margin-top:3.0pt;");
			inserir.println("margin-right:4.3pt;");
			inserir.println("margin-bottom:3.0pt;");
			inserir.println("margin-left:18.0pt;");
			inserir.println("text-indent:-18.0pt;");
			inserir.println("font-size:10.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;}");
			inserir.println("p.BoxTextTitle2, li.BoxTextTitle2, div.BoxTextTitle2");
			inserir.println("{mso-style-name:\"Box Text Title2\";");
			inserir.println("margin-top:3.0pt;");
			inserir.println("margin-right:4.3pt;");
			inserir.println("margin-bottom:3.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:center;");
			inserir.println("font-size:11.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;");
			inserir.println("font-weight:bold;}");
			inserir.println("p.BoxHeaderLeft, li.BoxHeaderLeft, div.BoxHeaderLeft");
			inserir.println("{mso-style-name:\"Box Header Left\";");
			inserir.println("margin:0cm;");
			inserir.println("margin-bottom:.0001pt;");
			inserir.println("font-size:12.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;");
			inserir.println("font-weight:bold;}");
			inserir.println("p.BoxTextLarge, li.BoxTextLarge, div.BoxTextLarge");
			inserir.println("{mso-style-name:\"Box Text Large\";");
			inserir.println("margin-top:3.0pt;");
			inserir.println("margin-right:4.3pt;");
			inserir.println("margin-bottom:3.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("font-size:12.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("layout-grid-mode:line;}");
			inserir.println("p.MainHeading, li.MainHeading, div.MainHeading");
			inserir.println("{mso-style-name:\"Main Heading\";");
			inserir.println("margin-top:6.0pt;");
			inserir.println("margin-right:0cm;");
			inserir.println("margin-bottom:12.0pt;");
			inserir.println("margin-left:0cm;");
			inserir.println("text-align:center;");
			inserir.println("page-break-after:avoid;");
			inserir.println("font-size:16.0pt;");
			inserir.println("font-family:\"Arial\",\"sans-serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println("span.TextodebaloChar");
			inserir.println("{mso-style-name:\"Texto de balão Char\";");
			inserir.println("mso-style-link:\"Texto de balão\";");
			inserir.println("font-family:\"Tahoma\",\"sans-serif\";");
			inserir.println("font-weight:bold;}");
			inserir.println(".MsoChpDefault");
			inserir.println("{font-size:10.0pt;}");
			inserir.println("/* Page Definitions */");
			inserir.println("@page WordSection1");
			inserir.println("{size:612.0pt 792.0pt;");
			inserir.println("margin:54.0pt 54.0pt 36.0pt 54.0pt;}");
			inserir.println("div.WordSection1");
			inserir.println("{page:WordSection1;}");
			inserir.println("/* List Definitions */");
			inserir.println("ol");
			inserir.println("{margin-bottom:0cm;}");
			inserir.println("ul");
			inserir.println("{margin-bottom:0cm;}");
	
			arquivo.close();
			
			// desalocar memória
			arquivo = null;
			inserir = null;
			
			Runtime.getRuntime().gc(); // chamar coletor
		
	}catch(Exception e){System.out.println(e);}
		
	}
	
	// Criar o arquivo HTML do Relatório
	private static void CriarRelatorio(){
	
	Double _Saldo_ = Receitas-Despesas;
	Double Calc_Saldo_Total = Receitas;
	Double Calc_Saldo_Percentual_Despesa_Moradia = (Despesas_Moradia/Calc_Saldo_Total)*100;
	Double Calc_Saldo_Percentual_Despesa_Educacao = (Despesas_Educacao/Calc_Saldo_Total)*100;
	Double Calc_Saldo_Percentual_Despesa_Transporte = (Despesas_Transporte/Calc_Saldo_Total)*100;
	Double Calc_Saldo_Percentual_Despesa_Alimentacao_Saude_Lazer = (Despesas_Alimentacao_Saude_Lazer/Calc_Saldo_Total)*100;
	Double Calc_Saldo_Percentual_Despesa_Outros = (Despesas_Outros/Calc_Saldo_Total)*100;
		
		try{
		
			FileWriter arquivo = new FileWriter("Relatorio_ReceitasDespesas.html");
			PrintWriter inserir = new PrintWriter(arquivo);
			
			// Cabeçalho
			inserir.println("<html><head>");
			inserir.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"><meta name=\"Generator\" content=\"Microsoft Word 14 (filtered)\">");
			inserir.println("<link href=\"config_relatorio/relatorio.css\" rel=\"stylesheet\"><title>Relatorio Financeiro</title></head>");
			inserir.println("<body><center><div class=\"WordSection1\">");


			// Informações sobre o Relatório
			inserir.println("<p class=\"MainHeading\"><span lang=\"EN-US\" style=\"font-size:12.0pt\"><b>RELA&Oacute;RIO FINANCEIRO</b></span></p>");
			inserir.println("<table class=\"MsoNormalTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin-left:6.75pt;border-collapse:collapse\">");

			inserir.println("<tbody>");
			inserir.println("<tr style=\"height:21.55pt\"> <td width=\"160\" style=\"width:120.15pt;padding:0cm 5.4pt 0cm 5.4pt;height:21.55pt\">");
			inserir.println("<p class=\"BoxHeaderLeft\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">M&oacute;dulo: <b>"+Modulo+"</b></span></p>");
			inserir.println("</td>");
			inserir.println("<td width=\"506\" valign=\"top\" style=\"width:379.85pt;padding:0cm 5.4pt 0cm 5.4pt; height:21.55pt\">");
			inserir.println("<p class=\"BoxTextLarge\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">&nbsp;</span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:21.55pt\"><td width=\"160\" style=\"width:120.15pt;padding:0cm 5.4pt 0cm 5.4pt;height:21.55pt\">");
			inserir.println("<p class=\"BoxHeaderLeft\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">Ano Base: <b>"+AnoBase+"</b></span></p>");
			inserir.println("</td>");
			inserir.println("<td width=\"506\" valign=\"top\" style=\"width:379.85pt;padding:0cm 5.4pt 0cm 5.4pt; height:21.55pt\">");
			inserir.println("<p class=\"BoxTextLarge\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">&nbsp;</span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:21.55pt\"><td width=\"160\" style=\"width:120.15pt;padding:0cm 5.4pt 0cm 5.4pt;height:21.55pt\">");
			inserir.println("<p class=\"BoxHeaderLeft\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">Gerado em: <b>"+GeradoEm+"</b></span></p>");
			inserir.println("</td>");

			inserir.println("<td width=\"506\" valign=\"top\" style=\"width:379.85pt;padding:0cm 5.4pt 0cm 5.4pt; height:21.55pt\">");
			inserir.println("<p class=\"BoxTextLarge\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">Objetivo: <b>"+Objetivo+"</b></span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:12.15pt\"><td width=\"160\" style=\"width:120.15pt;padding:0cm 5.4pt 0cm 5.4pt;height:12.15pt\">");
			inserir.println("<p class=\"BoxHeaderLeft\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">Apura&ccedil;&atilde;o: <br><b>"+Apuracao+"</b></span></p>");
			inserir.println("</td>");

			inserir.println("<td width=\"506\" valign=\"top\" style=\"width:379.85pt;padding:0cm 5.4pt 0cm 5.4pt; height:12.15pt\">");
			inserir.println("<p class=\"BoxTextLarge\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">&nbsp;</span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:12.15pt\"><td width=\"160\" style=\"width:120.15pt;padding:0cm 5.4pt 0cm 5.4pt;height:12.15pt\">");
			inserir.println("<p class=\"BoxHeaderLeft\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">Programa&ccedil;&atilde;o: <b>"+Programacao+"</b></span></p>");
			inserir.println("</td>");

			inserir.println("<td width=\"506\" valign=\"top\" style=\"width:379.85pt;padding:0cm 5.4pt 0cm 5.4pt; height:12.15pt\">");
			inserir.println("<p class=\"BoxTextLarge\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">Sistema: <b>"+Sistema+"</b></span></p>");
			inserir.println("</td></tr>");
			inserir.println("</tbody></table>");

			// Observações
			inserir.println("<p class=\"MsoHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">&nbsp;</span></p>");
			inserir.println("<table class=\"MsoNormalTable\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin-left:6.75pt;border-collapse:collapse;border:none\">");
			inserir.println("<tbody><tr style=\"height:20.0pt\"><td width=\"668\" style=\"width:501.3pt;border:solid windowtext 1.0pt;background: #DFDFDF;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BoxHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\"><b>OBSERVA&Ccedil;&Otilde;ES RELEVANTES</b></span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:20.0pt\"><td width=\"668\" valign=\"top\" style=\"width:501.3pt;border:solid windowtext 1.0pt; border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BodyTextBullet\" style=\"margin-left:0cm;text-indent:0cm\"><span lang=\"EN-US\">Situacao Financeira:<b>"+SituacaoFinanceira+"</b><br>");
			inserir.println("OBS: <b>"+Observacoes+"</b><br>");
			inserir.println("</span></p>");
			inserir.println("</td></tr></tbody></table>");

			// Situação Financeira
			inserir.println("<p class=\"MsoHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">&nbsp;</span></p>");
			inserir.println("<table class=\"MsoNormalTable\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"670\" style=\"width:502.65pt;margin-left:6.75pt;border-collapse:collapse;border:none\">");
			inserir.println("<tbody><tr style=\"height:20.0pt\"><td width=\"322\" style=\"width:241.65pt;border:solid windowtext 1.0pt;background: #DFDFDF;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BoxHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\"><b>SALDO FINANCEIRO</b></span></p>");
			inserir.println("</td>");

			inserir.println("<td width=\"186\" style=\"width:139.5pt;border:solid windowtext 1.0pt;border-left: none;background:#DFDFDF;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BoxHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\"><b>RECEITAS</b></span></p>");
			inserir.println("</td>");

			inserir.println("<td width=\"162\" style=\"width:121.5pt;border:solid windowtext 1.0pt;border-left: none;background:#DFDFDF;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BoxHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\"><b>DESPESAS</b></span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:20.0pt\"><td width=\"322\" valign=\"top\" style=\"width:241.65pt;border:solid windowtext 1.0pt; border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BodyTextBullet\" style=\"text-indent:-14.4pt\"><span lang=\"EN-US\" style=\"font-family:Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\"><b><font color=\"blue\">"+Saldo+"</font></b></span></span><span lang=\"EN-US\">&nbsp;</span></p>");
			inserir.println("</td>");

			inserir.println("<td width=\"186\" valign=\"top\" style=\"width:139.5pt;border-top:none;border-left: none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt; padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BodyTextBullet\" style=\"text-indent:-14.4pt\"><span lang=\"EN-US\" style=\"font-family:Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\"><b><font color=\"blue\">R$ "+Receitas+"</font></b></span></span><span lang=\"EN-US\">&nbsp;</span></p>");
			inserir.println("</td>");

			inserir.println("<td width=\"162\" valign=\"top\" style=\"width:121.5pt;border-top:none;border-left: none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt; padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BodyTextBullet\" style=\"text-indent:-14.4pt\"><span lang=\"EN-US\" style=\"font-family:Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\"><b><font color=\"red\">R$ "+Despesas+"</font></b></span></span><span lang=\"EN-US\">&nbsp;</span></p>");
			inserir.println("</td></tr></tbody></table>");
			
			inserir.println("<td width=\"162\" valign=\"top\" style=\"width:121.5pt;border-top:none;border-left: none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt; padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BodyTextBullet\" style=\"text-indent:-14.4pt\"><span lang=\"EN-US\" style=\"font-family:Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\"><b><font color=\"brown\">Saldo R$ "+String.format("%.2f",_Saldo_)+"</font></b></span></span><span lang=\"EN-US\">&nbsp;</span></p>");
			inserir.println("</td></tr></tbody></table>");


			// Receitas Apuradas
			inserir.println("<p class=\"MsoNormal\"><span lang=\"EN-US\" style=\"font-size:10.0pt;font-weight:normal\">&nbsp;</span></p>");
			inserir.println("<table class=\"MsoNormalTable\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin-left:6.75pt;border-collapse:collapse;border:none\">");
			inserir.println("<tbody><tr style=\"height:20.0pt\"><td width=\"668\" style=\"width:501.3pt;border:solid windowtext 1.0pt;background: #DFDFDF;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BoxHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\"><b>RECEITAS APURADAS</b></span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:20.0pt\">");
			inserir.println("<td width=\"668\" valign=\"top\" style=\"width:501.3pt;border:solid windowtext 1.0pt; border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("SAL&Aacute;RIO: R$ "+Receitas_Salario+"");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("ALUGUEL: R$ "+Receitas_Aluguel+"");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("13 SAL&Aacute;RIO: R$ "+Receitas_13Salario+"");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("INVESTIMENTOS: R$ "+Receitas_Investimentos+"");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("OUTROS: R$ "+Receitas_Outros+"");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("</td></tr>");
			inserir.println("</tbody></table>");
			
			// Despesas Apuradas
			inserir.println("<p class=\"MsoNormal\"><span lang=\"EN-US\" style=\"font-size:10.0pt;font-weight:normal\">&nbsp;</span></p>");
			inserir.println("<table class=\"MsoNormalTable\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin-left:6.75pt;border-collapse:collapse;border:none\">");
			inserir.println("<tbody><tr style=\"height:20.0pt\"><td width=\"668\" style=\"width:501.3pt;border:solid windowtext 1.0pt;background: #DFDFDF;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");
			inserir.println("<p class=\"BoxHeader\"><span lang=\"EN-US\" style=\"font-size:10.0pt\"><b>DESPESAS APURADAS</b></span></p>");
			inserir.println("</td></tr>");

			inserir.println("<tr style=\"height:20.0pt\">");
			inserir.println("<td width=\"668\" valign=\"top\" style=\"width:501.3pt;border:solid windowtext 1.0pt; border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:20.0pt\">");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("MORADIA: <b>R$ "+Despesas_Moradia+" ("+String.format("%.2f",Calc_Saldo_Percentual_Despesa_Moradia)+"%)</b> - max 35% R$ "+String.format("%.2f",(Receitas*0.35))+" ("+String.format("%.2f",((Receitas*0.35)-Despesas_Moradia))+")");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("EDUCA&Ccedil;&Atilde;O: <b>R$ "+Despesas_Educacao+" ("+String.format("%.2f",Calc_Saldo_Percentual_Despesa_Educacao)+"%)</b> - max 20% R$ "+String.format("%.2f",(Receitas*0.20))+" ("+String.format("%.2f",((Receitas*0.20)-Despesas_Educacao))+")");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("TRANSPORTE: <b>R$ "+Despesas_Transporte+" ("+String.format("%.2f",Calc_Saldo_Percentual_Despesa_Transporte)+"%)</b> - max 5% R$ "+String.format("%.2f",(Receitas*0.05))+" ("+String.format("%.2f",((Receitas*0.05)-Despesas_Transporte))+")");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("ALIMENTA&Ccedil;&Atilde;O/SA&Uacute;DE/LAZER: <b>R$ "+Despesas_Alimentacao_Saude_Lazer+" ("+String.format("%.2f",Calc_Saldo_Percentual_Despesa_Alimentacao_Saude_Lazer)+"%)</b> - max 35% R$ "+String.format("%.2f",(Receitas*0.35))+" ("+String.format("%.2f",((Receitas*0.35)-Despesas_Alimentacao_Saude_Lazer))+")");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("<p class=\"BodyTextBullet\"><span lang=\"EN-US\" style=\"font-size:8.0pt;font-family: Wingdings\">Ø<span style=\"font:12.0pt &quot;Times New Roman&quot;\">");
			inserir.println("OUTROS: <b>R$ "+Despesas_Outros+" ("+String.format("%.2f",Calc_Saldo_Percentual_Despesa_Outros)+"%)</b> - max 5% R$ "+String.format("%.2f",(Receitas*0.05))+" ("+String.format("%.2f",((Receitas*0.05)-Despesas_Outros))+")");
			inserir.println("&nbsp;</span></span><span lang=\"EN-US\">&nbsp;</span></p>");

			inserir.println("</td></tr>");
			inserir.println("</tbody></table>");
			
			// FIM
			inserir.println("<p class=\"MsoNormal\"><span lang=\"EN-US\" style=\"font-size:10.0pt\">&nbsp;</span></p>");
			inserir.println("</div></center></body></html>");

		arquivo.close();
				
		// Desalocar Memória - gerador de arquivo
		arquivo = null;
		inserir = null;
		
		// Desalocar Memória - Variaveis Globais
			Modulo = null;
			AnoBase = null;
			GeradoEm = null;
			Objetivo = null;
			Apuracao = null;
			Programacao = null;
			Sistema = null;
	
			SituacaoFinanceira = null;
			Observacoes = null;
	
			Saldo = null;
			Receitas = null;
			Despesas = null;
	
			Receitas_Salario = null;
			Receitas_Aluguel = null;
			Receitas_13Salario = null;
			Receitas_Investimentos = null;
			Receitas_Outros = null;

			Despesas_Moradia = null;
			Despesas_Educacao = null;
			Despesas_Transporte = null;
			Despesas_Alimentacao_Saude_Lazer = null;
			Despesas_Outros = null;

		
		// chamar coletor
		Runtime.getRuntime().gc();
		
		}catch(Exception e){System.out.println(e);}
		
	}
		
}

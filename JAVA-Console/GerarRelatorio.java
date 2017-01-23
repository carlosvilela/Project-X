import java.io.FileWriter; // Criar Arquivo
import java.io.PrintWriter; // Imprimir escrita dentro do arquivo / inserir conteudo no arquivo


public class GerarRelatorio{
	
	public static void main (String args[]){
	CriarCSS();
	}	
	
	
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
	
	
	
	
	
	
}

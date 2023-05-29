package action;

import java.sql.Date;
import java.util.ArrayList;

import beans.Article;
import beans.ArticleStock;
import beans.Commande;
import beans.UserManagement;
import dao.DaoFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class CommandeActions {
	private  ArrayList<Commande> commandes = null;

	public ArrayList<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}


	private Integer codeCmd;
	private String client;
	private Integer codeArt;
	private Integer qteCmd;
	private String dateCmd;
	public String getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(String dateCmd) {
		this.dateCmd = dateCmd;
	}
	public Integer getCodeCmd() {
		return codeCmd;
	}
	public void setCodeCmd(Integer codeCmd) {
		this.codeCmd = codeCmd;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Integer getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(Integer codeArt) {
		this.codeArt = codeArt;
	}
	public Integer getQteCmd() {
		return qteCmd;
	}
	public void setQteCmd(Integer qteCmd) {
		this.qteCmd = qteCmd;
	}
	
public String findAllcommend() {
		
		commandes =(ArrayList<Commande>) DaoFactory.getInstance().getCommandeDao().findAll();
		
		return "SUCCESS";
	}
	
	
public String addCommande() {
		
		Commande u = new Commande();
		try{
			//u.setCodeUser(2);
	
			u.setCodeCmd(codeCmd);
			u.setClient(client);
			u.setCodeArt(codeArt);
			u.setQteCmd(qteCmd);
			u.setDateCmd(dateCmd);
			//System.out.println("iyyy");	
			if(codeCmd !=null && client!=null && codeArt!=null && qteCmd!=null && dateCmd !=null ) {
			DaoFactory.getInstance().getCommandeDao().insert(u);
			//System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffffffff" +codeArt);
			ArticleStock A =  DaoFactory.getInstance().getArticleStorDao().find(codeArt);
			A.setQteArt(A.getQteArt()-qteCmd);
			//System.out.println(A.getQteArt());
			System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffffffff :  "+A.getQteArt());
		    DaoFactory.getInstance().getArticleStorDao().update(A);
		    u.setCodeCmd(null);
			}
			return "SUCCES";
		}catch(Exception e) {
			//return "ERROR";
			return "SUCCES";
		}
	}



public String delete() {
	Commande u = new Commande();
	try{
		//u.setCodeUser(2);

		u.setCodeCmd(codeCmd);
		u.setClient(client);
		u.setCodeArt(codeArt);
		u.setQteCmd(qteCmd);
		u.setDateCmd(dateCmd);
		DaoFactory.getInstance().getCommandeDao().delete(u);
		return "SUCCES";
	}catch(Exception e) {
		return "SUCCES";
	}
}

public String update() {
	Commande u = new Commande();
	try{
		//u.setCodeUser(2);

		u.setCodeCmd(codeCmd);
		u.setClient(client);
		u.setCodeArt(codeArt);
		u.setQteCmd(qteCmd);
		u.setDateCmd(dateCmd);
		DaoFactory.getInstance().getCommandeDao().update(u);
	
	return "SUCCES";
}catch(Exception e) {
	return "ERROR";
}
}










public String gereFact() {
	System.out.println("cree Pdf");
	try {
		if(codeArt!=null) {
			Commande c = new Commande();
			c.setClient(client);
			c.setCodeArt(codeArt);
			c.setCodeCmd(codeCmd);
			c.setDateCmd(dateCmd);
			c.setQteCmd(qteCmd);
			Article a = DaoFactory.getInstance().getArticleDao().find(codeArt);
			System.out.println(c.toString());
		Generate_pdf.pdf(c , a);
		}
	}catch(Exception e) {
		//return "ERROR";
		return "SUCCES";
	}
	
	return "SUCCES";
}
	


public void creePdf() throws MalformedURLException, IOException {

    Document document = new Document();
    try
    {
  	  Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
  	  Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
  	  Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
       PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Fact.pdf"));
       document.open();
       document.setMargins(10,10, 100, 100);
       
       // table info
       PdfPTable table = new PdfPTable(5); // 3 columns.
       table.setWidthPercentage(100); //Width 100%
       table.setSpacingBefore(10f); //Space before table
       table.setSpacingAfter(10f); //Space after table
       // table Total
       PdfPTable tableTotal = new PdfPTable(1); // 3 columns.
       tableTotal.setWidthPercentage(30); //Width 100%
       tableTotal.setSpacingBefore(1f); //Space before table
       tableTotal.setSpacingAfter(1f); //Space after table
        
       PdfPCell cell1 = new PdfPCell(new Paragraph("CodeProduit"));
       //cell1.setBorderColor(BaseColor.BLUE);
       cell1.setPaddingLeft(10);
       cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

       PdfPCell cell2 = new PdfPCell(new Paragraph("Produit"));
      // cell2.setBorderColor(BaseColor.GREEN);
      
       cell2.setPaddingLeft(10);
       cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

       PdfPCell cell3 = new PdfPCell(new Paragraph("Description"));
       //cell3.setBorderColor(BaseColor.RED);
       cell3.setPaddingLeft(10);
       cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
       
       PdfPCell cell4 = new PdfPCell(new Paragraph("Quantite"));
      // cell4.setBorderColor(BaseColor.RED);
       cell4.setPaddingLeft(10);
       cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

       PdfPCell cell5 = new PdfPCell(new Paragraph("Prix/Unit"));
       //cell5.setBorderColor(BaseColor.RED);
       cell5.setPaddingLeft(10);
       cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
       
       PdfPCell cell6 = new PdfPCell(new Paragraph("Total"));
       //cell6.setBorderColor(BaseColor.RED);
       cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
       
       
       PdfPCell cell7 = new PdfPCell(new Paragraph("100$"));
      // cell7.setBorderColor(BaseColor.RED);
       cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

       //To avoid having the cell border and the content overlap, if you are having thick cell borders
       //cell1.setUserBorderPadding(true);
       //cell2.setUserBorderPadding(true);
       //cell3.setUserBorderPadding(true);
       PdfPCell cell;
       cell = new PdfPCell();
       cell.setRowspan(5);
      // table.addCell(cell);
      

       
       table.addCell(cell1);
       table.addCell(cell2);
       table.addCell(cell3);
       table.addCell(cell4);
       table.addCell(cell5);
       
       // row
       table.addCell("code");
       table.addCell("prodoit");
       table.addCell("desc");
       table.addCell("Qinti");
       table.addCell("Prix");
       
       tableTotal.addCell(cell6);
       tableTotal.addCell(cell7);
       

       //Add Image
       Image image1 = Image.getInstance(".\\\\src\\\\main\\\\webapp\\\\img.png");

       //Fixed Positioning
      // image1.setAbsolutePosition(100f, 550f);
      
       //Scale to new height and new width of image
       image1.scaleAbsolute(70, 70);
      // image1.scalePercent(100f);
       image1.setAlignment(image1.MIDDLE);
       //Add to document
       document.add(image1);
       
       
       
       
       
       Paragraph p = new Paragraph();
       p.add("This is my paragraph 1");
       p.setAlignment(Element.ALIGN_CENTER);
       p.setExtraParagraphSpace(10);
       document.add(p);

       Paragraph p2 = new Paragraph();
       p2.add("This is my paragraph 2  :                                                 	 "+codeCmd); //no alignment
       p2.setAlignment(Element.ALIGN_CENTER);
       document.add(p2);

       Font f = new Font();
       f.setStyle(Font.BOLD);
       f.setSize(8);
      // f.setAlignment(Element.ALIGN_CENTER);
       Paragraph p3 = new Paragraph("This is my paragraph 3  :                                                   name");
       p3.setAlignment(Element.ALIGN_CENTER);
       document.add(p3);
       
       
       
       
       
       
       Paragraph chapterTitle = new Paragraph("factora",redFont);
      Chapter chapter1 = new Chapter(chapterTitle, 1);
      //chapterTitle.setAlignment(Element.ALIGN_CENTER);
      chapter1.setNumberDepth(10);
       
       
       
       document.add(chapterTitle);
      
       document.add(table);
       document.add(tableTotal);
       
       
      
       
      
       
       
       document.close();
       writer.close();
    } catch (DocumentException e)
    {
       e.printStackTrace();
    } catch (FileNotFoundException e)
    {
       e.printStackTrace();
       System.out.print("nono");
    }
}
	
}

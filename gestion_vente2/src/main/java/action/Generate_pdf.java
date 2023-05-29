package action;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import beans.Article;
import beans.Commande;
 
public class Generate_pdf
{

   
   public static void pdf(Commande c , Article a) throws MalformedURLException, IOException {
	   int counter = 1;
       String filePath = "C:\\Users\\Administrator\\Desktop\\jee_project_final\\Fact.pdf";
       String baseDirectory = filePath.substring(0, filePath.lastIndexOf("\\") + 1);
       String baseFileName = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.lastIndexOf("."));

       // Check if the file already exists
       File file = new File(filePath);
       while (file.exists()) {
           // Generate a new file name by appending a counter to the base file name
           String newFileName = baseFileName + "_" + counter + ".pdf";
           filePath = baseDirectory + newFileName;
           file = new File(filePath);
           counter++;
       }
	   Document document = new Document();
	      try
	      {
	    	  Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
	    	  Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	    	  Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
	    	  System.out.print("nono");
	    	  PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
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
	          
	         PdfPCell cell1 = new PdfPCell(new Paragraph("Product code"));
	         //cell1.setBorderColor(BaseColor.BLUE);
	         cell1.setPaddingLeft(8);
	         cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell2 = new PdfPCell(new Paragraph("Product"));
	        // cell2.setBorderColor(BaseColor.GREEN);
	        
	         cell2.setPaddingLeft(8);
	         cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell3 = new PdfPCell(new Paragraph("Description"));
	         //cell3.setBorderColor(BaseColor.RED);
	         cell3.setPaddingLeft(8);
	         cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell cell4 = new PdfPCell(new Paragraph("Quantity"));
	        // cell4.setBorderColor(BaseColor.RED);
	         cell4.setPaddingLeft(8);
	         cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell5 = new PdfPCell(new Paragraph("Price/Unit"));
	         //cell5.setBorderColor(BaseColor.RED);
	         cell5.setPaddingLeft(8);
	         cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell cell6 = new PdfPCell(new Paragraph("Total"));
	         //cell6.setBorderColor(BaseColor.RED);
	         cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         
	         PdfPCell cell7 = new PdfPCell(new Paragraph((a.getPrixArt()*c.getQteCmd())+"DH"));
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
	         table.addCell(c.getCodeCmd()+"");
	         table.addCell(c.getCodeArt()+"");
	         table.addCell(a.getDescArt()+"");
	         table.addCell(c.getQteCmd()+"");
	         table.addCell(a.getPrixArt()+"DH");
	         
	         tableTotal.addCell(cell6);
	         tableTotal.addCell(cell7);
	         
	      // Add Image
	         Image image1 = Image.getInstance("C:\\Users\\Administrator\\Desktop\\jee_project_final\\images1.jpeg");

	         // Calculate document dimensions
	         float documentWidth = document.getPageSize().getWidth();
	         float documentHeight = document.getPageSize().getHeight();


	      // Calculate image dimensions
	      float imageWidth = image1.getScaledWidth();
	      float imageHeight = image1.getScaledHeight();

	         


	         // Calculate image position
	         float imageX = (documentWidth - imageWidth) / 2;
	         float imageY = (documentHeight - imageHeight) / 2;

	         // Fixed Positioning
	         image1.setAbsolutePosition(imageX, imageY);

	        

	         // Add empty lines
	         document.add(new Paragraph("\n")); // First empty line
	         document.add(new Paragraph("\n")); // Second empty line

	         // Add to document
	         document.add(image1);

	         Paragraph p = new Paragraph();
	         p.add("Facture");
	         p.setAlignment(Element.ALIGN_CENTER);
	         p.setExtraParagraphSpace(10);
	         document.add(p);

	         Paragraph p2 = new Paragraph();
	         p2.add("Client  : "+c.getClient()); //no alignment
	         p2.setAlignment(Element.ALIGN_CENTER);
	         document.add(p2);

	         Font f = new Font();
	         f.setStyle(Font.BOLD);
	         f.setSize(8);
	        // f.setAlignment(Element.ALIGN_CENTER);
	         Paragraph p3 = new Paragraph("Date de Commande  : "+c.getDateCmd());
	         p3.setAlignment(Element.ALIGN_CENTER);
	         document.add(p3);
	         
	         
	         
	         
	         
	         
	         Paragraph chapterTitle = new Paragraph("Code de Commade : "+c.getCodeCmd(),redFont);
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


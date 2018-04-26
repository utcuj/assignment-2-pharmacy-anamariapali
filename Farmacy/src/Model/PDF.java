package Model;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;




public class PDF implements Report {
     public static Document document = new Document(PageSize.A4, 50, 50, 50, 50);
     private  String filepath = "C:\\Users\\User\\eclipse-workspace\\farmacie\\Medication.pdf";
    private  PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filepath));

    public PDF() throws FileNotFoundException, DocumentException {
    }

    @Override
    public void generateReport(String name,String ingredients) {
    	

        Anchor anchorTarget = new Anchor("Medication out of stock:");
        anchorTarget.setName("BackToTop");
        document.open();
        Paragraph paragraph1 = new Paragraph();

        paragraph1.setSpacingBefore(50);

        paragraph1.add(anchorTarget);
        try {
        	//PdfWriter.getInstance(document, new FileOutputStream(filepath));
            document.add(paragraph1);
            document.add(new Paragraph("\nMedicamentul:"+name+" care are ingredientele : " +ingredients+" nu mai este in stoc!\n",
                FontFactory.getFont(FontFactory.COURIER, 14, Font.ITALIC, new CMYKColor(0, 255, 255, 0))));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
       // catch (FileNotFoundException e) {
         //   e.printStackTrace();
       // }
        
      // document.close();
        
    }
}

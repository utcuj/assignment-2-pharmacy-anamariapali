package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class CSV implements Report {
    private PrintWriter pw ;
    private StringBuilder sb = new StringBuilder();
    @Override
    public void generateReport(String title,String author) {
        String filepath = "C:\\Users\\User\\eclipse-workspace\\farmacie\\Medication1.csv";
        try {
            pw = new PrintWriter(new File(filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      
        
        sb.append("Nume:");
        sb.append(',');
        sb.append(title);
        sb.append('\n');

        sb.append("Producator:");
        sb.append(',');
        sb.append(author);
        sb.append('\n');
         
        pw.write(sb.toString());
        pw.flush();
        pw.close();
    }
}
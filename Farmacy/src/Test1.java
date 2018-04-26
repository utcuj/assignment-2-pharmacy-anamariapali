import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import com.itextpdf.text.DocumentException;

import Controler.AdminControl;
import Model.Medication;
import Model.User;
import View.AdminView;
import View.Display;

class Test1 {

	@Test
	void test() throws FileNotFoundException, DocumentException {
		//fail("Not yet implemented");
		
		Medication m= new Medication();
		//m.addMedication("13", "Medicament2", "ingrediente", "producator", 11, 19);
		Medication m2= m.searchMedication("Medicament2");
		assertEquals("Medicament2",m2.getName());
	   m.sellMedication("Medicament2", 1);
		Medication m4= m.searchMedication("Medicament2");
		int n=m4.getQuantity();
		assertEquals(18,n);
		m.updateMedication("Medicament2", 20, 10);
		Medication m3= m.searchMedication("Medicament2");
		int nr =m3.getQuantity();
		int p=m3.getPrice();
	    assertEquals(10,p);
		assertEquals(20,nr);
	}

}

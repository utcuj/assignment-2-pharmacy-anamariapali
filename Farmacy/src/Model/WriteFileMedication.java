package Model;


import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class WriteFileMedication {
	public void scriereFis(String fis, ArrayList<Medication> c){
		try{
			
			System.out.println(" Aici ");
			DocumentBuilderFactory dF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dF.newDocumentBuilder();
			Document d = dB.newDocument();
			Element el = d.createElement("catalog");
			d.appendChild(el);
			
			for(int i=0; i<c.size(); i++){
				
				//lista de elemente
				Element e = d.createElement("medication");
				el.appendChild(e);
				
				//seteaza atributele in lista de elemente
				Attr atr = d.createAttribute("id");
				atr.setValue(c.get(i).getID());
				e.setAttributeNode(atr);
				
				Element name = d.createElement("name");
				name.appendChild(d.createTextNode(c.get(i).getName()));
				e.appendChild(name);
				
				Element ingredients= d.createElement("ingredients");
				ingredients.appendChild(d.createTextNode(c.get(i).getIngredients()));
				e.appendChild(ingredients);
				
				Element manufacturer = d.createElement("manufacturer");
				manufacturer.appendChild(d.createTextNode(c.get(i).getManufacturer()));
				e.appendChild(manufacturer);
				
				Element cant = d.createElement("quantity");
				cant.appendChild(d.createTextNode("" + c.get(i).getQuantity()));
				e.appendChild(cant);
				
				Element pret = d.createElement("price");
				pret.appendChild(d.createTextNode("" + c.get(i).getPrice()));
				e.appendChild(pret);
				
				//scrie in fis xml
				TransformerFactory tF = TransformerFactory.newInstance();
				Transformer t = tF.newTransformer();
				DOMSource s = new DOMSource(d);
				StreamResult res = new StreamResult(fis);
			
				t.transform(s, res);
				System.out.println("Scriere Medication");
			}
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}
}


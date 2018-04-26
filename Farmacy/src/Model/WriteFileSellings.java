package Model;

import java.io.File;
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

public class WriteFileSellings {
	public void scriereFis(String fis, ArrayList<Medication> c){
		try{
			
			System.out.println(" Aici ");
			DocumentBuilderFactory dF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dF.newDocumentBuilder();
			Document d = dB.newDocument();
			Element el = d.createElement("sellings");
			d.appendChild(el);
			
			for(int i=0; i<c.size(); i++){
				
				//lista de elemente
				Element e = d.createElement("sell");
				el.appendChild(e);
				
				//seteaza atributele in lista de elemente
				Attr atr = d.createAttribute("id");
				atr.setValue(c.get(i).getID());
				e.setAttributeNode(atr);
				
				Element name = d.createElement("name");
				name.appendChild(d.createTextNode(c.get(i).getName()));
				e.appendChild(name);
				
				
				
				Element cant = d.createElement("quantity");
				cant.appendChild(d.createTextNode("" +c.get(i).getQuantity()));
				e.appendChild(cant);
				
				Element pret = d.createElement("price");
				pret.appendChild(d.createTextNode("" + c.get(i).getPrice()));
				e.appendChild(pret);
				
				//scrie in fis xml
				TransformerFactory tF = TransformerFactory.newInstance();
				Transformer t = tF.newTransformer();
				DOMSource s = new DOMSource(d);
				StreamResult res = new StreamResult(new File(fis));
			
				t.transform(s, res);
				System.out.println("Scriere Sellings");
			}
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}
}

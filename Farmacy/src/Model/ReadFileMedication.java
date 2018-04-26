package Model;
import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadFileMedication {
	
		
		ArrayList<Medication> list = new ArrayList<Medication>();
		
		public ReadFileMedication(String fis)
		{
			parseFile(fis);
		}
		public void parseFile(String fis){
			try{
				File fxml =new File(fis);
				
				DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
				DocumentBuilder dB = dbF.newDocumentBuilder();
				Document d = dB.parse(fxml);
				
				d.getDocumentElement().normalize();
				NodeList nL = d.getElementsByTagName("medication");
				
				for(int i=0; i<nL.getLength();i++)
				{
					Node n = nL.item(i);
					Medication b=null;
					
					if(n.getNodeType() == Node.ELEMENT_NODE)
					{
						Element el= (Element) n;
						
						String id = el.getAttribute("id");
						String name = el.getElementsByTagName("name").item(0).getTextContent();
						String ingredients = el.getElementsByTagName("ingredients").item(0).getTextContent();
						String manufacturer = el.getElementsByTagName("manufacturer").item(0).getTextContent();
						
						String cant = el.getElementsByTagName("quantity").item(0).getTextContent();
						String pret = el.getElementsByTagName("price").item(0).getTextContent();
				
						
						b = new Medication(id,name,ingredients,manufacturer ,Integer.parseInt(cant), Integer.parseInt(pret));
					}
					list.add(b);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		public ArrayList<Medication> getList()
		{
			return this.list;
			
		}
	}



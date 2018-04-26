package Model;

import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadFileSellings {
	
	ArrayList<Medication> list = new ArrayList<Medication>();
	
	public ReadFileSellings(String fis)
	{
		parseFile(fis);
	}
	
	public ReadFileSellings(){}
	public void parseFile(String fis){
		try{
			File fxml =new File(fis);
			
			DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dbF.newDocumentBuilder();
			Document d = dB.parse(fxml);
			
			d.getDocumentElement().normalize();
			NodeList nL = d.getElementsByTagName("sell");
			
			for(int i=0; i<nL.getLength();i++)
			{
				Node n = nL.item(i);
				Medication b=null;
				
				if(n.getNodeType() == Node.ELEMENT_NODE)
				{
					Element el= (Element) n;
					
					String id = el.getAttribute("id");
					String name = el.getElementsByTagName("name").item(0).getTextContent();
					
					String quantity = el.getElementsByTagName("quantity").item(0).getTextContent();
					String price = el.getElementsByTagName("price").item(0).getTextContent();
					
					b=new Medication(id,name,Integer.parseInt(quantity),Integer.parseInt(price));
					
					
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
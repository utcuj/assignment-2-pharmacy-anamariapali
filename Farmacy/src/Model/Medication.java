package Model;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Medication {
	private String id;
	private String name;
	private String ingredients;
	private String manufacturer;
	private int quantity;
	private int price;
	
	public Medication(){}
	public Medication(String id,String n, String i,String m, int p,int q)
	{
		this.id=id;
		this.name=n;
		this.ingredients=i;
		this.manufacturer=m;
		this.quantity=q;
		this.price=p;
	}
	
	public Medication(String id,String n, int q, int p)
	{
		this.id=id;
		this.name=n;
	
		this.quantity=q;
		this.price=p;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getManufacturer()
	{
		return this.manufacturer;
	}
	
	public void setManufacturer(String m)
	{
		this.manufacturer=m;
	}
	public String getIngredients()
	{
		return this.ingredients;
	}

	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public void setQuantity(int q)
	{
		this.quantity=q;
	}
	
	public void setPrice(int p)
	{
		this.price=p;
	}
	
public void addMedication(String id,String n, String i,String m ,int q, int p){
	ReadFileMedication b =new ReadFileMedication("Medication.xml");
	ArrayList<Medication> list =b.getList();
	boolean ok= true;
	for(int j=0;j<list.size();j++)
	{
		if(list.get(j).getName().equals(n))
		{
			ok=false;
			list.get(j).setQuantity(list.get(j).getQuantity()+q);
		}
	}
	
	if(ok==true)
		list.add(new Medication(id,n,i,m,q,p));
	WriteFileMedication b1 = new WriteFileMedication();
	b1.scriereFis("Medication.xml", list);
	
	
}
	
	public void deleteMedication(String name){
		ReadFileMedication b =new ReadFileMedication("Medication.xml");
		ArrayList<Medication> list =b.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getName().equals(name))
			{
				list.remove(i);
			}
		}
		WriteFileMedication b1 = new WriteFileMedication();
		b1.scriereFis("Medication.xml", list);
	}
	
	public void updateMedication(String name, int p, int q){
		ReadFileMedication b =new ReadFileMedication("Medication.xml");
		ArrayList<Medication> list =b.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getName().equals(name))
			{
				list.get(i).setPrice(p);
				list.get(i).setQuantity(q);
			}
		}
		WriteFileMedication b1 = new WriteFileMedication();
		b1.scriereFis("Medication.xml", list);
	}
	
	public ArrayList<String> listMedication(){
		ReadFileMedication b =new ReadFileMedication("Medication.xml");
		ArrayList<Medication> lista =b.getList();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<lista.size();i++)
		{
			list.add(lista.get(i).getID()+"   "+lista.get(i).getName()+"   "+lista.get(i).getIngredients()+"   "+lista.get(i).getQuantity()+"   "+lista.get(i).getPrice());
		}
		return list;
	}
	public JTable viewAllMed() 
	{
          String[] rowData2 = new String[6];
          ReadFileMedication b =new ReadFileMedication("Medication.xml");
  		ArrayList<Medication> lista =b.getList();
    
       DefaultTableModel table1 = new DefaultTableModel();
       
       table1.addColumn("IdMed");
       table1.addColumn("Name");
       table1.addColumn("Manufacturer");
       table1.addColumn("Ingredients");
       table1.addColumn("Price");
       table1.addColumn("Quantity");
		
		  for(int j=0;j<lista.size();j++) 
		   
		 { 
		  rowData2[0]=lista.get(j).getID();
		  rowData2[1]=lista.get(j).getName();
		  rowData2[3]=lista.get(j).getManufacturer();
		  rowData2[4]=lista.get(j).getIngredients();
		  rowData2[5]= Integer.toString(lista.get(j).getPrice());
		  rowData2[3]=Integer.toString((lista.get(j).getQuantity()));
		 
		   table1.addRow(rowData2);
	
		 }
		  return new JTable(table1);
		 
	}
	
	public Medication searchMedication(String s)
	{
		ReadFileMedication b =new ReadFileMedication("Medication.xml");
		ArrayList<Medication> list =b.getList();
		
		Medication b1= null;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getName().equals(s) ||list.get(i).getIngredients().equals(s) ||list.get(i).getManufacturer().equals(s))	
			{
				b1=list.get(i);
			}
			 
		}
		return b1;
		
	}
	
	public void sellMedication(String n, int nr)
	{
		ReadFileMedication b =new ReadFileMedication("Medication.xml");
		ReadFileSellings sl = new ReadFileSellings("Selling.xml");
		
		ArrayList<Medication> list =b.getList();
		ArrayList<Medication> l =sl.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if((list.get(i).getName().equals(n))&& (list.get(i).getQuantity()>=nr))
			{
				
				int q = list.get(i).getQuantity();
				list.get(i).setQuantity(q-nr);
				Medication bk = new Medication(list.get(i).getID(),list.get(i).getName(),nr,list.get(i).getPrice()*nr);
				l.add(bk);
			}
			else 
			{
				System.out.println("Nu exista medicamentul sau nu mai este in stoc.");
			}
		}
		WriteFileSellings s=new WriteFileSellings();
		WriteFileMedication b1 = new WriteFileMedication();
		b1.scriereFis("Medication.xml", list);
		s.scriereFis("Selling.xml",l);
	}
}

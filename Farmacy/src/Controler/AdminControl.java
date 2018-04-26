package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import com.itextpdf.*;
import com.itextpdf.text.DocumentException;

import Model.*;
import View.AdminView;
import View.Display;

public class AdminControl {
	private AdminView adminpanel;
	private Medication m;
	private User u;
	private Display panel;
	private ReportFactory reportFactory = new ReportFactory();
    private Report report1 = reportFactory.getReport("PDF");
    private Report report2 = reportFactory.getReport("CSV");

	public AdminControl (AdminView adminpanel, Medication m, User u,Display panel) throws FileNotFoundException, DocumentException
	{
		this.adminpanel=adminpanel;
		this.m=m;
		this.u=u;
		this.panel=panel;
		
		this.adminpanel.addMedication(new addMedication());
		this.adminpanel.updateMedication(new updateMed());
		this.adminpanel.listMedication(new viewMed());
		this.adminpanel.deleteMedication(new deleteMed());
		
		this.adminpanel.addUsers(new adduser());
		this.adminpanel.updateUsers(new updateuser());
		this.adminpanel.deleteUsers(new deleteuser());
		this.adminpanel.listUsers(new viewusers());
		
		this.adminpanel.reportCSV(new reportcsv());
		this.adminpanel.reportPDF(new reportpdf());
	}
	public AdminControl () throws FileNotFoundException, DocumentException
	{
		this.adminpanel=adminpanel;
		this.m=m;
		this.u=u;
		this.panel=panel;
		
		this.adminpanel.addMedication(new addMedication());
		this.adminpanel.updateMedication(new updateMed());
		this.adminpanel.listMedication(new viewMed());
		this.adminpanel.deleteMedication(new deleteMed());
		
		this.adminpanel.addUsers(new adduser());
		this.adminpanel.updateUsers(new updateuser());
		this.adminpanel.deleteUsers(new deleteuser());
		this.adminpanel.listUsers(new viewusers());
		
		this.adminpanel.reportCSV(new reportcsv());
		this.adminpanel.reportPDF(new reportpdf());
	}
	
	class addMedication implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String name = adminpanel.getNameTextField();
			String ingredients=adminpanel.getIngredTextField();
			String manufacturer= adminpanel.getManufacturerTextField();
			int quantity = Integer.parseInt(adminpanel.getQuantityTextField());
			int price = Integer.parseInt(adminpanel.getPriceTextField());
			String id = adminpanel.getIdMedTextField();
			
			m.addMedication(id,name,ingredients,manufacturer,quantity, price);
			
		}
	}
	
	class deleteMed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String name=adminpanel.getNameTextField();
			
			m.deleteMedication(name);
		}
	}
	
	class updateMed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String name=adminpanel.getNameTextField();
			int q = Integer.parseInt(adminpanel.getQuantityTextField());
			int p = Integer.parseInt(adminpanel.getPriceTextField());
			
			m.updateMedication(name, p, q);
		}
	}
	
	class viewMed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String s="ID      Nume      Producator       Ingrediente      Cantitate       Pret"+"\n";
			ArrayList<String> list =m.listMedication();
			//frame1.setVisible(false);
			panel.getFrame().setVisible(true);
			for(int i = 0; i < list.size(); i++) {   
				s=s+list.get(i)+"    "+"\n";
				
			}
			panel.getTextArea().setText(s);
		}
	}
	
	class adduser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String id=adminpanel.getIdUserTextField();
			String username=adminpanel.getUsernameTextField();
			String password=adminpanel.getPasswordTextField();
			boolean isAdmin=Boolean.parseBoolean(adminpanel.getIsAdminTextField());
			
			u.addUser(id, username, password,isAdmin);
			
		}
	}
	
	class deleteuser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String username=adminpanel.getUsernameTextField();
			u.deleteUser(username);
			
		}
	}
	
	class updateuser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String id=adminpanel.getIdUserTextField();
			String username=adminpanel.getUsernameTextField();
			String password=adminpanel.getPasswordTextField();
			boolean isAdmin=Boolean.parseBoolean(adminpanel.getIsAdminTextField());
			
			u.updateUser(id, username, password, isAdmin);
		}
	}
	
	class viewusers implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String s="ID      Username      Password       isAdmin "+"\n";
			ArrayList<String> list = u.listUsers();
			//frame1.setVisible(false);
			panel.getFrame().setVisible(true);
			for(int i = 0; i < list.size(); i++) {   
				s=s+list.get(i)+"    "+"\n";
				
			}
			panel.getTextArea().setText(s);
			
		}
	}
	
	class reportpdf implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ReadFileMedication b =new ReadFileMedication("Medication.xml");
			ArrayList<Medication> list =b.getList();
			
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getQuantity()==0)
				{
					report1.generateReport(list.get(i).getName(), list.get(i).getIngredients());
				}
			}
			//PDF.document.close();
			
		}
		
	}
	
	class reportcsv implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ReadFileMedication b =new ReadFileMedication("Medication.xml");
			ArrayList<Medication> list =b.getList();
			
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getQuantity()==0)
				{
					report2.generateReport(list.get(i).getName(), list.get(i).getManufacturer());
				}
			}
		}
		
	}
}

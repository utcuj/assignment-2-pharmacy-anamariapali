package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Model.Medication;
import Model.User;
import View.UserView;
import View.Display;

public class UserControl {
	private UserView userpanel;
	private Medication m;
	private User u;
	private Display panel;
	
	public UserControl(UserView userpanel, Medication m, User u,Display panel)
	{
		this.userpanel=userpanel;
		this.m=m;
		this.u=u;
		this.panel=panel;
		
		this.userpanel.sellMedication(new sellMed());
		this.userpanel.searchMedication(new searchMed());
	}
	
	class sellMed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String n=userpanel.getUserMedicationTextField();
			int nr=Integer.parseInt(userpanel.getQMedTextField());
			m.sellMedication(n, nr);
		}
	}
	
	class searchMed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String med = userpanel.getUserMedicationTextField();
			Medication m1=m.searchMedication(med);
			String s;
			if(m1==null)
			{
				s="Nu exista medicamentul";		
			}
			else
			{
				s=m1.getID()+"   "+m1.getName()+"   "+m1.getManufacturer()+"   "+m1.getIngredients()+"   "+m1.getQuantity()+"   "+m1.getPrice();

			}
			panel.getFrame().setVisible(true);
			panel.getTextArea().setText(s);
		}
	}
}

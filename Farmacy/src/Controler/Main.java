package Controler;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import Controler.AdminControl;

import Controler.LogIn;
import Controler.UserControl;
import Model.Medication;
import Model.User;
import View.AdminView;
import View.Display;
import View.LoginView;
import View.UserView;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, DocumentException
	{
		//Models
		Medication m =new Medication();
		User u = new User();
		
		//Views
		AdminView adminpanel=new AdminView();
		UserView userpanel=new UserView();
		Display panel=new Display();
		LoginView logpanel = new LoginView();
		
		//Controll
		AdminControl adminC = new AdminControl(adminpanel, m, u, panel);
		UserControl userC=new UserControl(userpanel,m,u,panel);
		LogIn loginC = new LogIn(adminpanel,userpanel,u, logpanel);
		
		
		logpanel.getFrame().setVisible(true);
		
		
	}

}

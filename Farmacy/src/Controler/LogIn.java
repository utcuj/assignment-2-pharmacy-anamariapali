package Controler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.User;
import View.AdminView;
import View.Display;
import View.LoginView;
import View.UserView;

public class LogIn {
	private UserView userpanel;
	private User u;
	private AdminView adminpanel;
	private LoginView log;
	
	public LogIn(AdminView a, UserView up, User u, LoginView log)
	{
		this.userpanel=up;
		this.adminpanel=a;
		this.u=u;
		this.log=log;
		
		log.logIn(new login());
			
	}
	
	class login implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(u.login(log.getUsernameLog()).equals("Admin"))
			{
				adminpanel.getFrame().setVisible(true);
				log.getFrame().setVisible(false);
			}
			else{
				if(u.login(log.getUsernameLog()).equals("User"))
				userpanel.getFrame().setVisible(true);
				log.getFrame().setVisible(false);
			
		}
		}
	}
	
}

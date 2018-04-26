package Model;


import java.util.ArrayList;

public class User {
	private String id;
	private String username;
	private String password;
	private boolean admin;
	public User(String i,String u, String p, boolean a)
	{
		this.id=i;
		this.username=u;
		this.password=p;
		this.admin=a;
	}
	public User(){}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public boolean getAdmin()
	{
		return this.admin;
	}
	
	public void setUsername(String u)
	{
		this.username=u;
	}
	
	public void setPassword(String p){
		this.password=p;
	}
	
	public void setAdmin(boolean a)
	{
		this.admin=a;
	}
	public void addUser(String id ,String u, String p,boolean a){
		ReadFileUser b =new ReadFileUser("Users.xml");
		ArrayList<User> list =b.getList();
		
		list.add(new User(id, u, p, a));
		
		WriteFileUser b1 = new WriteFileUser();
		b1.scriereFis("Users.xml", list);
	}
	
	public void deleteUser(String u){
		ReadFileUser b =new ReadFileUser("Users.xml");
		ArrayList<User> list =b.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getUsername().equals(u))
			{
				list.remove(i);
			}
		}
		WriteFileUser b1 = new WriteFileUser();
		b1.scriereFis("Users.xml", list);
	}
	
	public void updateUser(String id,String u,String p, boolean a) {
		ReadFileUser b =new ReadFileUser("Users.xml");
		ArrayList<User> list =b.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getID().equals(id))
			{
				list.get(i).setUsername(u);
				list.get(i).setPassword(p);
				list.get(i).setAdmin(a);
			}
		}
		WriteFileUser b1 = new WriteFileUser();
		b1.scriereFis("Users.xml", list);
	}
	
	public ArrayList<String> listUsers() {
		ReadFileUser b =new ReadFileUser("Users.xml");
		ArrayList<User> lista =b.getList();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<lista.size();i++)
		{
			list.add(lista.get(i).getID()+"   "+lista.get(i).getUsername()+"   "+lista.get(i).getPassword()+"   "+lista.get(i).getAdmin());
		}
		return list;
		
	}
	

	public String login(String usern)
    {
		ReadFileUser b =new ReadFileUser("Users.xml");
		ArrayList<User> list =b.getList();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getUsername().equals(usern) && list.get(i).getAdmin()==true)
			{
				return "Admin";
			}
			else if(list.get(i).getUsername().equals(usern) && list.get(i).getAdmin()==false)
			{
				return "User";
			}
		}
        return "Eroare";
    }
}


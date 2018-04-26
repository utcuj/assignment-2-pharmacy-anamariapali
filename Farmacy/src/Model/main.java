package Model;
import java.util.ArrayList;

public class main {
	
public static void main(String[] args){
ReadFileUser u = new ReadFileUser("Users.xml");
ReadFileMedication b = new ReadFileMedication("Medication.xml");
WriteFileUser u1= new WriteFileUser();
ArrayList<User> u11= new ArrayList<User>();
u11.add(new User("5","diancl95@yahoo.com", "parola5", false));
u11.add(new User("6","diana_popa_cj@yahoo.com", "parola6", false));
u11.add(new User("7","ana", "parola7", true));
ArrayList<User> a=u.getList();
ArrayList<Medication> a1 = b.getList();
for(int i=0;i<a.size();i++)
{
	System.out.println(a.get(i).getID()+"  "+a.get(i).getUsername()+"  "+a.get(i).getPassword());
}

for(int i=0;i<a1.size();i++)
{
	System.out.println(a1.get(i).getName()+"  "+a1.get(i).getIngredients()+"  "+a1.get(i).getManufacturer()+"  "+Integer.toString(a1.get(i).getQuantity())+"  "+Integer.toString(a1.get(i).getPrice()));
}

u1.scriereFis("Users.xml", u11);

/*Medication b = new Medication();
b.addMedication("25", "Medicament1", "ingredients", "manufactor", 20, 25);
b.deleteMedication("Medicament1");
b.updateMedication("Medicament1", 10, 15);
b.sellMedication("Medicament1",5);
ArrayList<String> l =b.listMedication();
for(int i=0;i<l.size();i++)
{
	System.out.println(l.get(i));
}
*/
}
}
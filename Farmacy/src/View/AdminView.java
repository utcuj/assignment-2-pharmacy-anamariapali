package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView {

	private JFrame frame;
	private JTextField idmed;
	private JTextField name;
	private JTextField manufacturer;
	private JTextField ingredients;
	private JTextField quantity;
	private JTextField price;
	private JTextField iduser;
	private JTextField usern;
	private JTextField pass;
	private JTextField isAd;
	
	private JButton btnAddMedication;
	private JButton btnUpdateMedication;
	private JButton btnDeleteMedication;
	private JButton btnListMedication;
	
	private JButton btnAddUser;
	private JButton btnDeleteUser;
	private JButton btnUpdateUser;
	private JButton btnListUsers;
	
	private JButton btnC;
	private JButton btnPdf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 705, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		idmed = new JTextField();
		idmed.setBounds(130, 10, 116, 22);
		frame.getContentPane().add(idmed);
		idmed.setColumns(10);
		
		name = new JTextField();
		name.setBounds(130, 54, 116, 22);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		manufacturer = new JTextField();
		manufacturer.setBounds(130, 103, 116, 22);
		frame.getContentPane().add(manufacturer);
		manufacturer.setColumns(10);
		
		ingredients = new JTextField();
		ingredients.setBounds(130, 153, 116, 22);
		frame.getContentPane().add(ingredients);
		ingredients.setColumns(10);
		
		JLabel lblIdMed = new JLabel("ID Medication");
		lblIdMed.setBounds(33, 13, 56, 16);
		frame.getContentPane().add(lblIdMed);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(33, 57, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblMan = new JLabel("Manufacturer");
		lblMan.setBounds(33, 106, 56, 16);
		frame.getContentPane().add(lblMan);
		
		JLabel lblIng = new JLabel("Ingredients");
		lblIng.setBounds(33, 156, 56, 16);
		frame.getContentPane().add(lblIng);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(33, 211, 56, 16);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(33, 271, 56, 16);
		frame.getContentPane().add(lblPrice);
		
		quantity = new JTextField();
		quantity.setBounds(130, 208, 116, 22);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		price = new JTextField();
		price.setBounds(130, 268, 116, 22);
		frame.getContentPane().add(price);
		price.setColumns(10);
		
		btnAddMedication = new JButton("AddMedication");
		btnAddMedication.setBounds(12, 319, 97, 25);
		frame.getContentPane().add(btnAddMedication);
		
		btnDeleteMedication = new JButton("DeleteMedication");
		btnDeleteMedication.setBounds(12, 368, 107, 25);
		frame.getContentPane().add(btnDeleteMedication);
		
		btnUpdateMedication = new JButton("UpdateMedication");
		btnUpdateMedication.setBounds(149, 319, 106, 25);
		frame.getContentPane().add(btnUpdateMedication);
		
		btnListMedication = new JButton("ListMedication");
		btnListMedication.setBounds(149, 368, 97, 25);
		frame.getContentPane().add(btnListMedication);
		
		btnC = new JButton("CSV");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnC.setBounds(81, 454, 97, 25);
		frame.getContentPane().add(btnC);
		
		btnPdf = new JButton("PDF");
		btnPdf.setBounds(237, 454, 97, 25);
		frame.getContentPane().add(btnPdf);
		
		iduser = new JTextField();
		iduser.setBounds(511, 13, 116, 22);
		frame.getContentPane().add(iduser);
		iduser.setColumns(10);
		
		usern = new JTextField();
		usern.setBounds(511, 54, 116, 22);
		frame.getContentPane().add(usern);
		usern.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(511, 103, 116, 22);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		isAd = new JTextField();
		isAd.setBounds(511, 156, 116, 22);
		frame.getContentPane().add(isAd);
		isAd.setColumns(10);
		
		JLabel lblIdUser = new JLabel("ID user");
		lblIdUser.setBounds(400, 13, 56, 16);
		frame.getContentPane().add(lblIdUser);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(389, 57, 67, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(389, 106, 67, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblIsadmin = new JLabel("isAdmin");
		lblIsadmin.setBounds(389, 156, 67, 16);
		frame.getContentPane().add(lblIsadmin);
		
		btnAddUser = new JButton("Add user");
		btnAddUser.setBounds(359, 207, 97, 25);
		frame.getContentPane().add(btnAddUser);
		
		btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.setBounds(511, 207, 97, 25);
		frame.getContentPane().add(btnDeleteUser);
		
		btnUpdateUser = new JButton("Update user");
		btnUpdateUser.setBounds(359, 271, 107, 25);
		frame.getContentPane().add(btnUpdateUser);
		
		btnListUsers = new JButton("List users");
		btnListUsers.setBounds(511, 267, 97, 25);
		frame.getContentPane().add(btnListUsers);
	}
	
	public String getIdMedTextField()
	{
		return this.idmed.getText();
	}
	
	public String getNameTextField()
	{
		return this.name.getText();
	}
	
	public String getManufacturerTextField()
	{
		return this.manufacturer.getText();
	}
	
	public String getIngredTextField()
	{
		return this.ingredients.getText();
	}
	
	public String getQuantityTextField()
	{
		return this.quantity.getText();
	}
	
	public String getPriceTextField()
	{
		return this.price.getText();
	}
	
	public String getIdUserTextField()
	{
		return this.iduser.getText();
	}
	
	public String getUsernameTextField()
	{
		return this.usern.getText();
	}
	
	public String getPasswordTextField()
	{
		return this.pass.getText();
	}
	
	public String getIsAdminTextField()
	{
		return this.isAd.getText();
	}
	//BOOKS
	public void updateMedication(ActionListener metoda)
    {
        btnUpdateMedication.addActionListener(metoda);
    }
	
	public void addMedication(ActionListener metoda)
	{
		btnAddMedication.addActionListener(metoda);
	}
	
	public void deleteMedication(ActionListener metoda)
	{
		btnDeleteMedication.addActionListener(metoda);
	}
	
	public void listMedication(ActionListener metoda)
	{
		btnListMedication.addActionListener(metoda);
	}
	
	//USER
	public void updateUsers(ActionListener metoda)
    {
        btnUpdateUser.addActionListener(metoda);
    }
	
	public void addUsers(ActionListener metoda)
	{
		btnAddUser.addActionListener(metoda);
	}
	
	public void deleteUsers(ActionListener metoda)
	{
		btnDeleteUser.addActionListener(metoda);
	}
	
	public void listUsers(ActionListener metoda)
	{
		btnListUsers.addActionListener(metoda);
	}
	
	//Report
	public void reportCSV(ActionListener metoda)
	{
		btnC.addActionListener(metoda);
	}
	
	public void reportPDF(ActionListener metoda)
	{
		btnPdf.addActionListener(metoda);
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
}

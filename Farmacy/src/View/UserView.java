package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView {

	private JFrame frame;
	private JTextField userMed;
	private JTextField qMed;
	private JButton btnSearch;
	private JButton btnSell ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView window = new UserView();
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
	public UserView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 359, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userMed = new JTextField();
		userMed.setBounds(135, 41, 116, 22);
		frame.getContentPane().add(userMed);
		userMed.setColumns(10);
		
		JLabel lblMed = new JLabel("Medication");
		lblMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMed.setBounds(43, 40, 80, 22);
		frame.getContentPane().add(lblMed);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(26, 157, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSell.setBounds(148, 157, 116, 25);
		frame.getContentPane().add(btnSell);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(43, 99, 80, 22);
		frame.getContentPane().add(lblQuantity);
		
		qMed = new JTextField();
		qMed.setBounds(135, 100, 116, 22);
		frame.getContentPane().add(qMed);
		qMed.setColumns(10);
	}
	
	public String getQMedTextField()
	{
		return this.qMed.getText();
	}
	
	public String getUserMedicationTextField()
	{
		return this.userMed.getText();
	}
	
	public void sellMedication(ActionListener metoda)
	{
		btnSell.addActionListener(metoda); 
	}
	
	public void searchMedication(ActionListener metoda)
	{
		btnSearch.addActionListener(metoda); 
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
}

package it.unipv.po.bankSimulator.bankView;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BankerFrame extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 450;
	
	public BankerFrame(String name) {
		setTitle(name);
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(5, 1));
		
		//empty panels and labels are used to get a better looking layout
		JPanel emptyPanel1 = new JPanel();
		JPanel checkPanel = new JPanel(); //this panel allows to check the status of bank accounts
		JPanel addAccountPanel = new JPanel(); //this panel allows to add a new account
		JPanel operationPanel = new JPanel(); //this panel allows to perform operations
		JPanel emptyPanel2 = new JPanel();
		
		JButton checkButton = new JButton("Check the status of bank accounts"); //this button is used to 
		                                                                        //check the status of bank accounts
		checkPanel.add(checkButton);
		
		JTextField addAccountTextField = new JTextField(20); //insert here the fiscal code to create a new account
		JButton addAccountButton = new JButton("Add account"); //this button add a new account
		addAccountPanel.add(addAccountTextField);
		addAccountPanel.add(addAccountButton);
		
		JLabel ibanLabel = new JLabel("Insert iban here:    "); 
		JTextField ibanTextField = new JTextField(20); //insert here the iban of the account
		JLabel amountLabel = new JLabel("                        Insert amount here: ");
		JTextField amountTextField = new JTextField(20); //insert here the amount to add to/subtract from the account
		JLabel emptyLabel = new JLabel("                    ");
		JButton okButton = new JButton("  Ok  "); //this button performs the operation
		operationPanel.add(ibanLabel);
		operationPanel.add(ibanTextField);
		operationPanel.add(amountLabel);
		operationPanel.add(amountTextField);
		operationPanel.add(emptyLabel);
		operationPanel.add(okButton);
		
		panel.add(emptyPanel1);
		panel.add(checkPanel);
		panel.add(addAccountPanel);
		panel.add(operationPanel);
		panel.add(emptyPanel2);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);			
	}

}

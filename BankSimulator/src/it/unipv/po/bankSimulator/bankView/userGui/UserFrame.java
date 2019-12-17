package it.unipv.po.bankSimulator.bankView.userGui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserFrame extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	
	public UserFrame(String name) {
		setTitle(name + "'s user");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(4, 1));
		
		//empty panels and labels are used to get a better looking layout
		JPanel emptyPanel = new JPanel();
		JPanel createAccountPanel = new JPanel(); //allows to create a new account
		JPanel logInPanel = new JPanel(); //allows to log in and perform operations
		
		JLabel fiscalCodeLabel = new JLabel("               Fiscal code: ");
		JTextField fiscalCodeTextField = new JTextField(20); //enter the fiscal code here to create a new account
		JLabel emptyLabel1 = new JLabel("                ");
		JLabel setPasswordLabel = new JLabel("                    Set password: "); 
		JTextField setPasswordTextField = new JTextField(20); //enter the password to set here
		JLabel emptyLabel2 = new JLabel("                ");
		JButton createAccountButton = new JButton("    Create account    "); //creates a new account
		createAccountPanel.add(fiscalCodeLabel); createAccountPanel.add(fiscalCodeTextField);
		createAccountPanel.add(emptyLabel1); createAccountPanel.add(setPasswordLabel); createAccountPanel.add(setPasswordTextField); 
		createAccountPanel.add(emptyLabel2); createAccountPanel.add(createAccountButton);
		
		JLabel ibanLabel = new JLabel("            Iban: ");
		JTextField ibanTextField = new JTextField(20); //enter the iban here to log in
		JLabel emptyLabel3 = new JLabel("                    ");
		JLabel passwordLabel = new JLabel("                                  Password: ");
		JTextField passwordTextField = new JTextField(20); //enter the password here to log in
		JLabel emptyLabel4 = new JLabel("                                 ");
		JLabel amountLabel = new JLabel("                               Amount: ");
		JTextField amountTextField = new JTextField(20); //enter the amount to add to/subtract from the account here
		JLabel emptyLabel5 = new JLabel("                                 ");
		JButton submitButton = new JButton("       Submit operation      "); //performs the operation
		logInPanel.add(ibanLabel); logInPanel.add(ibanTextField); logInPanel.add(emptyLabel3);
		logInPanel.add(passwordLabel); logInPanel.add(passwordTextField); logInPanel.add(emptyLabel4); 
		logInPanel.add(amountLabel); logInPanel.add(amountTextField); logInPanel.add(emptyLabel5);
		logInPanel.add(submitButton);
		
		panel.add(emptyPanel); panel.add(createAccountPanel); panel.add(logInPanel);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation(5*screenWidth/8,screenHeight/4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}

}

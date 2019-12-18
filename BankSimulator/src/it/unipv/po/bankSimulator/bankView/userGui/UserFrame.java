package it.unipv.po.bankSimulator.bankView.userGui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserFrame extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	
	private JTextField fiscalCodeTextField;
	private JPasswordField setPasswordTextField;
	private JButton createAccountButton;
	
	private JTextField ibanTextField;
	private JPasswordField passwordTextField;
	private JButton logInButton;
	
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
		fiscalCodeTextField = new JTextField(20); //enter the fiscal code here to create a new account
		JLabel emptyLabel1 = new JLabel("                ");
		JLabel setPasswordLabel = new JLabel("                    Set password: "); 
		setPasswordTextField = new JPasswordField(20); //enter the password to set here
		JLabel emptyLabel2 = new JLabel("                ");
		createAccountButton = new JButton("    Create account    "); //creates a new account
		createAccountPanel.add(fiscalCodeLabel); createAccountPanel.add(fiscalCodeTextField);
		createAccountPanel.add(emptyLabel1); createAccountPanel.add(setPasswordLabel); createAccountPanel.add(setPasswordTextField); 
		createAccountPanel.add(emptyLabel2); createAccountPanel.add(createAccountButton);
		
		JLabel ibanLabel = new JLabel("                   IBAN: ");
		ibanTextField = new JTextField(20); //enter the iban here to log in
		JLabel emptyLabel3 = new JLabel("                              ");
		JLabel passwordLabel = new JLabel("                   Password: ");
		passwordTextField = new JPasswordField(20); //enter the password here to log in
		JLabel emptyLabel4 = new JLabel("                    ");
		logInButton = new JButton("       Log in      "); //performs the operation
		logInPanel.add(ibanLabel); logInPanel.add(ibanTextField); logInPanel.add(emptyLabel3);
		logInPanel.add(passwordLabel); logInPanel.add(passwordTextField); logInPanel.add(emptyLabel4);
		logInPanel.add(logInButton);
		
		panel.add(emptyPanel); panel.add(createAccountPanel); panel.add(logInPanel);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation(5*screenWidth/8,screenHeight/4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}

	public String getFiscalCode() {
		return fiscalCodeTextField.getText();
	}

	public JTextField getFiscalCodeTextField() {
		return fiscalCodeTextField;
	}

	@SuppressWarnings("deprecation")
	public String getSetPassword() {
		return setPasswordTextField.getText();
	}

	public JPasswordField getSetPasswordTextField() {
		return setPasswordTextField;
	}

	public JButton getCreateAccountButton() {
		return createAccountButton;
	}

	public String getIban() {
		return ibanTextField.getText();
	}

	public JTextField getIbanTextField() {
		return ibanTextField;
	}

	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passwordTextField.getText();
	}

	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public JButton getLogInButton() {
		return logInButton;
	}

}

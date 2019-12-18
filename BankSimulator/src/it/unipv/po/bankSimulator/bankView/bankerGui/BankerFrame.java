package it.unipv.po.bankSimulator.bankView.bankerGui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BankerFrame extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 525;
	
	private JButton checkButton;
	
	private JTextField fiscalCodeTextField;
	private JComboBox<String> accountTypeSelection;
	private JButton addAccountButton;
	
	private JTextField ibanTextField;
	private JTextField amountTextField;
	private JButton submitButton;
	
	public BankerFrame(String name) {
		setTitle(name + "'s banker");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(5, 1));
		
		//empty panels and labels are used to get a better looking layout
		JPanel emptyPanel1 = new JPanel();
		JPanel checkPanel = new JPanel(); //allows to check the status of bank accounts
		JPanel addAccountPanel = new JPanel(); //allows to add a new account
		JPanel operationPanel = new JPanel(); //allows to perform operations
		JPanel emptyPanel2 = new JPanel();
		
		checkButton = new JButton("Check the status of bank accounts"); //is used to check the
		                                                                //status of bank accounts
		checkPanel.add(checkButton);
		
		JLabel fiscalCodeLabel = new JLabel("     Fiscal code: ");
		fiscalCodeTextField = new JTextField(20); //enter the fiscal code here to create a new account
		String[] accountType = {"Bank account", "Deposit account", "Web account"};
		accountTypeSelection = new JComboBox<String>(accountType); //types of account that can be created
		addAccountButton = new JButton("Add account"); //adds a new account
		addAccountPanel.add(fiscalCodeLabel); addAccountPanel.add(fiscalCodeTextField);	addAccountPanel.add(accountTypeSelection);
		addAccountPanel.add(addAccountButton);
		
		JLabel emptyLabel1 = new JLabel("                                                                     "
				+ "                                               ");
		JLabel ibanLabel = new JLabel("                   IBAN:    "); 
		ibanTextField = new JTextField(20); //enter the iban of the account here
		JLabel amountLabel = new JLabel("                                           Amount: ");
		amountTextField = new JTextField(20); //enter the amount to add to/subtract from the account here
		JLabel emptyLabel2 = new JLabel("                    ");
		submitButton = new JButton("  Submit  "); //performs the operation
		operationPanel.add(emptyLabel1); operationPanel.add(ibanLabel);	operationPanel.add(ibanTextField);
		operationPanel.add(amountLabel); operationPanel.add(amountTextField); operationPanel.add(emptyLabel2);
		operationPanel.add(submitButton);
		
		panel.add(emptyPanel1); panel.add(checkPanel); panel.add(addAccountPanel); panel.add(operationPanel);
		panel.add(emptyPanel2);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation(screenWidth/8,screenHeight/4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);			
	}

	public JButton getCheckButton() {
		return checkButton;
	}

	public String getFiscalCode() {
		return fiscalCodeTextField.getText();
	}

	public JTextField getFiscalCodeTextField() {
		return fiscalCodeTextField;
	}

	public String getAccountType() {
		return (String)accountTypeSelection.getSelectedItem();
	}

	public JButton getAddAccountButton() {
		return addAccountButton;
	}
	
	public String getIban() {
		return ibanTextField.getText();
	}

	public JTextField getIbanTextField() {
		return ibanTextField;
	}

	public double getAmount() {
		return Double.parseDouble(amountTextField.getText());
	}

	public JTextField getAmountTextField() {
		return amountTextField;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

}

package it.unipv.po.bankSimulator.bankView.userGui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoggedInFrame extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 250;
	
	private String iban;
	
	private JButton checkAccountButton;
	
	private JTextField amountTextField;
	private JButton submitButton;
	
	public LoggedInFrame(String i) {
		iban = i;
		
		setTitle(iban);
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(4, 1));
		
		//empty panels and labels are used to get a better looking layout
		JPanel emptyPanel = new JPanel();
		JPanel checkAccountPanel = new JPanel(); //allows to check the balance of the account
		JPanel operationPanel = new JPanel(); //allows to perform operations
		
		checkAccountButton = new JButton("  Check account  "); //button to check the balance
		checkAccountPanel.add(checkAccountButton);
		
		JLabel amountLabel = new JLabel("Amount: ");
		amountTextField = new JTextField(20); //enter the amount to add to/subtract from the account here
		submitButton = new JButton("  Submit  "); //click to perform the operation
		operationPanel.add(amountLabel); operationPanel.add(amountTextField);
		operationPanel.add(submitButton);
		
		panel.add(emptyPanel); panel.add(checkAccountPanel);
		panel.add(operationPanel);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setVisible(true);	
	}

	public JButton getCheckAccountButton() {
		return checkAccountButton;
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

package it.unipv.po.bankSimulator.bankView.userGui;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.po.bankmodel.BankModel;
import it.unipv.po.bankmodel.account.Account;

@SuppressWarnings({ "serial", "deprecation" })
public class BalanceDisplayer extends JFrame implements Observer {
	
	public static int WIDTH = 300;
	public static int HEIGHT = 150;
	
	private String iban;
	private JLabel balanceValueLabel;
	
	public BalanceDisplayer(String i) {
		iban = i;
		
		setTitle(iban + "'s balance");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(3, 1));
		
		JPanel emptyPanel = new JPanel(); //used to get a better looking layout
		JPanel balancePanel = new JPanel(); //contains the balance
		
		JLabel balanceLabel = new JLabel("Balance: ");
		balanceValueLabel = new JLabel("0.0€"); //displays the balance
		balancePanel.add(balanceLabel); balancePanel.add(balanceValueLabel);
		
		panel.add(emptyPanel); panel.add(balancePanel);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //when the frame is closed it's
														//hidden
	}

	@Override
	public void update(Observable o, Object arg) {
		TreeMap<String, Account> accountSet = ((BankModel)o).getAccountSet();
		balanceValueLabel.setText(Double.toString((accountSet.get(iban).getBalance())) + "€");		
	}

}

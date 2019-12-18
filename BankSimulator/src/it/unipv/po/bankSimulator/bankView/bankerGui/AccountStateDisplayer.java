package it.unipv.po.bankSimulator.bankView.bankerGui;

import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import it.unipv.po.bankmodel.BankModel;
import it.unipv.po.bankmodel.account.Account;

@SuppressWarnings({ "deprecation", "serial" })
public class AccountStateDisplayer extends JFrame implements Observer {
	
	public static int WIDTH = 600;
	public static int HEIGHT = 342;
	
	private JTextArea accountStateText;
	
	public AccountStateDisplayer() {
		setTitle("Account state");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		accountStateText = new JTextArea(20, 50);
		JScrollPane scrollPane = new JScrollPane(accountStateText); //the text area is scrollable
		
		panel.add(scrollPane);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //when the frame is closed it's
														//hidden
	}

	@Override
	public void update(Observable o, Object arg) {
		TreeMap<String, Account> accountSet = ((BankModel)o).getAccountSet();
		accountStateText.setText(genText(accountSet));		
	}

	private String genText(TreeMap<String, Account> accountSet) {
		String text = "";
		
		for (String key : accountSet.keySet()) {
			text += key + ": " + accountSet.get(key).getBalance() + "€" + "\n";
		}
		
		return text;
	}

}

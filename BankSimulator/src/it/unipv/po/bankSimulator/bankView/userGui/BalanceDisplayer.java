package it.unipv.po.bankSimulator.bankView.userGui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BalanceDisplayer extends JFrame {
	
	public static int WIDTH = 300;
	public static int HEIGHT = 150;
	
	public BalanceDisplayer(String balance) {
		setTitle("Your balance");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(3, 1));
		
		JPanel emptyPanel = new JPanel(); //used to get a better looking layout
		JPanel balancePanel = new JPanel(); //contains the balance
		
		JLabel ibanLabel = new JLabel("Your balance: " + balance + "€"); //displays the balance
		balancePanel.add(ibanLabel);
		
		panel.add(emptyPanel); panel.add(balancePanel);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}

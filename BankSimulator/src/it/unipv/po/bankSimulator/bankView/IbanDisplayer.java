package it.unipv.po.bankSimulator.bankView;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IbanAssigner extends JFrame {
	
	public static int WIDTH = 300;
	public static int HEIGHT = 150;
	
	public IbanAssigner(String iban) {
		setTitle("Your IBAN");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(3, 1));
		
		JPanel emptyPanel = new JPanel();
		JPanel ibanPanel = new JPanel();
		
		JLabel ibanLabel = new JLabel("Your IBAN is: " + iban);
		ibanPanel.add(ibanLabel);
		
		panel.add(emptyPanel); panel.add(ibanPanel);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}

package it.unipv.po.bankSimulator.bankView;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IbanDisplayer extends JFrame {
	
	public static int WIDTH = 300;
	public static int HEIGHT = 150;
	
	public IbanDisplayer(String iban) {
		setTitle("Your IBAN");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(3, 1));
		
		JPanel emptyPanel = new JPanel(); //this empty panel is used to get a better looking layout
		JPanel ibanPanel = new JPanel(); //this panel contains the generated iban
		
		JLabel ibanLabel = new JLabel("Your IBAN is: " + iban); //this label displays the iban
		ibanPanel.add(ibanLabel);
		
		panel.add(emptyPanel); panel.add(ibanPanel);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setVisible(true);
	}

}

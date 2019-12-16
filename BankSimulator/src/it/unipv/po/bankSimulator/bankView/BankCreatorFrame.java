package it.unipv.po.bankSimulator.bankView;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BankCreatorFrame extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 300;
	
	private JTextField bankName = new JTextField(20);
	private JButton createButton = new JButton(" Create ");
	
	public BankCreatorFrame(String name) {
		setTitle(name);
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(3, 1));
		
		JPanel emptyPanel = new JPanel(); //this empty panel is used to get a better looking layout
		JPanel textFieldPanel = new JPanel(); //this panel allows to name (and create) a bank
		
		JLabel infoLabel = new JLabel("Insert here the name of the bank you want to create: ");
		
		textFieldPanel.add(infoLabel);
		textFieldPanel.add(bankName); //the user has to insert here the name of the bank
		textFieldPanel.add(createButton); //this button causes this frame to close and allows the
		                                  //access to BankerFrame and UserFrame
		
		panel.add(emptyPanel);
		panel.add(textFieldPanel);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);				
	}

}

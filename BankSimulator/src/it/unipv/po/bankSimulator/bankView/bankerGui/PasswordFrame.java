package it.unipv.po.bankSimulator.bankView.bankerGui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class PasswordFrame extends JFrame {
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;
	
	private String type;
	private JPasswordField passTextField;
	private JButton okButton;
	
	public PasswordFrame(String t) {
		type = t;
		
		setTitle(type);
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(3,1));
		
		JPanel emptyPanel = new JPanel(); //used to get a better looking layout
		JPanel passPanel = new JPanel(); //allows to set or enter the password
		
		JLabel passLabel = new JLabel(type + ": ");
		passTextField = new JPasswordField(20); //enter the password here
		okButton = new JButton("  Ok  "); //button to set/enter the password and close the frame
		passPanel.add(passLabel); passPanel.add(passTextField); 
		passPanel.add(okButton);
		
		panel.add(emptyPanel); panel.add(passPanel);
		
		setLocationRelativeTo(null); //the frame will be in the center of the screen
		setVisible(true);	
	}

	public String getTypeOfPassFrame() {
		return type;
	}

	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passTextField.getText();
	}

	public JButton getOkButton() {
		return okButton;
	}

}

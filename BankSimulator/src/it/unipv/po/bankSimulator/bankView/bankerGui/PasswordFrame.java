package it.unipv.po.bankSimulator.bankView.bankerGui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PasswordFrame extends JFrame {
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;
	
	private String type;
	private JTextField passTextField;
	private JButton okButton;
	
	public PasswordFrame(String t) {
		type = t;
		
		setTitle(type);
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		panel.setLayout(new GridLayout(3,1));
		
		JPanel emptyPanel = new JPanel();
		JPanel passPanel = new JPanel();
		
		JLabel passLabel = new JLabel(type + ": ");
		passTextField = new JTextField(20);
		okButton = new JButton("  Ok  ");
		passPanel.add(passLabel); passPanel.add(passTextField); 
		passPanel.add(okButton);
		
		panel.add(emptyPanel); panel.add(passPanel);
		
		setLocationRelativeTo(null);
		setVisible(true);	
	}

	public String getTypeOfPassFrame() {
		return type;
	}

	public String getPassword() {
		return passTextField.getText();
	}

	public JButton getOkButton() {
		return okButton;
	}

}

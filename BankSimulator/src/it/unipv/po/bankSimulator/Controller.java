package it.unipv.po.bankSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unipv.po.bankSimulator.bankView.BankCreatorFrame;
import it.unipv.po.bankSimulator.bankView.bankerGui.BankerFrame;
import it.unipv.po.bankSimulator.bankView.userGui.UserFrame;
import it.unipv.po.bankmodel.BankModel;

public class Controller {
	
	private final BankModel bankModel;
	private final BankCreatorFrame bankCreatorFrame;
	private BankerFrame bankerFrame;
	private UserFrame userFrame;
	
	public Controller(BankModel bm, BankCreatorFrame bc) {
		this.bankModel = bm;
		this.bankCreatorFrame = bc;
		
		setListeners();
	}
	
	public void setListeners() {
		
		bankCreatorFrame.getCreateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bankName = bankCreatorFrame.getBankName();
				bankModel.setName(bankName);
				bankerFrame = new BankerFrame(bankName);
				userFrame = new UserFrame(bankName);
				
				bankCreatorFrame.setVisible(false);
			}
		});
		
	}

}

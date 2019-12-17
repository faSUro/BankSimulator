package it.unipv.po.bankSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unipv.po.bankSimulator.bankView.BankCreatorFrame;
import it.unipv.po.bankSimulator.bankView.bankerGui.AccountStateDisplayer;
import it.unipv.po.bankSimulator.bankView.bankerGui.BankerFrame;
import it.unipv.po.bankSimulator.bankView.userGui.UserFrame;
import it.unipv.po.bankmodel.BankModel;
import it.unipv.po.bankmodel.account.AccountType;

public class Controller {
	
	private final BankModel bankModel;
	private final BankCreatorFrame bankCreatorFrame;
	
	private BankerFrame bankerFrame;
	private AccountStateDisplayer accountState = new AccountStateDisplayer();
	
	private UserFrame userFrame;
	
	@SuppressWarnings("deprecation")
	public Controller(BankModel bm, BankCreatorFrame bc) {
		this.bankModel = bm;
		this.bankCreatorFrame = bc;
		
		this.bankModel.addObserver(accountState);

		setBankCreatorListeners();
	}
	
	public void setBankCreatorListeners() {		
		/*
		 * This listener allows to set the name of the bank by clicking the createButton
		 * inside the BankCreatorFrame class. It also closes the BankCreatorFrame and
		 * set the BankerFrame and UserFrame visible.
		 */
		bankCreatorFrame.getCreateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bankName = bankCreatorFrame.getBankName();
				bankModel.setName(bankName);
				bankerFrame = new BankerFrame(bankName);
				userFrame = new UserFrame(bankName);
				
				setBankerListeners();
				
				bankCreatorFrame.dispose();
			}
		});		
	}
	
	public void setBankerListeners() {		
		/*
		 * This listener allows to see the AccountStateDisplayer.
		 */
		bankerFrame.getCheckButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountState.setVisible(true);
			}
		});	
		
		bankerFrame.getAddAccountButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fiscalCode = bankerFrame.getFiscalCode();
				
				switch (bankerFrame.getAccountType()) {
				case "Bank account":
					bankModel.addAccount(fiscalCode, AccountType.BANK);
					break;
				case "Deposit account":
					bankModel.addAccount(fiscalCode, AccountType.DEPOSIT);
					break;
				case "Web account":
					bankModel.addAccount(fiscalCode, AccountType.WEB);
					break;
				}
			}
		});
	}

}










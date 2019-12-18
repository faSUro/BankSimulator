package it.unipv.po.bankSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.po.bankSimulator.bankView.BankCreatorFrame;
import it.unipv.po.bankSimulator.bankView.IbanDisplayer;
import it.unipv.po.bankSimulator.bankView.bankerGui.AccountStateDisplayer;
import it.unipv.po.bankSimulator.bankView.bankerGui.BankerFrame;
import it.unipv.po.bankSimulator.bankView.bankerGui.PasswordFrame;
import it.unipv.po.bankSimulator.bankView.userGui.BalanceDisplayer;
import it.unipv.po.bankSimulator.bankView.userGui.LoggedInFrame;
import it.unipv.po.bankSimulator.bankView.userGui.UserFrame;
import it.unipv.po.bankmodel.BankModel;
import it.unipv.po.bankmodel.account.AccountType;
import it.unipv.po.bankmodel.account.WebAccount;

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
				setUserListeners();
				
				bankCreatorFrame.dispose();
			}
		});		
	}
	
	public void setBankerListeners() {		
		/*
		 * This listener allows to see the AccountStateDisplayer by clicking the
		 * checkButton.
		 */
		bankerFrame.getCheckButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountState.setVisible(true);
			}
		});	
		
		/*
		 * This listener allows to add an account by filling out the fiscal 
		 * code/account type form and then clicking the addAccountButton.
		 */
		bankerFrame.getAddAccountButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IbanDisplayer(bankModel.genIban());
				
				String fiscalCode = bankerFrame.getFiscalCode();				
				switch (bankerFrame.getAccountType()) {
				case "Bank account":
					bankModel.addAccount(fiscalCode, AccountType.BANK);
					break;
				case "Deposit account":
					bankModel.addAccount(fiscalCode, AccountType.DEPOSIT);
					break;
				case "Web account":
					String iban = bankModel.genIban();
					bankModel.addAccount(fiscalCode, AccountType.WEB);
					
					PasswordFrame setPass = new PasswordFrame("Set password");
					setPasswordListeners(setPass, iban, 0.0);
					break;
				}
				bankerFrame.getFiscalCodeTextField().setText("");
			}
		});
		
		/*
		 * This listener allows to perform operations on the (non web type) accounts 
		 * by filling out the IBAN/amount form and then clicking the submitButton.
		 * If it's a web type account, it asks the password. 
		 */
		bankerFrame.getSubmitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iban = bankerFrame.getIban();
				double amount = bankerFrame.getAmount();
				
				if (bankModel.getAccount(iban).getAccountType() == AccountType.WEB) {
					PasswordFrame enterPass = new PasswordFrame("Enter password");
					setPasswordListeners(enterPass, iban, amount);
				} else {
					bankModel.operation(iban, amount);
				}
				bankerFrame.getIbanTextField().setText("");
				bankerFrame.getAmountTextField().setText("");
			}
		});
	}
	
	public void setUserListeners() {		
		/*
		 * This listener allows to add a web type account by filling out the fiscal
		 * code/set password form and then clicking the createAccountButton.
		 */
		userFrame.getCreateAccountButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iban = bankModel.genIban();
				new IbanDisplayer(iban);
				
				bankModel.addAccount(userFrame.getFiscalCode(), AccountType.WEB);
				(((WebAccount) bankModel.getAccount(iban))).changePassword("changeme", userFrame.getSetPassword());
				
				userFrame.getFiscalCodeTextField().setText("");
				userFrame.getSetPasswordTextField().setText("");
			}
		});
		
		/*
		 * This listener allows to log in by filling out the IBAN/password form and
		 * then clicking the logInButton.
		 */
		userFrame.getLogInButton().addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String iban = userFrame.getIban();
				
				if ((((WebAccount) bankModel.getAccount(iban))).logIn(userFrame.getPassword())) {
					LoggedInFrame loggedInFrame = new LoggedInFrame(iban);
					BalanceDisplayer balanceDisplayer = new BalanceDisplayer(iban);
					bankModel.addObserver(balanceDisplayer);
					setLoggedInListeners(loggedInFrame, balanceDisplayer, iban);
				}
				
				userFrame.getIbanTextField().setText("");
				userFrame.getPasswordTextField().setText("");
			}
		});
	}
	
	public void setLoggedInListeners(LoggedInFrame li, BalanceDisplayer balanceDisplayer, String iban) {
		/*
		 * This listener allows to see the IBAN related balance by clicking the
		 * checkAccountButton.
		 */
		li.getCheckAccountButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balanceDisplayer.setVisible(true);;
			}
		});
		
		/*
		 * This listener allows to perform operations on the account
		 * by filling out the amount form and then clicking the submitButton. 
		 */
		li.getSubmitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankModel.operation(iban, li.getAmount());
				
				li.getAmountTextField().setText("");
			}
		});
	}
	
	public void setPasswordListeners(PasswordFrame passFrame, String iban, double amount) {
		/*
		 * 
		 */
		passFrame.getOkButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (passFrame.getTypeOfPassFrame()) {
				case "Set password":
					(((WebAccount) bankModel.getAccount(iban))).changePassword("changeme", passFrame.getPassword());
					break;
				case "Enter password":
					((WebAccount) bankModel.getAccount(iban)).logIn(passFrame.getPassword());
					bankModel.operation(iban, amount);
				}
				passFrame.dispose();
			}
		});
	}

}










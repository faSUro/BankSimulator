package it.unipv.po.bankSimulator;

import it.unipv.po.bankSimulator.bankView.BankCreatorFrame;
import it.unipv.po.bankmodel.BankModel;

/**
 * The BankSimulator program implements an application that simulates a a bank,
 * in a very simple way. 
 * There are two GUI (one for the banker and one for the user) that allow to 
 * perform bank account operations (add an account, * deposit and withdraw).
 * There are three types of account: bank account, deposit account and web account.
 * 
 * @author fasuro
 * @version 1.0
 * @since 2019-12-16
 */

public class Start {
	
	public static void main(String[] args) {
		
		new Controller(new BankModel("Default name"), new BankCreatorFrame());
		
	}

}

package it.unipv.po.bankSimulator;

import it.unipv.po.bankSimulator.bankView.BankCreatorFrame;
import it.unipv.po.bankmodel.BankModel;

public class Start {
	
	public static void main(String[] args) {
		
		new Controller(new BankModel("Default name"), new BankCreatorFrame());
		
	}

}

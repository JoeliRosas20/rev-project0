package com.training.pms.bank;

public interface BankDAO {
	
	public void approveTransaction(boolean res);
	public void viewAccount(int accountID);
	public void viewTransactionLod(int logID);

}

package com.training.pms.dao;

public interface BankDAO {
	
	public void approveTransaction(boolean res);
	public void viewAccount();
	public void viewTransactionLod(int logID);

}

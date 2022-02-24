package com.training.pms.dao;

import com.training.pms.bank.Customer;

public interface BankDAO {
	
	public void approveTransaction(boolean res);
	public void viewAccount();
	public void viewTransactionLod(int logID);
	public boolean addCustomer(Customer costumer);
	public boolean isAccountThere(int userId);

}

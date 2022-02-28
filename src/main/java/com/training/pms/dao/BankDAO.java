package com.training.pms.dao;

import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;

public interface BankDAO {
	
	//Employee Stuff
	public void approveTransaction(boolean res);
	public void viewAccount();
	public void viewTransactionLod(int logID);
	//User Stuff
	public boolean addCustomer(Customer costumer);
	public boolean addEmployee(Employee employee);
	//Customer Stuff
	public int getBalance(int userId, int account);
	public boolean depositToAccount(int accountId,int num);
	public boolean withdrawFromAccount(int accountId, int num);
	public boolean createAccount(Customer customer);
	public boolean createOtherAccount(int userId, int num);
	//Helpers
	public String getCustomerName(int userId);
	public String getEmployeeName(int userId);
	public int getAccountId(int userId);
	
}

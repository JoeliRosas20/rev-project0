package com.training.pms.dao;

import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;

public interface BankDAO {
	
	public void approveTransaction(boolean res);
	public void viewAccount();
	public void viewTransactionLod(int logID);
	public boolean addCustomer(Customer costumer);
	boolean addEmployee(Employee employee);
	public boolean isAccountThere(int userId);
	public String getCustomerName(int userId);
	public int getBalance(int userId, int account);
	public String getEmployeeName(int userId);
	public boolean depositToAccount(int num);
	public boolean withdrawFromAccount(int num);
	public boolean createAccount(int userId, int num);
	
}

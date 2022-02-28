package com.training.pms.dao;

import java.util.List;

import com.training.pms.bank.Bank;
import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;

public interface BankDAO {
	
	//Employee Stuff
	public void approveTransaction(boolean res);
	public Bank viewAccount(int userId, int account);
	public void viewTransactionLod(int logID);
	public boolean sendForApproval(Customer customer);
	public List<Bank> getPending();
	public Bank getBankAccount(int accId);
	//User Stuff
	public boolean addCustomer(Customer costumer);
	public boolean addEmployee(Employee employee);
	//Customer Stuff
	public int getBalance(int userId, int account);
	public boolean depositToAccount(int accountId,int num);
	public boolean withdrawFromAccount(int accountId, int num);
	public boolean createAccount(Bank bank);
	public boolean createOtherAccount(int userId, int num);
	public boolean transferMoney(int account1, int account2, int num);
	public boolean transferMoneyToOthers(int userId, int account, int num);
	//Helpers
	public String getCustomerName(int userId);
	public String getEmployeeName(int userId);
	public int getAccountId(int userId, int num);
	
}

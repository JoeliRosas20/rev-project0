package com.training.pms.dao;

import java.util.List;

import com.training.pms.bank.Bank;
import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;
import com.training.pms.bank.Transfer;

public interface BankDAO {
	
	//Employee Stuff
	public void approveTransaction(boolean res);
	public Bank viewAccount(int userId, int account);
	public boolean sendForApproval(Customer customer);							 //Once account is created, it goes for approval
	public List<Bank> getPendings();											 //Employee sees pending accounts
	public Bank getPendingBankAccount(int accId);								 //Employee chooses pending account
	//User Stuff
	public boolean addCustomer(Customer costumer);								 //Adding new customer
	public boolean addEmployee(Employee employee);								 //Adding new employee
	//Customer Stuff
	public int getBalance(int userId, int account);								 //Getting the balance of an account
	public boolean depositToAccount(int accountId,int amount);					 //Depositing to an account
	public boolean withdrawFromAccount(int accountId, int amount);				 //Withdrawing from account
	public boolean createAccount(Bank bank);									 //Employee approves the account
	public boolean createOtherAccount(int userId, int amount);					 //Creating another account
	public boolean transferMoney(int account1, int account2, int amount);		 //Sending money within accounts
	public boolean transferMoneyToOthers(int userId, int amount, String person); //Sending money to someone
	public int acceptTransfer(int accId);										 //Accepting the transfer
	public boolean deleteTransfer(int accId);									 //Denying the transfer
	//Helpers
	public String getCustomerName(int userId);									 //Getting the customer's name
	public String getEmployeeName(int userId);									 //Getting the employee's name
	public int getAccountId(int userId, int amount);							 //Getting the account id
	public boolean areThereAccounts(int userId);								 //Check if user has an account
	public boolean removeAccounts(int pendId);									 //Remove pending account 
	public boolean userIdAlreadyTaken(int userId);								 //Check if user can use that id
	public List<Transfer> viewIncomingTransfers(int userId);					 //Customer sees list of incoming transfers
	
}

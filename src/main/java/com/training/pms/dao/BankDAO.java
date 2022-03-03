package com.training.pms.dao;

import java.util.List;

import com.training.pms.bank.Bank;
import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;
import com.training.pms.bank.Transfer;

public interface BankDAO {
	
	//Employee Stuff
	public Bank viewAccount(int userId, int account);							 //Employee views the account
	public boolean sendForApproval(Customer customer);							 //Once account is created, it goes for approval
	public List<Bank> getPendings();											 //Employee sees pending accounts
	public Bank getPendingBankAccount(int accId);								 //Employee chooses pending account
	public boolean createAccount(Bank bank);									 //Employee approves the account
	public boolean removeAccounts(int pendId);									 //Employee Remove pending account 
	public List<Transfer> viewIncomingTransfers();								 //Employee sees pending transfer
	public int getApprovedBalance(int transferId);								 //Employee picks the approved balance
	public boolean denyTransfer(int transferId);							     //Employee denies the transfer
	//User Stuff
	public boolean addCustomer(Customer costumer);								 //Adding new customer
	public boolean addEmployee(Employee employee);								 //Adding new employee
	//Customer Stuff
	public int getBalance(int userId, int account);								 //Customer Getting the balance of an account
	public boolean depositToAccount(int accountId,int amount);					 //Customer Depositing to an account
	public boolean withdrawFromAccount(int accountId, int amount);				 //Customer Withdrawing from account
	public boolean createOtherAccount(int userId, int amount);					 //Customer Creating another account
	public boolean transferMoney(int account1, int account2, int amount);		 //Customer Sending money within accounts
	public boolean transferMoneyToOthers(int userId, int amount, String person); //Customer Sending money to someone
	public int acceptTransfer(int accId);										 //Customer Accepting the transfer
	public boolean deleteTransfer(int accId);									 //Customer Denying the transfer
	public List<Transfer> viewIncomingTransfers(int userId);					 //Customer sees list of incoming transfers
	public int getBalance(int accId);											 //Customer's balance 
	public boolean sendDepositForReview(int accId, int deposit);				 //Customer deposit sent to Employee if over 600
	//Helpers
	public String getCustomerName(int userId);									 //System Getting the customer's name
	public String getEmployeeName(int userId);									 //System Getting the employee's name
	public int getAccountId(int userId, int amount);							 //System Getting the account id
	public boolean areThereAccounts(int userId);								 //System Check if Customer has an account
	public boolean userIdAlreadyTaken(int userId);								 //System Check if user can use that id
	
}

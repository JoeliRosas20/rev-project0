package com.training.pms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.pms.bank.Bank;
import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;
import com.training.pms.utility.DBConnection;

public class BankDAOImpl implements BankDAO{
	
	Connection connection = DBConnection.getConnection();
	
	//---------------Employee Stuff---------------

	@Override
	public void approveTransaction(boolean res) {
		
	}

	public Bank viewAccount(int userId, int account) {
		Bank bank = new Bank();
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from Bank where userid=? and accountid=?");
			stat.setInt(1, userId);
			stat.setInt(2, account);
			ResultSet res = stat.executeQuery();
			res.next();
			bank.setAccountId(res.getInt(1));
			bank.setUserId(res.getInt(2));
			bank.setBalance(res.getInt(3));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bank;
	}

	@Override
	public void viewTransactionLod(int logID) {
		
	}
	
	public boolean sendForApproval(Customer customer) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into PendingAccounts values(default,?,?)");
			statement.setInt(1, customer.getId());
			statement.setInt(2, customer.getBalance());
			
			rows = statement.executeUpdate();
			System.out.println(rows + " inserted ");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	public List<Bank> getPendings(){
		List<Bank> pending = new ArrayList<Bank>();
		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from PendingAccounts");
			while(res.next()) {
				Bank bank = new Bank();
				bank.setAccountId(res.getInt(1));
				bank.setUserId(res.getInt(2));
				bank.setBalance(res.getInt(3));
				pending.add(bank);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pending;
	}
	
	public Bank getPendingBankAccount(int accId){
		Bank account = new Bank();
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from PendingAccounts where pendid = ?");
			stat.setInt(1, accId);
			ResultSet res = stat.executeQuery();
			res.next();
			account.setAccountId(res.getInt(1));
			account.setUserId(res.getInt(2));
			account.setBalance(res.getInt(3));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	//---------------User Stuff---------------
	
	@Override
	public boolean addCustomer(Customer customer) {
		System.out.println("##Adding customer :" + customer);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into Customer values(?,?)");
			statement.setInt(1, customer.getId());
			statement.setString(2, customer.getName());

			rows = statement.executeUpdate();
			System.out.println(rows + " inserted successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		System.out.println("##Adding customer :" + employee);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into Employee values(?,?)");
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getName());

			rows = statement.executeUpdate();
			System.out.println(rows + " inserted successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	//---------------Customer Stuff---------------
	
	@Override
	public int getBalance(int userId, int accountId) {
		int balance = 0;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select balance from Bank where accountid=?");
			stat.setInt(1, accountId);
			ResultSet res = stat.executeQuery();
			res.next();
			balance = res.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public boolean depositToAccount(int accountId, int amount) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("update Bank set balance = balance + ? where accountid = ? ");
			statement.setInt(1, amount);
			statement.setInt(2, accountId);
			rows = statement.executeUpdate();
			System.out.println(rows+" updated successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean withdrawFromAccount(int accountId, int amount) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("update Bank set balance = balance - ? where accountid = ?");
			statement.setInt(1, amount);
			statement.setInt(2, accountId);
			rows = statement.executeUpdate();
			System.out.println(rows+" updated successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean createAccount(Bank bank) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into Bank values(?,?,?)");
			statement.setInt(1, bank.getAccountId());
			statement.setInt(2, bank.getUserId());
			statement.setInt(3, bank.getBalance());
			
			rows = statement.executeUpdate();
			System.out.println(rows + " inserted ");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public boolean createOtherAccount(int userId, int amount) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into PendingAccounts values(default,?,?)");
			statement.setInt(1, userId);
			statement.setInt(2, amount);
			
			rows = statement.executeUpdate();
			System.out.println(rows + " inserted ");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public boolean transferMoney(int debtor, int creditor, int amount) {
		CallableStatement stat = null;
		boolean transfered = false;
		try {
			stat = connection.prepareCall("call transfer(?,?,?)");
			stat.setInt(1, debtor);
			stat.setInt(2, creditor);
			stat.setInt(3, amount);
			transfered = stat.execute();
			
			System.out.println("Transfer done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (transfered)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean transferMoneyToOthers(int userId, int amount, String person) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into PendingTransfers values(default, ?, ?, ?)");
			statement.setInt(1, userId);
			statement.setInt(2, amount);
			statement.setString(3, person);
			rows = statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	public int acceptTransfer(int accId) {
		PreparedStatement statement = null;
		int transfer = 0;
		try {
			statement = connection.prepareStatement("select balance from PendingTransfers where transferid = ?");
			statement.setInt(1, accId);
			ResultSet res = statement.executeQuery();
			res.next();
			transfer = res.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
			return transfer;
	}
	
	public boolean deleteTransfer(int accId) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("delete from PendingTransfers where transferid = ?");
			statement.setInt(1, accId);
			rows = statement.executeUpdate();
			System.out.println(rows + " deleted successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	//---------------Helpers---------------
	
	@Override
	public String getCustomerName(int userId) {
		String name = " ";
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select username from Customer where userId=?");
			stat.setInt(1, userId);
			ResultSet res = stat.executeQuery();
			res.next();
			name = res.getString(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	@Override
	public String getEmployeeName(int userId) {
		String name = " ";
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select username from Employee where userId=?");
			stat.setInt(1, userId);
			ResultSet res = stat.executeQuery();
			res.next();
			name = res.getString(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public int getAccountId(int userId, int amount) {
		int accId = 0;
		PreparedStatement stat;
		try {
			stat= connection.prepareStatement("select pendid from PendingAccounts where userid = ? and balance = ?");
			stat.setInt(1, userId);
			stat.setInt(2, amount);
			ResultSet res = stat.executeQuery();
			res.next();
			accId = res.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accId;
	}
	
	public boolean areThereAccounts(int userId) {
		boolean accountsExist = false;
		PreparedStatement stat = null;
		try {
			stat = connection.prepareStatement("select * from Bank where userid = ?");
			stat.setInt(1, userId);
			ResultSet res = stat.executeQuery();
			accountsExist = res.next();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accountsExist;
	}

	public boolean removeAccounts(int pendId) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("delete from PendingAccounts where pendid = ?");
			statement.setInt(1, pendId);
			rows = statement.executeUpdate();
			System.out.println(rows + " deleted successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	public boolean userIdAlreadyTaken(int userId) {
		boolean userExists = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select userid from Login where userid = ?");
			stat.setInt(1, userId);
			ResultSet res = stat.executeQuery();
			userExists = res.next();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userExists;
	}
	
	public List<Bank> viewIncomingTransfers(int userId) {
		List<Bank> transfers = new ArrayList<Bank>();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("select * from PendingTransfers where userid = ?");
			statement.setInt(1, userId);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				Bank transfer = new Bank();
				transfer.setAccountId(res.getInt(1));
				transfer.setUserId(res.getInt(2));
				transfer.setBalance(res.getInt(3));
				transfers.add(transfer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return transfers;
	}
	
}

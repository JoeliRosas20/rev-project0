package com.training.pms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;
import com.training.pms.utility.DBConnection;

public class BankDAOImpl implements BankDAO{
	
	Connection connection = DBConnection.getConnection();

	@Override
	public void approveTransaction(boolean res) {
		// TODO Auto-generated method stub
		
	}

	public void viewAccount() {
		// TODO Auto-generated method stub
		Statement stat;
		try {
			stat = connection.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewTransactionLod(int logID) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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

	@Override
	public int getBalance(int userId, int accountId) {
		// TODO Auto-generated method stub
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
	public boolean depositToAccount(int accountId, int num) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("update Bank set balance = balance + ? where accountid = ? ");
			statement.setInt(1, num);
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
	public boolean withdrawFromAccount(int num) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("update Customer set balance = balance -  ?");
			statement.setInt(1, num);
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
	public boolean createAccount(Customer customer) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into Bank values(default,?,?)");
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
	
	@Override
	public boolean createOtherAccount(int userId, int num) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into Bank values(default,?,?)");
			statement.setInt(1, userId);
			statement.setInt(2, num);
			
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
	public String getCustomerName(int userId) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	public int getAccountId(int userId) {
		// TODO Auto-generated method stub
		int accId = 0;
		PreparedStatement stat = null;
		try {
			stat= connection.prepareStatement("select accountId from Bank where userId = ?");
			stat.setInt(1, userId);
			ResultSet res = stat.executeQuery();
			res.next();
			accId = res.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accId;
	}

}

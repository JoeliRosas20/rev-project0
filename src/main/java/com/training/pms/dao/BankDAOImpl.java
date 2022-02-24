package com.training.pms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.training.pms.bank.Customer;
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
			statement = connection.prepareStatement("insert into Customer values(?,?,?)");
			statement.setInt(1, customer.getBalance());
			statement.setInt(2, customer.getId());
			statement.setString(3, customer.getName());

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
	public boolean isAccountThere(int userId) {
		// TODO Auto-generated method stub
		boolean accountExists = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from Login where ");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

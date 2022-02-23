package com.training.pms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

}

package com.training.pms.dao;

import java.sql.Connection;

import com.training.pms.utility.DBConnection;

public class BankDAOImpl implements BankDAO{
	
	Connection connection = DBConnection.getConnection();

	@Override
	public void approveTransaction(boolean res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAccount(int accountID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTransactionLod(int logID) {
		// TODO Auto-generated method stub
		
	}

}

package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.pms.bank.Login;
import com.training.pms.utility.DBConnection;

public class LoginDAOImpl implements LoginDAO{

	Connection connection = DBConnection.getConnection();

	@Override
	public boolean register(Login login) {
		// TODO Auto-generated method stub
		System.out.println("Registration");
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into login values(default,?,?,?)");
			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());
			statement.setInt(3, login.getUserId());

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
	public boolean validate(int userId, String password) {
		// TODO Auto-generated method stub
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from login where userid = ? and password = ?");
			stat.setInt(1, userId);
			stat.setString(2, password);
			ResultSet res = stat.executeQuery();
			userValid = res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}

}

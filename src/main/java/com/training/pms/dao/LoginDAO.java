package com.training.pms.dao;

import com.training.pms.bank.*;

public interface LoginDAO {
	
	public boolean register(Login login);
	public boolean validate(int userId, String password);
	
}

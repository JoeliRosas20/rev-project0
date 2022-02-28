package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.pms.bank.Login;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class LoginDAOImplTest {
	
	LoginDAO loginDAO;
	int userIdE;
	int userIdC;
	String passwordE;
	String passwordC;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		loginDAO = new LoginDAOImpl();
		userIdE = 100;
		userIdC = 50;
		passwordE = "Eroot";
		passwordC = "Croot";
	}

	@AfterEach
	void tearDown() throws Exception {
	}
/*
	@Test
	@Order(value = 2)
	void testRegister() {
		Login login = new Login("C Dummy", "Croot", 50);
		assertTrue(loginDAO.register(login));
	}
	
	@Test
	@Order(value = 1)
	void testRegister2() {
		Login login = new Login("E Dummy", "Eroot", 100);
		assertTrue(loginDAO.register(login));
	}
*/
	@Test
	@Order(value = 2)
	void testValidate() {
		assertTrue(loginDAO.validate(userIdC, passwordC));
	}
	
	@Test
	@Order(value = 1)
	void testValidate2() {
		assertTrue(loginDAO.validate(userIdE, passwordE));
	}

}

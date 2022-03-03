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
	String usernameE;
	String usernameC;
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
		usernameE = "E Dummy";
		usernameC = "C Dummy";
		userIdE = 101;
		userIdC = 51;
		passwordE = "eroot";
		passwordC = "eroot";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(value = 2)
	void testRegisterC() {
		Login login = new Login(usernameC, passwordC, userIdC);
		assertTrue(loginDAO.register(login));
	}
	
	@Test
	@Order(value = 1)
	void testRegisterE() {
		Login login = new Login(usernameE, passwordE, userIdE);
		assertTrue(loginDAO.register(login));
	}

	@Test
	@Order(value = 4)
	void testValidateC() {
		assertTrue(loginDAO.validate(userIdC, passwordC));
	}
	
	@Test
	@Order(value = 3)
	void testValidateE() {
		assertTrue(loginDAO.validate(userIdE, passwordE));
	}

}

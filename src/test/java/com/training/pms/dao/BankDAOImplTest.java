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

import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class BankDAOImplTest {
	
	BankDAO bankDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bankDAO = new BankDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testViewAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testSendForApproval() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPending() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBankAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 2)
	void testAddCustomer() {
		fail("Not yet implemented");
		Customer customer = new Customer(50, 50, "C Dummy");
		assertTrue(bankDAO.addCustomer(customer));
	}

	@Test
	@Order(value = 1)
	void testAddEmployee() {
		Employee employee = new Employee(100,"E Dummy");
		assertTrue(bankDAO.addEmployee(employee));
	}

	@Test
	void testGetBalance() {
		fail("Not yet implemented");
	}

	@Test
	void testDepositToAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testWithdrawFromAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateOtherAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testTransferMoney() {
		fail("Not yet implemented");
	}

	@Test
	void testTransferMoneyToOthers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomerName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployeeName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAccountId() {
		fail("Not yet implemented");
	}

	@Test
	void testAreThereAccounts() {
		fail("Not yet implemented");
	}

}

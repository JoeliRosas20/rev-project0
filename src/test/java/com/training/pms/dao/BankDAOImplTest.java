package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.pms.bank.Bank;
import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class BankDAOImplTest {
	
	BankDAO bankDAO;
	String usernameE;
	String usernameC;
	int userIdE;
	int userIdC;
	String passwordE;
	String passwordC;
	int balance;
	int pendId;
	int accId;
	Bank bank;
	Bank nBank;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bankDAO = new BankDAOImpl();
		usernameE = "Dummy E";
		usernameC = "Dummy C";
		userIdE = 100;
		userIdC = 50;
		passwordE = "Eroot";
		passwordC = "Croot";
		balance = 50;
		pendId = 1;
		accId = 1;
		bank = new Bank();
		nBank = new Bank();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(value = 6)
	@DisplayName("Steve the employee is Viewing account of userid 50 with accid of 3")
	void testViewAccount() {
		Bank foundAccount = bankDAO.viewAccount(userIdC, accId);
		bank = new Bank(userIdC, pendId, balance);
		assertEquals(foundAccount, bank);
	}

	@Test
	@Order(value = 3)
	@DisplayName("Sending C Dummy 2's account for approval")
	void testSendForApproval() {
		Customer customer = new Customer(balance, userIdC, usernameC);
		assertTrue(bankDAO.sendForApproval(customer));
	}

	@Test
	@Order(value = 4)
	@DisplayName("Steve the employee is Getting the number of accounts waiting for approval (hopefully more than 0)")
	void testGetPending() {
		List<Bank> banks = bankDAO.getPendings();
		assertNotEquals(0, banks.size());
	}

	@Test
	@Order(value = 5)
	@DisplayName("Steve the employee is Getting account of userid 10 which is pending")
	void testGetPendingBankAccount() {
		Bank foundAccount = bankDAO.getPendingBankAccount(pendId);
		bank = new Bank(userIdC, pendId, balance);
		assertEquals(foundAccount, bank);
	}

	@Test
	@Order(value = 2)
	@DisplayName("Adding the customer")
	void testAddCustomer() {
		Customer customer = new Customer(balance, userIdC, usernameC);
		assertTrue(bankDAO.addCustomer(customer));
	}

	@Test
	@Order(value = 1)
	@DisplayName("Adding the employee")
	void testAddEmployee() {
		Employee employee = new Employee(userIdE, usernameE);
		assertTrue(bankDAO.addEmployee(employee));
	}
/*
	@Test
	@Order(value = 11)
	@DisplayName("Getting Joe the customer's current balance")
	void testGetBalance() {
		assertEquals(balance, bankDAO.getBalance(userId, accId));
	}
	
/*
	@Test
	@Order(value = 12)
	@DisplayName("Joe the employee will deposit to his accountid 1")
	void testDepositToAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 13)
	@DisplayName("Joe the employee will withdraw from his accountid 1")
	void testWithdrawFromAccount() {
		fail("Not yet implemented");
	}
*/
	
	@Test
	@Order(value = 7)
	@DisplayName("Steve the employee will add the account to the Bank database")
	void testCreateAccount() {
		nBank = new Bank(userIdC, accId, balance);
		assertTrue(bankDAO.createAccount(nBank));
	}
	

	@Test
	@Order(value = 14)
	@DisplayName("Adding another account for Joe the customer")
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
	@Order(value = 9)
	@DisplayName("Getting Joe the customer's name")
	void testGetCustomerName() {
		String name = "Joe";
		assertEquals(name, bankDAO.getCustomerName(userIdC));
	}

	@Test
	@Order(value = 10)
	@DisplayName("Getting Steve the employee's name")
	void testGetEmployeeName() {
		String name = "Steve";
		assertEquals(name, bankDAO.getEmployeeName(userIdE));
	}

	@Test
	@Order(value = 8)
	@DisplayName("Getting the userId of 10 who has balance of 500")
	void testGetAccountId() {
		assertEquals(pendId, bankDAO.getAccountId(userIdC, balance));
	}
	

	@Test
	void testAreThereAccounts() {
		fail("Not yet implemented");
	}

}

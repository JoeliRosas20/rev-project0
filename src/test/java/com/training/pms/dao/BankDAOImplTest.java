package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	int expectedPendId;

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
		expectedPendId = 6;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testApproveTransaction() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 11)
	void testViewAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 3)
	void testSendForApproval() {
		Customer customer = new Customer(balance, userIdC, usernameC);
		assertTrue(bankDAO.addCustomer(customer));
	}

	@Test
	@Order(value = 6)
	void testGetPendings() {
		List<Bank> pendings = bankDAO.getPendings();
		assertNotEquals(0, pendings.size());
	}

	@Test
	@Order(value = 7)
	void testGetPendingBankAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 2)
	void testAddCustomer() {
		Customer customer = new Customer(balance, userIdC, usernameC);
		assertTrue(bankDAO.addCustomer(customer));
	}

	@Test
	@Order(value = 1)
	void testAddEmployee() {
		Employee employee = new Employee(userIdE, usernameE);
		assertTrue(bankDAO.addEmployee(employee));
	}

	@Test
	@Order(value = 13)
	void testGetBalance() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 14)
	void testDepositToAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 15)
	void testWithdrawFromAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 8)
	void testCreateAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 16)
	void testCreateOtherAccount() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 17)
	void testTransferMoney() {
		fail("Not yet implemented");
	}

	@Test
	void testTransferMoneyToOthers() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 12)
	void testGetCustomerName() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 5)
	void testGetEmployeeName() {
		String empName = bankDAO.getEmployeeName(userIdE);
		assertEquals(empName, usernameE);
	}

	@Test
	@Order(value = 4)
	void testGetAccountId() {
		int pendingAccount = bankDAO.getAccountId(userIdC, balance);
		assertEquals(pendingAccount, expectedPendId);
	}

	@Test
	@Order(value = 10)
	void testAreThereAccounts() {
		fail("Not yet implemented");
	}

	@Test
	@Order(value = 9)
	void testRemoveAccounts() {
		fail("Not yet implemented");
	}

}

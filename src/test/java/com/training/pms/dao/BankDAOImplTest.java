package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
	int expectedPendId;
	int accId;
	Bank bank;
	int accId2;

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
		accId = 5;
		bank = new Bank();
		accId2 = 6;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Disabled
	@Test
	@Order(value = 19)
	@DisplayName("19.Employee approving or rejecting a transaction ")
	void testApproveTransaction() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	@Order(value = 11)
	@DisplayName("11.Employee checks account of user based on customerID and accountID")
	void testViewAccount() {
		Bank bank = new Bank(userIdC, accId, balance);
		assertEquals(bank, bankDAO.viewAccount(userIdC, accId));
	}

	@Disabled
	@Test
	@Order(value = 3)
	@DisplayName("3.Sending new customer bank account for approval")
	void testSendForApproval() {
		Customer customer = new Customer(balance, userIdC, usernameC);
		assertTrue(bankDAO.sendForApproval(customer));
	}

	@Disabled
	@Test
	@Order(value = 6)
	@DisplayName("6.Shows list of accounts waiting for approval")
	void testGetPendings() {
		List<Bank> pendings = bankDAO.getPendings();
		assertNotEquals(0, pendings.size());
	}

	@Disabled
	@Test
	@Order(value = 7)
	@DisplayName("7.Employee chooses Account to approve or deny based on account ID")
	void testGetPendingBankAccount() {
		Bank bankFound = bankDAO.getPendingBankAccount(accId);
		bank = new Bank(userIdC, accId, balance);
		assertEquals(bankFound, bank);
	}

	@Disabled
	@Test
	@Order(value = 2)
	@DisplayName("2.Adding a customer")
	void testAddCustomer() {
		Customer customer = new Customer(balance, userIdC, usernameC);
		assertTrue(bankDAO.addCustomer(customer));
	}

	@Disabled
	@Test
	@Order(value = 1)
	@DisplayName("1.Adding an employee")
	void testAddEmployee() {
		Employee employee = new Employee(userIdE, usernameE);
		assertTrue(bankDAO.addEmployee(employee));
	}

	@Disabled
	@Test
	@Order(value = 13)
	@DisplayName("13.Customer can get the balance of their account")
	void testGetBalance() {
		assertEquals(balance, bankDAO.getBalance(userIdC, accId));
	}

	@Disabled
	@Test
	@Order(value = 14)
	@DisplayName("14.Depositing to account of choice")
	void testDepositToAccount() {
		assertTrue(bankDAO.depositToAccount(userIdC, 10));
	}

	@Disabled
	@Test
	@Order(value = 15)
	@DisplayName("15.Withdrawing from account of choice")
	void testWithdrawFromAccount() {
		assertTrue(bankDAO.depositToAccount(userIdC, 10));
	}

	@Disabled
	@Test
	@Order(value = 8)
	@DisplayName("8.If approved, the account will go to bank database")
	void testCreateAccount() {
		Bank bank = new Bank(userIdC, accId, balance);
		assertTrue(bankDAO.createAccount(bank));
	}

	@Disabled
	@Test
	@Order(value = 16)
	@DisplayName("16.If the customer wants to open a new account")
	void testCreateOtherAccount() {
		assertTrue(bankDAO.createOtherAccount(userIdC, 100));
	}

	@Disabled
	@Test
	@Order(value = 17)
	@DisplayName("17.Customer can transfer money from one account to another")
	void testTransferMoney() {
		assertTrue(bankDAO.transferMoney(accId, accId2, 10));
	}

	@Disabled
	@Test
	@Order(value = 18)
	@DisplayName("18.Transfer money from one account to another")
	void testTransferMoneyToOthers() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	@Order(value = 12)
	@DisplayName("12.To display on customer page or for employee to know name of customer")
	void testGetCustomerName() {
		assertEquals(usernameC, bankDAO.getCustomerName(userIdC));
	}

	@Disabled
	@Test
	@Order(value = 5)
	@DisplayName("5.Gets the name of employee")
	void testGetEmployeeName() {
		String empName = bankDAO.getEmployeeName(userIdE);
		assertEquals(empName, usernameE);
	}

	@Disabled
	@Test
	@Order(value = 4)
	@DisplayName("4.Gets potential account ID for their new bank account")
	void testGetAccountId() {
		int pendingAccount = bankDAO.getAccountId(userIdC, balance);
		assertEquals(pendingAccount, expectedPendId);
	}

	@Disabled
	@Test
	@Order(value = 10)
	@DisplayName("10. Once customer logins again, system checks if customer has approved accounts. Employee also used when they need to check customer's account")
	void testAreThereAccounts() {
		int expected = accId;
		assertEquals(expected, bankDAO.areThereAccounts(accId));
	}

	@Disabled
	@Test
	@Order(value = 9)
	@DisplayName("9.Removing accounts from PendingAccounts if approved or rejected")
	void testRemoveAccounts() {
		assertTrue(bankDAO.removeAccounts(accId));
	}

}

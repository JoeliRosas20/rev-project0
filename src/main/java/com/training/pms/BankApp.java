package com.training.pms;

import java.util.Scanner;

import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;
import com.training.pms.bank.Login;
import com.training.pms.dao.BankDAO;
import com.training.pms.dao.BankDAOImpl;
import com.training.pms.dao.LoginDAO;
import com.training.pms.dao.LoginDAOImpl;

public class BankApp {

	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	BankDAO bankDAO = new BankDAOImpl();
	LoginDAO loginDAO = new LoginDAOImpl();
	Customer customer = new Customer();
	Employee employee = new Employee();
	Login login = new Login();
	Boolean result;

	public void startBankApp() {
		System.out.println("Entering");
		while (true) {
			System.out.println("###################################");
			System.out.println("	Joel Banking App");
			System.out.println("###################################");
			System.out.println("1 Login");
			System.out.println("2 Create Account");
			System.out.println("3 Know more about the Banking App");
			System.out.println("4 Know more about the developers");
			System.out.println("10.E X I T");
			choice = scanner.nextInt();
			choice(choice);
		}
	}

	public void choice(int num) {
		switch (num) {
		case 1:
			System.out.println("Login");
			login();
			break;
		case 2:
			System.out.println("Create a new account");
			createAccount();
			break;
		case 3:
			System.out.println("Know about app");
			bankingAppInfo();
			break;
		case 4:
			System.out.println("Know about Devs");
			devInfo();
			break;
		case 10:
			System.out.println("Thanks for using the Banking app.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid, try again");
		}
	}

	public void login() {
		while (true) {
			char choice = ' ';
			int userID = 0;
			String password = " ";
			String name = " ";
			System.out.println("########Login Screen##########");
			System.out.println("Please enter the type of login (C - Customer /E - Employee ) : ");
			System.out.println("Press L to leave");
			choice = scanner.next().charAt(0);
			switch(choice) {
			case 'E':
				System.out.println("Please enter your employee id: ");
				userID = scanner.nextInt();
				name = bankDAO.getEmployeeName(userID);
				System.out.println("Please enter your password: ");
				password = scanner.next();
				if(loginDAO.validate(name, password)) {
					bankPage(userID);
				}
				break;
			case 'C':
				System.out.println("Please enter your customer id: ");
				userID = scanner.nextInt();
				name = bankDAO.getCustomerName(userID);
				System.out.println("Please enter your password: ");
				password = scanner.next();
				if (loginDAO.validate(name, password)) {
					personalPage(userID);
				} else {
					System.out.println("User does not exist. Try again");
					continue;
				}
				break;
			case 'L':
				startBankApp();
				break;
			default:
				System.out.println("Invalid input, please try again");
			}
		}
	}

	public void createAccount() {
		char choice = ' ';
		System.out.println("Welcome to create/open account section");
		System.out.println("Please enter the details to open an acccount:");
		System.out.println("Enter your account type ( E for Employee / C for Customer ):");
		choice = scanner.next().charAt(0);
		if (choice != 'E' && choice != 'C') {
			System.out.println("Incorrect account type, please enter again ");
			System.out.println("Enter your account type ( E for Employee / C for Customer ):");
			choice = scanner.next().charAt(0);
		}
		if (choice == 'E') {
			employeeCreate();
		} else if (choice == 'C') {
			customerCreate();
		}
	}

	public void bankingAppInfo() {
		System.out.println("The Joel Bank is here to serve YOU!");
	}

	public void devInfo() {
		System.out.println("About Me:");
	}

	public void employeeCreate() {
		int empID = 0;
		String empName = " ";
		String empPassword = " ";
		System.out.println("Account details for Employee ?");
		System.out.println("Enter employee id : ");
		empID = scanner.nextInt();
		System.out.println("Enter employee name : ");
		empName = scanner.next();
		System.out.println("Enter your password : ");
		empPassword = scanner.next();
		// Database code
		login = new Login(empName, empPassword, empID);
		employee = new Employee(empID, empName);
		result = loginDAO.register(login);
		bankDAO.addEmployee(employee);
		if (result) {
			System.out.println("Congrats" + empName);
		} else {
			System.out.println("Sorry");
		}
	}

	public void customerCreate() {
		int custID = 0;
		String custName = " ";
		String custPassword = " ";
		String choice = " ";
		int balance = 0;
		System.out.println("Account details for Customer ?");
		System.out.println("Enter customer id : ");
		custID = scanner.nextInt();
		System.out.println("Enter customer name : ");
		custName = scanner.next();
		System.out.println("Enter your password : ");
		custPassword = scanner.next();
		System.out.println("Do you have money to add in your balance?");
		System.out.println("Press Y for Yes. Press N or any other key for No");
		choice = scanner.next();
		if (choice.equalsIgnoreCase("Y")) {
			System.out.println("Enter the amount you want to put:");
			balance = scanner.nextInt();
		}
		login = new Login(custName, custPassword, custID);
		customer = new Customer(balance, custID, custName);
		result = loginDAO.register(login);
		bankDAO.addCustomer(customer);
		bankDAO.createAccount(custID, balance);
		if (result) {
			System.out.println("Congrats" + custName);
		} else {
			System.out.println("Sorry");
		}
	}

	public void personalPage(int userId) {
		// database code
		while (true) {
			String name = bankDAO.getCustomerName(userId);
			System.out.println("Welcome");
			System.out.println("############### Personal page for " + name + " ##############");
			System.out.println("1. View Balance");
			bankDAO.viewAccount();
			System.out.println("2. Transfer amount");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Open a new Bank Account");
			System.out.println("6. Transer money to an account");
			System.out.println("7. Check for pending transfers from someone");
			System.out.println("8. Logout");
			System.out.println("9. Exit");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				int account = 0;
				System.out.println("View Balance");
				System.out.println("Check which account you want to see");
				account = scanner.nextInt();
				System.out.println(name + ", your balance is: " + bankDAO.getBalance(userId, account));
				break;
			case 2:
				System.out.println("Transfer Amount");
				break;
			case 3:
				System.out.println("Deposit");
				System.out.println("How much money do you want to deposit?");
				int dep = scanner.nextInt();
				bankDAO.depositToAccount(dep);
				break;
			case 4:
				System.out.println("Withdraw");
				System.out.println("How much money do you want to withdraw?");
				int wit = scanner.nextInt();
				bankDAO.withdrawFromAccount(wit);
				break;
			case 5:
				System.out.println("Open a New Bank Account");
				bankDAO.createAccount(userId, 0);
				break;
			case 6:
				System.out.println("Transfer to an account");
				break;
			case 7:
				System.out.println("Check for pending incoming transfers");
				break;
			case 8:
				login();
				break;
			case 9:
				System.out.println("See you later");
				startBankApp();
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
	
	public void deposit() {
		
	}
	
	public void withdraw() {
		
	}

	public void bankPage(int userId) {
		while(true) {
			String name = bankDAO.getEmployeeName(userId);
			int choice = 0;
			System.out.println("Welcome back "+name);
			System.out.println("1. Check for pending transactions");
			System.out.println("2. View a customer's account");
			System.out.println("9. E X I T");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("List of pending transactions");
				break;
			case 2:
				System.out.println("Customer bank accounts");
				break;
			case 9:
				System.out.println("See you later");
				startBankApp();
				break;
			}
		}
	}
	
}

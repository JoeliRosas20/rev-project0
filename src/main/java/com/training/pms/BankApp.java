package com.training.pms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.training.pms.bank.Bank;
import com.training.pms.bank.Customer;
import com.training.pms.bank.Employee;
import com.training.pms.bank.Login;
import com.training.pms.bank.Transfer;
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
	Bank bank = new Bank();
	Login login = new Login();
	List<Bank> pending = new ArrayList<Bank>();
	List<Transfer> transfer = new ArrayList<Transfer>();
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
		case 1:// LOGIN
			System.out.println("Login");
			login();
			break;
		case 2:// CREATE NEW ACCOUNT
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
			System.out.println("########Login Screen##########");
			System.out.println("Please enter the type of login (C - Customer /E - Employee ) : ");
			System.out.println("Press L to leave");
			choice = scanner.next().charAt(0);
			switch (choice) {
			case 'E':
				System.out.println("Please enter your employee id: ");
				userID = scanner.nextInt();
				System.out.println("Please enter your password: ");
				password = scanner.next();
				if (loginDAO.validate(userID, password)) {
					bankPage(userID);
				} else {
					System.out.println("Invalid. Try again");
					continue;
				}
				break;
			case 'C':
				System.out.println("Please enter your customer id: ");
				userID = scanner.nextInt();
				System.out.println("Please enter your password: ");
				password = scanner.next();
				if (loginDAO.validate(userID, password)) {
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
		while (true) {
			int empID = 0;
			String empName = " ";
			String empPassword = " ";
			System.out.println("Account details for Employee");
			System.out.println("Enter employee id : ");
			empID = scanner.nextInt();
			System.out.println("Enter employee name : ");
			empName = scanner.next();
			System.out.println("Enter your password : ");
			empPassword = scanner.next();
			if (bankDAO.userIdAlreadyTaken(empID)) {
				System.out.println("ID is already taken. Please put something else.");
				continue;
			} else {
				login = new Login(empName, empPassword, empID);
				employee = new Employee(empID, empName);
				result = loginDAO.register(login);
				bankDAO.addEmployee(employee);
				if (result) {
					System.out.println("Congrats " + empName);
					startBankApp();
				} else {
					System.out.println("Sorry");
					startBankApp();
				}
			}
		}
	}

	public void customerCreate() {
		while (true) {
			int custID = 0;
			String custName = " ";
			String custPassword = " ";
			String choice = " ";
			int balance = 0;
			// Beginning
			System.out.println("Account details for Customer ?");
			System.out.println("Enter customer id : ");
			custID = scanner.nextInt();
			System.out.println("Enter customer name : ");
			custName = scanner.next();
			System.out.println("Enter your password : ");
			custPassword = scanner.next();
			if (bankDAO.userIdAlreadyTaken(custID)) {
				System.out.println("ID is already taken. Please put something else.");
				continue;
			} else {
				System.out.println("Do you have money to add in your balance?");
				System.out.println("Press Y for Yes. Press N or any other key for No");
				choice = scanner.next();
				if (choice.equalsIgnoreCase("Y")) {
					System.out.println("Enter the amount you want to put:");
					balance = scanner.nextInt();
					if(balance < 0) {
						System.out.println("You can not insert a negative balance");
						continue;
					}
				}
				// Inserting the account
				login = new Login(custName, custPassword, custID);
				customer = new Customer(balance, custID, custName);
				result = loginDAO.register(login);
				bankDAO.addCustomer(customer);
				bankDAO.sendForApproval(customer);
				int accId = bankDAO.getAccountId(custID, balance);
				if (result) {
					System.out.println("Congrats " + custName + " your account ID is " + accId);
					startBankApp();
				} else {
					System.out.println("Sorry");
					startBankApp();
				}
			}
		}
	}

	public void personalPage(int userId) {
		// database code
		while (true) {
			boolean created = false;
			boolean sent = false;
			boolean recieved = false;
			String name = bankDAO.getCustomerName(userId);
			System.out.println("Welcome");
			System.out.println("############### Personal page for " + name + " ##############");
			System.out.println("1. View Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Open a new Bank Account");
			System.out.println("5. Transer money to an account");
			System.out.println("6. Check for pending transfers from someone");
			System.out.println("7. Logout");
			System.out.println("8. Exit");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:// VIEW BALANCE
				int account = 0;
				System.out.println("View Balance");
				if (bankDAO.areThereAccounts(userId)) {// DAO
					System.out.println("Check which account you want to see");
					account = scanner.nextInt();
					System.out.println(
							name + ", your balance for " + account + " is: $" + bankDAO.getBalance(userId, account));// DAO
				} else {
					System.out.println(
							"You have no accounts. Please go to make one or wait for approval if you already submitted.");
				}
				break;
			case 2:// DEPOSIT
				System.out.println("Deposit");
				System.out.println("How much money do you want to deposit?");
				int dep = scanner.nextInt();
				System.out.println("In which account do you want to deposit in?");
				int acc = scanner.nextInt();
				bankDAO.depositToAccount(acc, dep);// DAO
				break;
			case 3:// WITHDRAW
				System.out.println("Withdraw");
				System.out.println("How much money do you want to withdraw?");
				int wit = scanner.nextInt();
				System.out.println("In which account do you want to withdraw?");
				int acc2 = scanner.nextInt();
				bankDAO.withdrawFromAccount(acc2, wit);// DAO
				break;
			case 4:// OPEN NEW ACCOUNT
				System.out.println("Open a New Bank Account");
				System.out.println("How much money do you want to deposit?");
				int num = scanner.nextInt();
				created = bankDAO.createOtherAccount(userId, num);// DAO
				int accId = bankDAO.getAccountId(userId, num);// DAO
				if (created) {
					System.out.println("Congrats" + name + " your account ID is " + accId);
				} else {
					System.out.println("Sorry");
				}
				break;
			case 5:// TRANSFER TO AN ACCOUNT
				System.out.println("Transfer to an account");
				System.out.println("Transfer to your own account or someone else?");
				System.out.println("1 for your own account, 2 for someone else");
				int option = scanner.nextInt();
				if (option == 1) {
					System.out.println("Which account do you want to transfer from?");
					int account1 = scanner.nextInt();
					System.out.println("To which account do you want to send it to?");
					int account2 = scanner.nextInt();
					System.out.println("How much do you want to send?");
					int transfer = scanner.nextInt();
					sent = bankDAO.transferMoney(account1, account2, transfer);// DAO
					if (sent) {
						System.out.println("Success");
					}
				}
				else if(option == 2) {
					System.out.println("Which account do you want to transfer from?");
					int accCreditor = scanner.nextInt();
					System.out.println("Insert the person's Id");
					int receiverId = scanner.nextInt();
					System.out.println("How much do you want to send?");
					int transfer = scanner.nextInt();
					bankDAO.withdrawFromAccount(accCreditor, transfer);
					sent = bankDAO.transferMoneyToOthers(receiverId, transfer, "customer");
					if(sent) {
						System.out.println("Success");
					}
					else {
						System.out.println("Try again");
					}
				}
				break;
			case 6:// CHECK FOR INCOMING TRANSFERS
				System.out.println("Check for pending incoming transfers");
				System.out.println("Enter your id");
				int debitorId = scanner.nextInt();
				transfer = bankDAO.viewIncomingTransfers(debitorId);
				if(transfer.size() == 0) {
					System.out.println("No incoming transfers");
				}else {
					System.out.println("Here are the incoming transfers");
					printPendingTransfers(transfer);
					System.out.println("Press 1 to accept, Press 2 to deny");
					int pick = scanner.nextInt();
					if(pick == 1) {
						System.out.println("Select the transfer id");
						int transfer = scanner.nextInt();
						System.out.println("To which account do you want to recieve this transfer?");
						int accountChoice = scanner.nextInt();
						int money = bankDAO.acceptTransfer(transfer);
						bankDAO.depositToAccount(accountChoice, money);
						bankDAO.deleteTransfer(transfer);
					}else if(pick == 2) {
						System.out.println("Select the transfer id");
						int transfer = scanner.nextInt();
						bankDAO.deleteTransfer(transfer);
						System.out.println("Transfer denied");
					}
				}
				break;
			case 7:// LOGIN PAGE
				login();
				break;
			case 8:// SEE YA
				System.out.println("See you later");
				startBankApp();
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	public void bankPage(int userId) {
		while (true) {
			String name = bankDAO.getEmployeeName(userId);// DAO
			int choice = 0;
			System.out.println("Welcome back " + name);
			System.out.println("1. Check for pending transactions");
			System.out.println("2. View a customer's account");
			System.out.println("3. View incoming account creation");
			System.out.println("9. E X I T");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:// LIST OF PENDING TRANSACTIONS
				System.out.println("List of pending transactions");
				break;
			case 2:// VIEW CUSTOMER'S ACCOUNTS
				System.out.println("Customer bank accounts");
				System.out.println("Enter customer id");
				int custId = scanner.nextInt();
				if (bankDAO.areThereAccounts(custId)) {// DAO
					System.out.println("Select their account");
					int accId = scanner.nextInt();
					Bank bank = bankDAO.viewAccount(custId, accId);// DAO
					String custName = bankDAO.getCustomerName(custId);// DAO
					System.out.print(custName + "'s bank account: ");
					System.out.println(bank);
				} else {
					System.out.println(
							"This user does not have any. Check the approval section if they just created one.");
				}
				break;
			case 3:// PENDING ACCOUNT CREATIONS
				System.out.println("Pending account creations");
				pending = bankDAO.getPendings();// DAO
				if (pending.size() == 0) {
					System.out.println("There are no accounts waiting for approval");
				} else {
					printPendingAccounts(pending);
					System.out.println("Press 1 to approve, Press 2 to reject");
					int pick = scanner.nextInt();
					if (pick == 1) {
						System.out.println("Which account will you approve");
						int accChoice = scanner.nextInt();
						Bank temp = bankDAO.getPendingBankAccount(accChoice);// DAO
						System.out.println("Are you sure?");
						String sure = scanner.next();
						if (sure.equals("Yes")) {
							bankDAO.createAccount(temp);// DAO
							bankDAO.removeAccounts(accChoice);// DAO
							System.out.println("Account approved");
						} else {
							continue;
						}
					} else if (pick == 2) {
						System.out.println("Which account will you reject");
						int accChoice = scanner.nextInt();
						bankDAO.removeAccounts(accChoice);// DAO
						System.out.println("Account rejected");

					} else {
						System.out.println("I did not understand, try again");
					}
				}
				break;
			case 9:// SEE YA
				System.out.println("See you later");
				startBankApp();
				break;
			}
		}
	}

	public void printPendingAccounts(List<Bank> pending) {
		Iterator<Bank> iterator = pending.iterator();
		while (iterator.hasNext()) {
			Bank temp = iterator.next();
			System.out.println(temp);
		}
	}
	
	public void printPendingTransfers(List<Transfer> pending) {
		Iterator<Transfer> iterator = pending.iterator();
		while (iterator.hasNext()) {
			Transfer temp = iterator.next();
			System.out.println(temp);
		}
	}

}

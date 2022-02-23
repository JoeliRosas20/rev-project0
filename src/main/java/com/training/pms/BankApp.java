package com.training.pms;

import java.util.Scanner;

import com.training.pms.dao.BankDAO;
import com.training.pms.dao.BankDAOImpl;

public class BankApp {
	
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	BankDAO bankDAO = new BankDAOImpl();
	
	public void startBankApp() {
		System.out.println("Entering");
        while(true) {
        	System.out.println( "###################################" );
            System.out.println("	Joel Banking App");
            System.out.println( "###################################" );
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
		switch(num) {
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
			System.out.println("Default");
		}
	}
	
	public void login() {
		char choice = ' ';
		int userID = 0;
		System.out.println("########Login Screen##########");
		System.out.println("Please enter the type of login (C - Customer /E - Employee ) : ");
		choice = scanner.next().charAt(0);
		if(choice != 'E' && choice != 'C') {
			System.out.println("Invalid input, please try again");
			choice = scanner.next().charAt(0);
		}
		if(choice == 'E') {
			System.out.println("Please enter your employee id: ");
			userID = scanner.nextInt();
		}
		if(choice == 'C') {
			System.out.println("Please enter your customer id: ");
			userID = scanner.nextInt();
			personalPage(userID);
		}
	}
	
	public void createAccount() {
		char choice = ' ';
		System.out.println("Welcome to create/open account section");
		System.out.println("Please enter the details to open an acccount:");
		System.out.println("Enter your account type ( E for Employee / C for Customer ):");
		choice = scanner.next().charAt(0);
		if(choice != 'E' && choice != 'C') {
			System.out.println("Incorrect account type, please enter again ");
			System.out.println("Enter your account type ( E for Employee / C for Customer ):");
			choice = scanner.next().charAt(0);
		}
		if(choice == 'E') {
			employeeCreate();
		}
		else if(choice == 'C') {
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
		//Database code
		System.out.println("Congrats"+empName);
	}
	
	public void customerCreate() {
		int custID = 0;
		String custName = " ";
		String custPassword = " ";
		System.out.println("Account details for Customer ?");
		System.out.println("Enter customer id : ");
		custID = scanner.nextInt();
		System.out.println("Enter customer name : ");
		custName = scanner.next();
		System.out.println("Enter your password : ");
		custPassword = scanner.next();
		System.out.println("Congrats" + custName);
	}
	
	public void personalPage(int num) {
		//database code
		int choice = scanner.nextInt();
		System.out.println("Welcome");
		System.out.println("###############Personal page for Neha##############");
		System.out.println("1. View Balance");
		bankDAO.viewAccount();
		System.out.println("2. Transfer amount");
		System.out.println("8. Logout");
		System.out.println("9. Exit");
		System.out.println("Enter your choice : ");
		switch(choice) {
			case 1:
				
		}
	}

}

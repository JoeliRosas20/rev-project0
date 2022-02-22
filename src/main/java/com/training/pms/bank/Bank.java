package com.training.pms.bank;

import java.util.Scanner;

public class Bank {
	
	static Scanner scanner = new Scanner(System.in);
	
	public void startBankApp() {
		System.out.println("Entering");
		int choice = 0;
        Bank.message();
        while(scanner.hasNext()) {
        	choice = scanner.nextInt();
        	Bank.choice(choice);
        	//Bank.message();
		}
        System.out.println("Leaving");
	}
	
	public static void message() {
		System.out.println( "###################################" );
        System.out.println("	Joel Banking App");
        System.out.println( "###################################" );
        System.out.println("1 Login");
        System.out.println("2 Create Account");
        System.out.println("3 Know more about the Banking App");
        System.out.println("4 Know more about the developers");
        System.out.println("10.E X I T");
	}
	
	public static void choice(int num) {
		switch(num) {
		case 1:
			System.out.println("Login");
			break;
		case 2:
			System.out.println("Create a new account");
			createAccount();
			break;
		case 3:
			System.out.println("Know about app");
			break;
		case 4:
			System.out.println("Know about Devs");
			break;
		default:
			System.out.println("Default");
			System.exit(0);
		}
	}
	
	public static void createAccount() {
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
	
	public static void employeeCreate() {
		System.out.println("Account details for Employee ?");
		System.out.println("Enter employee id : ");
		System.out.println("Enter employee name : ");
		System.out.println("Enter your password : ");
		System.out.println("Congrats");
	}
	
	public static void customerCreate() {
		System.out.println("Account details for Customer ?");
		System.out.println("Enter customer id : ");
		System.out.println("Enter customer name : ");
		System.out.println("Enter your password : ");
		System.out.println("Congrats");
	}
	
	public void login() {
		
	}
	
	public void bankingAppInfo() {
		
	}
	
	public void devInfo() {
		System.out.println("About Me:");
	}

}

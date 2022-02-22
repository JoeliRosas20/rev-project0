package com.training.pms.bank;

import java.util.Scanner;

public class Bank {
	
	public void startBankApp() {
		Scanner scanner = new Scanner(System.in);
        System.out.println( "###################################" );
        System.out.println("	Joel Banking App");
        System.out.println( "###################################" );
        System.out.println("1 Login");
        System.out.println("2 Create Account");
        System.out.println("3 Know more about the Banking App");
        System.out.println("4 Know more about the developers");
        int choice = scanner.nextInt();
        Bank.choice(choice);
	}
	
	public static void choice(int num) {
		switch(num) {
		case 1:
			System.out.println("Login");
			break;
		case 2:
			System.out.println("Create a new account");
			break;
		case 3:
			System.out.println("Know about app");
			break;
		case 4:
			System.out.println("Know about Devs");
			break;
		default:
			System.out.println("Default");
		}
	}
	
	public void createAccount() {
		
	}
	
	public void login() {
		
	}
	
	public void bankingAppInfo() {
		
	}
	
	public void devInfo() {
		
	}

}

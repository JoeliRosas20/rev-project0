package com.training.pms.bank;

public class Bank {
	
	public static void choice(int num) {
		switch(num) {
		case 1:
			System.out.println("Login");
			break;
		case 2:
			System.out.println("Create a new account");
			break;
		default:
			System.out.println("Default");
		}
	}

}

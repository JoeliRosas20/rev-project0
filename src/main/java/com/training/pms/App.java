package com.training.pms;

import java.util.Scanner;

import com.training.pms.bank.Bank;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
        System.out.println( "Hello There!" );
        System.out.println("Press 1 to log in");
        System.out.println("Press 2 to create an account");
        int choice = scanner.nextInt();
        Bank.choice(choice);
    }
    
}

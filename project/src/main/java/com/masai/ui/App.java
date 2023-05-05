package com.masai.ui;

import java.util.*;
public class App 
{
	static void adminLogin(Scanner sc) {
		System.out.println("Enter user name ");
		String user=sc.next();
		System.out.println("Enter password ");
		String pass=sc.next();
		if(user == "admin" && pass== "admin") {
			
		}else {
			System.out.println("Invalid username or password!!");
		}
	}
    public static void main( String[] args )
    {
        Scanner sc= new Scanner(System.in);
        int choice=0;
        do {
			System.out.println("1. Admin Login");
			System.out.println("2. General data");
			System.out.println("0. Exit");
			System.out.println("Enter your selection");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				adminLogin(sc);
				break;

			default:
				break;
			}
		} while (choice!=0);
    }
}

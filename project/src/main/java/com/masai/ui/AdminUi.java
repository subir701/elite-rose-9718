package com.masai.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.masai.Entity.Crime;

public class AdminUi {
	static void addCrime(Scanner sc) {
		System.out.println("Enter type of crime (Robbery, Theft, Homicide) : ");
		String type=sc.next();
		System.out.println("Enter Description of crime : ");
		sc.nextLine();
		String description=sc.nextLine();
		System.out.println("Enter police station area : ");
		sc.nextLine();
		String ps_area=sc.nextLine();
		System.out.println("Enter date of crime : ");
		LocalDate date=LocalDate.parse(sc.next());
		System.out.println("Enter number of victims : ");
		int num=sc.nextInt();
		System.out.println("Enter name of victims : ");
		ArrayList<String> nameofVictims=new ArrayList<>();
		for(int i=0;i<num;i++) {
			sc.nextLine();
			String name=sc.nextLine();
			nameofVictims.add(name);
		}
		Crime crime=new Crime(type, description, ps_area, date, nameofVictims, null);
		C
	}
}

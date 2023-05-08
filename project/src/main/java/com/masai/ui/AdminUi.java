package com.masai.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.masai.service.*;
import com.masai.Entity.Crime;
import com.masai.Entity.Criminal;
import com.masai.Exception.AlreadyExistException;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongFetchingException;
import com.masai.Exception.SomethingWrongAddingException;

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
		CrimeService crimeservice= new CrimeServiceImpl();
		try {
			crimeservice.addCrime(crime);
			System.out.println("Crime added successfully");
		}catch(SomethingWrongAddingException ex) {
			System.out.println(ex.getMessage());
		}
	}
	static void addCriminal(Scanner sc) {
		System.out.println("Enter name of criminal : ");
		String name=sc.next();
		System.out.println("Enter date of birth criminal : ");
		LocalDate dob=LocalDate.parse(sc.next());
		System.out.println("Enter gender of criminal (M/F) : ");
		char gender=sc.next().charAt(0);
		System.out.println("Enter identifying marks of criminal : ");
		sc.nextLine();
		String marks=sc.nextLine();
		System.out.println("Enter first arrest date of criminal : ");
		LocalDate date=LocalDate.parse(sc.next());
		System.out.println("Enter police station area ");
		sc.nextLine();
		String ps=sc.nextLine();
		Criminal criminal=new Criminal(name, dob, gender, marks, date, ps, null);
		CriminalService criminalservice=new CriminalServiceImpl();
		try {
			criminalservice.addCriminal(criminal);
			System.out.println("Criminal added successfully");
		}catch(SomethingWrongAddingException | AlreadyExistException ex) {
			System.out.println(ex.getMessage());
		}
	}
	static void viewCrime() {
		CrimeService crimeservice=new CrimeServiceImpl();
		try {
			List<Crime> crimeList = crimeservice.getCrimeList();
			crimeList.forEach(System.out::println);
		}catch(SomethingWentWrongFetchingException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	static void viewCriminal() {
		CriminalService criminalservice=new CriminalServiceImpl();
		try {
			List<Criminal> criminalList=criminalservice.getCriminalList();
			criminalList.forEach(System.out::println);
		}catch(SomethingWentWrongFetchingException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	static void updateCrime(Scanner sc) {
		System.out.println("Enter crime id");
		int id=sc.nextInt();
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
		crime.setCrimeId(id);
		CrimeService crimeservice= new CrimeServiceImpl();
		try {
			crimeservice.updateCrime(crime);
			System.out.println("Crime updated successfully");
		}catch(SomethingWentWrongFetchingException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	static void upadateCriminal(Scanner sc) {
		System.out.println("Enter criminal id : ");
		int id=sc.nextInt();
		System.out.println("Enter name of criminal : ");
		String name=sc.next();
		System.out.println("Enter date of birth criminal : ");
		LocalDate dob=LocalDate.parse(sc.next());
		System.out.println("Enter gender of criminal (M/F) : ");
		char gender=sc.next().charAt(0);
		System.out.println("Enter identifying marks of criminal : ");
		sc.nextLine();
		String marks=sc.nextLine();
		System.out.println("Enter first arrest date of criminal : ");
		LocalDate date=LocalDate.parse(sc.next());
		System.out.println("Enter police station area ");
		sc.nextLine();
		String ps=sc.nextLine();
		Criminal criminal=new Criminal(name, dob, gender, marks, date, ps, null);
		criminal.setCriminalId(id);
		CriminalService criminalservice=new CriminalServiceImpl();
		try {
			criminalservice.updateCriminal(criminal);
			System.out.println("Criminal updated successfully");
		}catch(SomethingWentWrongFetchingException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	static void deleteCriminal(Scanner sc) {
		System.out.println("Enter criminal id : ");
		int id=sc.nextInt();
		CriminalService criminalservice=new CriminalServiceImpl();
		try {
			criminalservice.deleteCriminal(id);
			System.out.println("Criminal deleted successfully");
		}catch(SomethingWentWrongFetchingException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	static void deleteCrime(Scanner sc) {
		System.out.println("Enter crime id : ");
		int id=sc.nextInt();
		CrimeService crimeservice= new CrimeServiceImpl();
		try {
			crimeservice.deleteCrime(id);
			System.out.println("Crime deleted successfully");
		}catch(SomethingWentWrongFetchingException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

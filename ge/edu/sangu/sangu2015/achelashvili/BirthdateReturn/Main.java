package ge.edu.sangu.sangu2015.achelashvili.BirthdateReturn;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

	

	private static Scanner scanner;

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		String Name,Surname; int ID;
		
		System.out.println(" Input Name , Surname , ID");
		scanner = new Scanner(System.in);
		Name = scanner.nextLine();
		Surname= scanner.nextLine();
		ID = scanner.nextInt();
		
		System.out.println(" Input Year , Month , Day");
		scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		scanner.close();
		date.set(year, month, day);
		
		// Check if Date Assignment Works... //
		// System.out.println(date.getTime());

		Human User = new Human(Name,Surname,ID,date);
		User.getYear();
	}
}

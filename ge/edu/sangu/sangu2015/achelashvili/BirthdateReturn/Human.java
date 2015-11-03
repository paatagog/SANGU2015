package ge.edu.sangu.sangu2015.achelashvili.BirthdateReturn;

import java.util.Calendar;

public class Human {
	private String name;
	private String surname;
	private int id_num;
	private Calendar date;
	private int year;
	private int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
	
	public Human(String name,String surname,int id_num,Calendar date){
		this.name = name;
		this.surname= surname;
		this.id_num = id_num;
		this.date = date;
		this.year = date.get(Calendar.YEAR);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num) {
		this.id_num = id_num;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}

	public int getYear() {
		
		System.out.println(" Your Birthdate: " +year);
		year = getCurrentYear() - date.get(Calendar.YEAR);
		System.out.println(" Your Age: " + year);
		return year;
	}

	public void setYear(int year) {
		
	}
	public int getCurrentYear() {		
		return CurrentYear;
	}
	public void setCurrentYear(int currentYear) {
		
	}

}

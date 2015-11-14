package ge.edu.sangu.sangu2015.achelashvili.ExcelReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		
		
		//Excel2007Editor.ReadAndPrint("StudentsSheet.xls"); // Read From WorkSpace
		Excel2007Editor ExcelWorks = new Excel2007Editor();
		List<StudentsBase> studentList= new ArrayList<StudentsBase>();
		studentList.addAll(ExcelWorks.ReadNCreateList());
	    Collections.sort(studentList);
		
	for (int i = 0; i < studentList.size(); i++) { // + Value(...."")
		System.out.printf("%10s%15s%20s%13s%27s%7s%16s%5s%n",
				studentList.get(i).getName(),
				studentList.get(i).getSurname(),
				studentList.get(i).getId(),
				studentList.get(i).getDay(),
				studentList.get(i).getSubject(),
				studentList.get(i).getRoom(),
				studentList.get(i).getLecturer(),
				studentList.get(i).getHour());
		}

		
	}
	public static void ClassValueAssignStudents(){ // Standard Way Assign Values to Class Object: StudentsBase
		
		List<StudentsBase> studentList= new ArrayList<StudentsBase>();
		studentList.add(new StudentsBase("Nika","Kakalashvili","36001049443","Monday","HTML","201","Revazishvili",9));
		studentList.add(new StudentsBase("Tornike","Kurdghelashvili","36001049443","Sunday","C#","103","Tsereteli",9));
		studentList.add(new StudentsBase("Avto","Achelashvili","36001049443","Thusday","JAVA","104","Gogishvili",9));
		studentList.add(new StudentsBase("Avto","Achelashvili","36001049443","Monday","HTML","201","Revazishvili",9));
		studentList.add(new StudentsBase("Tornike","Kurdghelashvili","36001049443","Thusday","JAVA","104","Gogishvili",9));
		studentList.add(new StudentsBase("Mariam","Zedginidze","36001049443","Friday","Algorithms","105","Meladze",11));
		Collections.sort(studentList);
		
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).getName() + " " + studentList.get(i).getSurname() + " "+ studentList.get(i).getId() + " " + studentList.get(i).getRoom());
		}
	}
}
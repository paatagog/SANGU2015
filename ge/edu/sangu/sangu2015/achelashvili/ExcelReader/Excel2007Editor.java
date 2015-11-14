package ge.edu.sangu.sangu2015.achelashvili.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *  ExcelEditor Class
 *  
 *  Features: Read All Data And Show
 *
 * @author MadHackers
 *
 */

public class Excel2007Editor{
	
	private static Workbook wr; // Object Excel File
	private static Sheet sheet; // Excel File Sheet
	private String st_name;
	private String st_surname;
	private String id_num;
	private String day;
	private String subject;
	private String room;
	private String lecturer;
	private int hour;
	
	public void CreatEmpty(String FileName){
	wr = new HSSFWorkbook(); // Generate New Excel File Object
	sheet = wr.createSheet("MySheet0"); // Add Sheet Name: Default:Sheet0
	
	FileName+=".xls";
	FileOutputStream fos;
	
	try {
		fos = new FileOutputStream(FileName);
		wr.write(fos);
		fos.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	//String A = "MyExcel";
	//Excel2007FileCreator.CreateNew(A);
	try {
		wr.close(); // Closing Thread
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public void ReadAndPrint(String FileLink){

		try {	
	InputStream in = new FileInputStream(FileLink);
    // InputStream Closes Mediately!
    HSSFWorkbook wb = new HSSFWorkbook(in);

    ExcelExtractor extractor = new ExcelExtractor(wb); // Extract Excel File
    
    extractor.setFormulasNotResults(false); // Count Formulas
    
    extractor.setIncludeSheetNames(true); // Include Sheet Names
    
    String text = extractor.getText(); // Extract Excel File Data
    
    extractor.close();// Closing extractor
    
    	System.out.println(text);
			} catch (FileNotFoundException e) {e.printStackTrace();} 
				catch (IOException e) {e.printStackTrace();}
	}
	
	public List<StudentsBase> ReadNCreateList(){
		List<StudentsBase> studentList= new ArrayList<StudentsBase>();
		try {
			
			FileInputStream fis = new FileInputStream("src/ge/edu/sangu/sangu2015/achelashvili/ExcelReader/Source/StudentsSheet.xls"); // Starting From src Dir
			wr = new HSSFWorkbook(fis);
			fis.close();
			
			/**
				Header -> Row(0) & Cell(0) No Need To Modify 
			*/
			
			for (int i = 1; i < wr.getSheetAt(0).getLastRowNum()+1; i++) { // +1 Show Latest Record IN

				this.st_name = wr.getSheetAt(0).getRow(i).getCell(1).getStringCellValue();
				this.st_surname = wr.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
				this.id_num = wr.getSheetAt(0).getRow(i).getCell(3).toString();
				this.day = wr.getSheetAt(0).getRow(i).getCell(4).getStringCellValue();
				this.subject = wr.getSheetAt(0).getRow(i).getCell(5).getStringCellValue();
				this.room = wr.getSheetAt(0).getRow(i).getCell(6).toString();
				this.lecturer = wr.getSheetAt(0).getRow(i).getCell(7).getStringCellValue();
				this.hour =  (int) wr.getSheetAt(0).getRow(i).getCell(8).getNumericCellValue();
				studentList.add(new StudentsBase(getSt_name(),getSt_surname(),getId_num(),getDay(),getSubject(),getRoom(),getLecturer(),getHour()));
				
				// Read Values From Each Row. Can Be Added Many Rows From Out
				// if Add new Cell, Program will not Read New Cell Data!
			}
			
			HeaderPrint(wr);
			
		} catch (FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e){e.printStackTrace();}
		return studentList;
		
	}
	
	public void HeaderPrint(Workbook wr){

		System.out.printf("%9s%21s%20s%18s%30s%12s%17s%7s%n%n",
				wr.getSheetAt(0).getRow(0).getCell(1),
				wr.getSheetAt(0).getRow(0).getCell(2),
				wr.getSheetAt(0).getRow(0).getCell(3),
				wr.getSheetAt(0).getRow(0).getCell(4),
				wr.getSheetAt(0).getRow(0).getCell(5),
				wr.getSheetAt(0).getRow(0).getCell(6),
				wr.getSheetAt(0).getRow(0).getCell(7),
				wr.getSheetAt(0).getRow(0).getCell(8));
	}

	public Workbook getWr() {
		return wr;
	}
	public void setWr(Workbook wr) {
		Excel2007Editor.wr = wr;
	}
	public Sheet getSheet() {
		return sheet;
	}
	public void setSheet(Sheet sheet) {
		Excel2007Editor.sheet = sheet;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_surname() {
		return st_surname;
	}

	public void setSt_surname(String st_surname) {
		this.st_surname = st_surname;
	}

	public String getId_num() {
		return id_num;
	}

	public void setId_num(String id_num) {
		this.id_num = id_num;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}

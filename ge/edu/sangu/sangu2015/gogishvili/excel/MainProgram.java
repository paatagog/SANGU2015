package ge.edu.sangu.sangu2015.gogishvili.excel;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class MainProgram {
	
	
	public static void main(String[] args) {
		
		List<StudentCourse> cources = new ArrayList<StudentCourse>();
		List<String> failebisSaxelebi = new ArrayList<String>();
		failebisSaxelebi.add("D:/test.xls");		
		readFromFiles(cources, failebisSaxelebi);
		sortSchedule(cources);
		writeToFiles(cources,"shedegi.xlsx");
	}

	private static void writeToFiles(List<StudentCourse> cources, String fileName) {
		// TODO es funqcia aris dasamtavrebeli		
	}

	private static void sortSchedule(List<StudentCourse> cources) {
		Collections.sort(cources);
	}

	private static void readFromFiles(List<StudentCourse> cources, List<String> fileNames) {
		for (String fileName : fileNames) {
			try {
				FileInputStream file = new FileInputStream(new File(fileName));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				Row row  = rowIterator.next();
				boolean isData = true;
				while (isData) {
					Iterator<Cell> cellIterator = row.cellIterator();
					Cell cell = cellIterator.next();
					if (cell.getStringCellValue() == null || cell.getStringCellValue().equals("")) {
						isData = false;
					} else {
						StudentCourse sc = new StudentCourse();
						sc.setStudentId(cell.getStringCellValue());
						cell = cellIterator.next();
						sc.setStudentName(cell.getStringCellValue());
						cell = cellIterator.next();
						sc.setStudentSecondName(cell.getStringCellValue());
						cell = cellIterator.next();
						sc.setDay(cell.getStringCellValue());
						cell = cellIterator.next();
						sc.setHour((int)Math.round(cell.getNumericCellValue()));
						cell = cellIterator.next();
						sc.setCourseName(cell.getStringCellValue());
						cell = cellIterator.next();
						sc.setLecturer(cell.getStringCellValue());
						cell = cellIterator.next();
						sc.setRoom(cell.getStringCellValue());
						cources.add(sc);
						if (rowIterator.hasNext()) {
							row  = rowIterator.next();
						} else {
							isData = false;
						}
					}
				}
				workbook.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				log("ERROR");
				log("temporary change");
			}
		}
	}
	
	private static void log(String message) {
		System.out.print(message);
		
	}

	private static void generateSampleData(List<StudentCourse> cources) {
		StudentCourse sc = new StudentCourse();
		sc.setCourseName("დაპროგრამების ენა Java");
		sc.setStudentId("00012345678");
		sc.setStudentName("გიორგი");
		sc.setStudentSecondName("გიორგაძე");
		sc.setRoom("104");
		sc.setDay("სამშაბათი");
		sc.setHour(9);
		cources.add(sc);
		
		sc = new StudentCourse();
		sc.setCourseName("დაპროგრამების ენა Java");
		sc.setStudentId("00012345678");
		sc.setStudentName("გიორგი");
		sc.setStudentSecondName("გიორგაძე");
		sc.setRoom("104");
		sc.setDay("სამშაბათი");
		sc.setHour(10);
		cources.add(sc);
		
		sc = new StudentCourse();
		sc.setCourseName("დაპროგრამების ენა Java");
		sc.setStudentId("00012345678");
		sc.setStudentName("გიორგი");
		sc.setStudentSecondName("გიორგაძე");
		sc.setRoom("104");
		sc.setDay("სამშაბათი");
		sc.setHour(11);
		cources.add(sc);
		
		sc = new StudentCourse();
		sc.setCourseName("დაპროგრამების ენა Java");
		sc.setStudentId("00012345678");
		sc.setStudentName("გიორგი");
		sc.setStudentSecondName("გიორგაძე");
		sc.setRoom("104");
		sc.setDay("სამშაბათი");
		sc.setHour(12);
		cources.add(sc);
		
	}
}

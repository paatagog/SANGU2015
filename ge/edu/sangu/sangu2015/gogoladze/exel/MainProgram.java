package ge.edu.sangu.sangu2015.gogoladze.exel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import ge.edu.sangu.sangu2015.gogishvili.excel.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class MainProgram {
	
	
	public static void main(String[] args) {
		
		List<ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse> cources = new ArrayList<ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse>();
		List<String> failebisSaxelebi = new ArrayList<String>();
		failebisSaxelebi.add("C:\\Users\\104\\Desktop\\test.xls");		
		readFromFiles(cources, failebisSaxelebi);
		
		generateSampleData(cources);
		sortSchedule(cources);
		writeToFiles(cources,"C:\\Users\\104\\Desktop\\shedegi.xls");
		
	}

	private static void writeToFiles(List<ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse> cources, String fileName) {
		
		
		
	
		
		
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream(fileName);
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("POI Worksheet");
			for(int i=0; i<cources.size();i++){
				
			HSSFRow row1 = worksheet.createRow((short) i);
			
			
			for(int j=0; j<8;j++){
			

			HSSFCell cellA1 = row1.createCell((short) 0);
			cellA1.setCellValue(cources.get(i).getStudentId());
			

			HSSFCell cellA2 = row1.createCell((short) 1);
			cellA2.setCellValue(cources.get(i).getStudentSecondName());

			HSSFCell cellA3 = row1.createCell((short) 2);
			cellA3.setCellValue(cources.get(i).getStudentName());

			HSSFCell cellA4 = row1.createCell((short) 3);
			cellA4.setCellValue(cources.get(i).getDay());
		
			HSSFCell cellA5 = row1.createCell((short) 4);
			cellA5.setCellValue(cources.get(i).getHour());
			
			HSSFCell cellA61 = row1.createCell((short) 5);
			cellA61.setCellValue(cources.get(i).getCourseName());
			
			HSSFCell cellA6 = row1.createCell((short) 6);
			cellA6.setCellValue(cources.get(i).getRoom());
			
			HSSFCell cellA7 = row1.createCell((short) 7);
			cellA7.setCellValue(cources.get(i).getLecturer());
			
			}
			}
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
		
		
		
		
	

	private static void sortSchedule(List<ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse> cources) {
		Collections.sort(cources);
	}

	private static void readFromFiles(List<ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse> cources, List<String> fileNames) {
		for (String fileName : fileNames) {
			try {
				FileInputStream file = new FileInputStream(new File(fileName));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				Row row  = rowIterator.next();
				row  = rowIterator.next();
				boolean isData = true;
				while (isData) {
					Iterator<Cell> cellIterator = row.cellIterator();
					Cell cell = cellIterator.next();
					if (cell.getStringCellValue() == null || cell.getStringCellValue().equals("")) {
						isData = false;
					} else {
						ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse sc = new ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse();
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

	private static void generateSampleData(List<ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse> cources) {
		ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse sc = new ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse();
		sc.setCourseName("დაპროგრამების ენა Java");
		sc.setStudentId("00012345678");
		sc.setStudentName("გიორგი");
		sc.setStudentSecondName("გიორგაძე");
		sc.setRoom("104");
		sc.setDay("სამშაბათი");
		sc.setHour(9);
		cources.add(sc);
		
		ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse sc2 = new ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse();
		sc2.setCourseName("დაპროგრამების ენა Java");
		sc2.setStudentId("00012345678");
		sc2.setStudentName("გიორგი");
		sc2.setStudentSecondName("გიორგაძე");
		sc2.setRoom("104");
		sc2.setDay("სამშაბათი");
		sc2.setHour(10);
		cources.add(sc);
		
		sc = new ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse();
		sc.setCourseName("დაპროგრამების ენა Java");
		sc.setStudentId("00012345678");
		sc.setStudentName("გიორგი");
		sc.setStudentSecondName("გიორგაძე");
		sc.setRoom("104");
		sc.setDay("სამშაბათი");
		sc.setHour(11);
		cources.add(sc);
		
		sc = new ge.edu.sangu.sangu2015.gogishvili.excel.StudentCourse();
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

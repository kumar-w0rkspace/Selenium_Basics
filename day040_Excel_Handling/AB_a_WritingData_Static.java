package day040_Excel_Handling;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AB_a_WritingData_Static {

	public static void main(String[] args) throws IOException {

// creating workbook object
		XSSFWorkbook workBook = new XSSFWorkbook(); // dont need to pass file parameter while writing
		XSSFSheet sheet = workBook.createSheet("dataSheet");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Welcome");
		row1.createCell(1).setCellValue("To");
		row1.createCell(2).setCellValue("Excel");
		row1.createCell(3).setCellValue("data");
		row1.createCell(4).setCellValue("input");
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue(284675);
		row2.createCell(1).setCellValue(true);
		row2.createCell(2).setCellValue('X');
		row2.createCell(3).setCellValue(20.22);
		row2.createCell(4).setCellValue("String");
// create a new excel file and write data into it
		FileOutputStream fileToWrite = new FileOutputStream(
				System.getProperty("user.dir") + "\\TestData\\testFile.xlsx");

		workBook.write(fileToWrite);

		workBook.close();
		fileToWrite.close();
		System.out.println("Data written to file");

	}

}

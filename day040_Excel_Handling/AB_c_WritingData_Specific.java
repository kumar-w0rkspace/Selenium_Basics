package day040_Excel_Handling;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AB_c_WritingData_Specific {

	public static void main(String[] args) throws IOException {
		// creating workbook object
		XSSFWorkbook workBook = new XSSFWorkbook(); // dont need to pass file parameter while writing
		XSSFSheet sheet = workBook.createSheet("Specific entry dataSheet");

		XSSFRow row4 = sheet.createRow(4);
		XSSFCell cell4 = row4.createCell(3);
		cell4.setCellValue("Random cell value edited");

		// create a new excel file and write data into it
		FileOutputStream fileToWrite = new FileOutputStream(
				System.getProperty("user.dir") + "\\TestData\\testFile_Specific.xlsx");

		workBook.write(fileToWrite); // attach workbook to file
		workBook.close();
		fileToWrite.close();
		System.out.println("Data written to file");

	}

}

package day040_Excel_Handling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AB_b_WritingData_Dynamic {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		// creating workbook object
		XSSFWorkbook workBook = new XSSFWorkbook(); // dont need to pass file parameter while writing
		XSSFSheet sheet = workBook.createSheet("Dynamic dataSheet");
		System.out.print("Enter number of rows: ");
		int rows = sc.nextInt();
		System.out.print("Enter number of cells: ");
		int cells = sc.nextInt();

		for (int r = 0; r <= rows; r++) {
			XSSFRow currentRow = sheet.createRow(r); // new row
			for (int c = 0; c < cells; c++) {
				System.out.println("Enter data for " + (r + 1) + " row, " + (c + 1) + " cell");
				XSSFCell cell = currentRow.createCell(c); // new cell
				cell.setCellValue(sc.next()); // inputting data into the cell
			}
		}

		// create a new excel file and write data into it
		FileOutputStream fileToWrite = new FileOutputStream(
				System.getProperty("user.dir") + "\\TestData\\testFile_Dynamic.xlsx");

		workBook.write(fileToWrite); // attach workbook to file
		workBook.close();
		fileToWrite.close();
		System.out.println("Data written to file");

	}

}

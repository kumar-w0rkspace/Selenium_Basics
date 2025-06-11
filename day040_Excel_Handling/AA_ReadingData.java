package day040_Excel_Handling;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AA_ReadingData {

	public static void main(String[] args) throws IOException {
		// read the data from folder TestData
		FileInputStream fileToRead = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\datasheet.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fileToRead);
		XSSFSheet sheet1 = workBook.getSheet("Sheet1"); // name
		// XSSFSheet sheet1 = workBook.getSheetAt(0); // index
// finding the total no of rows
		int totalRows = sheet1.getLastRowNum();
		int totalCells = sheet1.getRow(0).getLastCellNum();
		System.out.println("Number of rows = " + totalRows); // counting rows from 0
		System.out.println("Number of cells = " + totalCells);// counting cells from 0

		for (int rows = 0; rows <= totalRows; rows++) {
			XSSFRow currentRow = sheet1.getRow(rows); // before reading cell, we need to get entire row
			System.out.println(" ");
			for (int col = 0; col < totalCells; col++) {
				XSSFCell currentCell = currentRow.getCell(col);
				System.out.print(currentCell.toString() + "\t");
			}
		}

		workBook.close();
		fileToRead.close();
	}

}

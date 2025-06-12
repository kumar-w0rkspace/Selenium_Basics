package day041_a_Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility_Excel {

	public static FileInputStream fileIn;
	public static FileOutputStream fileOut;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style; // styling cell

	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		fileIn = new FileInputStream(xlFile);
		workBook = new XSSFWorkbook(fileIn);
		sheet = workBook.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		workBook.close();
		fileIn.close();
		return rowCount;
	}

	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		fileIn = new FileInputStream(xlFile);
		workBook = new XSSFWorkbook(fileIn);
		sheet = workBook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workBook.close();
		fileIn.close();
		return cellCount;
	}

	public static String getCellData(String xlFile, String xlSheet, int rowNum, int cellNum) throws IOException {
		fileIn = new FileInputStream(xlFile);
		workBook = new XSSFWorkbook(fileIn);
		sheet = workBook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
// try catch is necessary because if there is no data in a cell, it will throw DataNotFoundException
		try {
			// data = cell.toString(); // works fine
			DataFormatter formatter = new DataFormatter(); // POI specific
			data = formatter.formatCellValue(cell); // returns the formatted vale of a cell as a string regardless of
													// the cell type
		} catch (Exception e) {
			data = ""; // if there is no value in a cell, then data is empty
		}
		workBook.close();
		fileIn.close();
		return data;
	}

	public static void setCellData(String xlFile, String xlSheet, int rowNum, int cellNum, String data)
			throws IOException {
		// to read and write to the file (Since we might have to update the execution
		// result on the file itself as 'done' or 'completed' etc)

		fileIn = new FileInputStream(xlFile);
		workBook = new XSSFWorkbook(fileIn);
		sheet = workBook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);

		fileOut = new FileOutputStream(xlFile);
		workBook.write(fileOut);
		workBook.close();
		fileIn.close();
		fileOut.close();
	}

	public static void fillGreenColor(String xlFile, String xlSheet, int rowNum, int cellNum) throws IOException {
		fileIn = new FileInputStream(xlFile);
		workBook = new XSSFWorkbook(fileIn);
		sheet = workBook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);

		style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		fileOut = new FileOutputStream(xlFile);
		workBook.write(fileOut);
		workBook.close();
		fileIn.close();
		fileOut.close();
	}

	public static void fillRedColor(String xlFile, String xlSheet, int rowNum, int cellNum) throws IOException {
		fileIn = new FileInputStream(xlFile);
		workBook = new XSSFWorkbook(fileIn);
		sheet = workBook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);

		style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		fileOut = new FileOutputStream(xlFile);
		workBook.write(fileOut);
		workBook.close();
		fileIn.close();
		fileOut.close();
	}

}

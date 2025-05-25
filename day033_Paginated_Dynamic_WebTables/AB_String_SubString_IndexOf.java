package day033_Paginated_Dynamic_WebTables;

import java.util.Scanner;

public class AB_String_SubString_IndexOf {

	public static void main(String[] args) {
		// subtask
		// exercise to split a string to just page numbers from the webpage
		// Note - enter the string via console
		// Write the string function to dynamically get the pages
		// example - Showing 1 to 10 of 22786 (2279 Pages)
		// extract 2279 as integer

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string to find the page numbers");
		String text = sc.nextLine();
		// Showing 1 to 10 of 22786 (2279 Pages)
		int startingIndex = text.indexOf("(");
		int endingIndex = text.indexOf("Pages");
		String pagesOnly = text.substring(startingIndex + 1, endingIndex - 1);
		// Note -> + 1 and - 1 are for substring methods(to equate properly)
		int pagesNumber = Integer.parseInt(pagesOnly);
		System.out.println(pagesNumber); // 2279
		sc.close();
	}

}

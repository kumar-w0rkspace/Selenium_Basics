package day043_a_Annotations_Before_After;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Test case
 * Login > search > Advanced search > Logout
 */
// This scenario we need to execute login and logout ONLY ONCE and execute the search and adv search 
public class AB_Class {
	@BeforeClass
	void login() {
		System.out.println("Logged in");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("Normal search");
	}

	@Test(priority = 2)
	void advancedSearch() {
		System.out.println("Advanced search");
	}

// AfterClass is not mandatory, but it depends on the test requirement
	@AfterClass
	void logout() {
		System.out.println("Logged out");
	}
}

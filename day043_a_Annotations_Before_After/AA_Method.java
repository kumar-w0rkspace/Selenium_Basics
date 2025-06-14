package day043_a_Annotations_Before_After;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Test case
 * Login > search > Logout
 * Login > Advanced search > Logout
 */
// This scenario we need to execute the login and logout EACH TIME before test method
public class AA_Method {
	@BeforeMethod
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

// AfterMethod is not mandatory, but it depends on the test requirement
	@AfterMethod
	void logout() {
		System.out.println("Logged out");
	}
}

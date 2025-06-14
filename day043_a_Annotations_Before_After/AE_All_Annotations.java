package day043_a_Annotations_Before_After;

import org.testng.annotations.*;

public class AE_All_Annotations {
	@BeforeSuite
	void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	void afterSuite() {
		System.out.println("After Suite");
	}

	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	void afterTest() {
		System.out.println("After Test");
	}

	@BeforeClass
	void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	void afterClass() {
		System.out.println("After Class");
	}

	@BeforeMethod
	void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	void afterMethod() {
		System.out.println("After Method");
	}

	@Test(priority = 1)
	void testOne() {
		System.out.println("Test One");
	}

	@Test(priority = 2)
	void testTwo() {
		System.out.println("Test Two");
	}
	
	// Output
	
	 /*	Before Suite 
		Before Test
		Before Class
		Before Method
		Test One
		After Method
		Before Method
		Test Two
		After Method
		After Class
		After Test
		After Suite
	 */

}

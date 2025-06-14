package day043_a_Annotations_Before_After.Suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AD_Suite_TC3 {
	@Test
	void caseTwo() {
		System.out.println("This is test method from TC3");
	}

	@BeforeSuite
	void beforeSuite() {
		System.out.println("This is before suite method");
	}

	@AfterSuite
	void afterSuite() {
		System.out.println("This is after suite method");
	}
}

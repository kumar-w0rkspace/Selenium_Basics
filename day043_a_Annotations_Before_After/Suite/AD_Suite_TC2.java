package day043_a_Annotations_Before_After.Suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AD_Suite_TC2 {
	@Test
	void caseTwo() {
		System.out.println("This is test method from TC2");
	}

	@AfterTest
	void afterTest() {
		System.out.println("This is after Test");
	}
}

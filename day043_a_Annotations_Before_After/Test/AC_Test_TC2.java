package day043_a_Annotations_Before_After.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AC_Test_TC2 {
	@Test
	void caseTwo() {
		System.out.println("This is test method from TC2 ");
	}

	@AfterTest
	void beforeTest() {
		System.out.println("This is after test");
	}
}

package day043_a_Annotations_Before_After.Suite;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AD_Suite_TC1 {
	@Test
	void caseOne() {
		System.out.println("This is test method from TC1 ");
	}

	@BeforeTest
	void beforeTest() {
		System.out.println("This is before Test");
	}
}

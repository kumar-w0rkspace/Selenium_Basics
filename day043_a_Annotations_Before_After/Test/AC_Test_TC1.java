package day043_a_Annotations_Before_After.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AC_Test_TC1 {

	@Test
	void caseOne() {
		System.out.println("This is test method from TC1 ");
	}

	@BeforeTest
	void beforeTest() {
		System.out.println("This is before test");
	}
}

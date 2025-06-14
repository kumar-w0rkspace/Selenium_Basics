package day043_b_Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AC_Soft_Assertion {

	SoftAssert sa;

	@Test
	void test1() {
		sa = new SoftAssert();
		System.out.println("Testing..");
		sa.assertEquals("ExpectedTitle", "ActualTitle"); // intentional
		System.out.println("Testing again...");
		sa.assertAll();
	}
/*
 * 	output-- 
 * 	Testing..
 *	Testing again...
 *	FAILED: test1
 */
}


package day043_b_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AD_Hard_Vs_Soft {
	@Test
	void test_HardAssertion() {
		System.out.println("Testing..");
		Assert.assertEquals(1, 2);
		System.out.println("Testing again");
	}
	/*
	 * Note - normally when we write testcases, assertions comes at the very end of
	 * the script since hard assertions dont execute anything below the assert
	 * point. Every test case, the last step is validation. we use hard assertion in
	 * script at last too
	 */

	@Test
	void test_SoftAssertion() {
		System.out.println("Testing..");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);
		System.out.println("Testing again");
		sa.assertAll(); // mandatory to reflect the failed tests
	}
	/*
	 * Note - We use soft assertion if we need to execute scripts even if the
	 * assertion is failed. But to use soft assertion we need to create object of it
	 * and use it through the reference. Every methods in hard assertion are
	 * available for soft assertion too.
	 * MANDATORY - use assertAll() to return the failure properly or else it will return pass
	 */
}

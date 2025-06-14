package day043_b_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AB_Hard_Assertion {
	@Test
	void test1() {

// compare any two values
		Assert.assertEquals("abc", "abc");
	}

	@Test
	void test2() {
		Assert.assertEquals("abc", "xyz");
	}

	@Test
	void test3() {
		Assert.assertEquals(20, 20);
	}

	@Test
	void test4() {
		Assert.assertEquals(123, "123");
	}

	@Test
	void test5() {
		Assert.assertNotEquals("123", "123"); // expecting not equals (will fail if its same)
	}

	@Test
	void test6() {
		Assert.assertNotEquals(123, 456); // pass
	}

	@Test
	void test7() {
		Assert.assertTrue(true);
	}

	@Test
	void test8() {
		Assert.assertTrue(1 == 2); // fail
	}

	@Test
	void test9() {
		Assert.assertFalse(1 == 2); // pass
	}

	@Test
	void test10() {
		Assert.fail(); // if we want to directly fail the test
	}

}

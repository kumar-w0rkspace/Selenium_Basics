package day043_b_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AA_Basics {
	@Test
	void testTitle() {
		String expectedTitle = "OrangeHRM";
		String capturedTitle = "Orange HRM";
		/*
		 * if (expectedTitle.equals(capturedTitle)) { System.out.println("Test pass"); }
		 * else { System.out.println("Test Failed"); }
		 */
		Assert.assertEquals(expectedTitle, capturedTitle);

// another method using logic and assertions
		
		if (expectedTitle.equals(capturedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}

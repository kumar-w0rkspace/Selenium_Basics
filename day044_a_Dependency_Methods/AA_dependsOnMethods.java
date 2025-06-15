package day044_a_Dependency_Methods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AA_dependsOnMethods {
	@Test(priority = 1)
	void openApp() {
		System.out.println("Opening app");
		Assert.assertTrue(true); // forcefully asserting the testcase to true or false
	}

	@Test(priority = 2, dependsOnMethods = { "openApp" })
	void login() {
		System.out.println("Logging in");
		Assert.assertTrue(true); // forcefully asserting the testcase to true or false

	}

	@Test(priority = 3, dependsOnMethods = { "login" })
	void search() {
		System.out.println("Simple search");
		Assert.assertTrue(false);
	}

	@Test(priority = 4, dependsOnMethods = { "login", "search" }) // multiple parameter
	void advSearch() {
		System.out.println("Advanced Search");
		Assert.assertTrue(true);
	}

	@Test(priority = 5, dependsOnMethods = { "login" })
	void logout() {
		System.out.println("Logging out");
		Assert.assertTrue(true);
	}
}

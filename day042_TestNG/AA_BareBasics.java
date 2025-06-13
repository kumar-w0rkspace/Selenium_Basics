package day042_TestNG;
/*
 * 1. open app
 * 2. login
 * 3. logout
 */

import org.testng.annotations.Test;

public class AA_BareBasics {

	@Test(priority = -15)
	void login() {
		System.out.println("Logging in to app");
	}

	@Test(priority = -20)
	void openApp() {
		System.out.println("Opening app");
	}

	@Test(priority = -10)
	void logout() {
		System.out.println("Logging out from the app");
	}

}

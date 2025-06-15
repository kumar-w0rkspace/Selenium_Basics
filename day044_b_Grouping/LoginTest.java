package day044_b_Grouping;

import org.testng.annotations.Test;

public class LoginTest {
// ALL SANITY
	@Test(priority = 1, groups = { "sanity" }) // group name can be anything
	void loginByEmail() {
		System.out.println("Logging in by Email");
	}

	@Test(priority = 2, groups = { "sanity" })
	void loginByFacebook() {
		System.out.println("Logging in by FaceBook");
	}

	@Test(priority = 3, groups = { "sanity" })
	void loginByTwitter() {
		System.out.println("Logging in by Twitter");
	}

}

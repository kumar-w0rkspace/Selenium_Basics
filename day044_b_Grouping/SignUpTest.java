package day044_b_Grouping;

import org.testng.annotations.Test;

public class SignUpTest {
// ALL REGRESSION
	@Test(priority = 1, groups = { "regression" })
	void signupByEmail() {
		System.out.println("Sign up by Email");
	}

	@Test(priority = 2, groups = { "regression" })
	void signupByFacebook() {
		System.out.println("Sign up by FaceBook");
	}

	@Test(priority = 3, groups = { "regression" })
	void signupByTwitter() {
		System.out.println("Sign by Twitter");
	}
}

package day044_b_Grouping;

import org.testng.annotations.Test;

public class PaymentTest {
// FUNCTIONAL (Sanity and regression)
	@Test(priority = 1, groups = { "sanity", "regression", "functional" })
	void paymentinRupees() {
		System.out.println("Payment in Rupees");
	}

	@Test(priority = 2, groups = { "sanity", "regression", "functional" })
	void paymentinDollars() {
		System.out.println("Payment in Dollars");
	}
}

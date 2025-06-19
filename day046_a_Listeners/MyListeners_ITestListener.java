package day046_a_Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners_ITestListener implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("onStart - only once before starting the whole tests");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart - before every test methods");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess - only when test methods pass");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure - only when test methods fail");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped - only when tests methods are skipped");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish - once all test methods are finished");
	}
}

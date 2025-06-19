package day046_b_ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

// Listener class
public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating testcase entries in the report and update status of the testmethods

	@Override // initializing template
	public void onStart(ITestContext context) {

		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/src/test/java/day046_b_ExtentReport/reports/myReport.html");
		// setting path and hardcoding report name (hardcoding name is not recommended.)

		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK); // theme

		extent = new ExtentReports(); // object creation
		extent.attachReporter(sparkReporter); // attatching spark report to extent

		extent.setSystemInfo("Computer Name", "localhost"); // hardcoded (will be dynamic in framework)
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("Tester Name", "John Doe");
		extent.setSystemInfo("os", "Windows11");
		extent.setSystemInfo("Browser name", "Firefox");

	}

	// parameters for update status pass/ failed/ skipped

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in report
		test.log(Status.PASS, "Test case PASSED is: " + result.getName()); // update status pass/ failed/ skipped

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is: " + result.getThrowable()); // passing the exception name
		// screenshot generation is also needed
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "The case SKIPPED is: " + result.getName());
		// test.log(Status.SKIP, "The case SKIPPED due to methods: " +
		// result.getSkipCausedBy());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush(); // write the reports to the html file
		// testcase id generation for framework (since 100's of testcases in groups we
		// need to sort them as so)
		// emailing report automatically
	}

}

package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	private static ExtentReports reports;
	private static ExtentTest tests;

	@Override
	public void onStart(ITestContext context) {
		reports = new ExtentReports();
		String path = System.getProperty("user.dir") + "//reports//" + context.getSuite().getName()
				+ System.currentTimeMillis() + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reports.attachReporter(reporter);

	}

	@Override
	public void onTestStart(ITestResult result) {
		tests = reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		tests.log(Status.PASS, result.getMethod().getMethodName());

		tests.addScreenCaptureFromPath(ScreenshotUtils.capture(result.getMethod().getMethodName()));

	}

	@Override
	public void onTestFailure(ITestResult result) {

		tests.log(Status.FAIL, result.getMethod().getMethodName());

		tests.addScreenCaptureFromPath(ScreenshotUtils.capture(result.getMethod().getMethodName()));

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		tests.log(Status.SKIP, result.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {

		reports.flush();
	}

}

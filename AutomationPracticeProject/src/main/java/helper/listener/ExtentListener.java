package helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import helper.logger.LoggerHelper;

public class ExtentListener implements ITestListener {

	private Logger log = LoggerHelper.getLogger(ExtentListener.class);
	public static ExtentReports extent;
	public static ExtentTest test;

	public void onFinish(ITestContext arg0) {

		Reporter.log(arg0.getName() + " this test finished");
		log.info(arg0.getName() + " this test finished");
	}

	public void onStart(ITestContext arg0) {

		Reporter.log(arg0.getCurrentXmlTest().getName() + " this test started");
		log.info(arg0.getCurrentXmlTest().getName() + " this test started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {

		Reporter.log(arg0.getMethod().getMethodName() + " this test failed " + arg0.getThrowable());
		log.error(arg0.getMethod().getMethodName() + " this test failed " + arg0.getThrowable());
	}

	public void onTestSkipped(ITestResult arg0) {

		Reporter.log(arg0.getMethod().getMethodName() + " this test skipped " + arg0.getThrowable());
		log.warn(arg0.getMethod().getMethodName() + " this test skipped " + arg0.getThrowable());
	}

	public void onTestStart(ITestResult arg0) {

		Reporter.log(arg0.getMethod().getMethodName() + " this test started");
		log.info(arg0.getMethod().getMethodName() + " this test started");
	}

	public void onTestSuccess(ITestResult arg0) {

		Reporter.log(arg0.getMethod().getMethodName() + " this test passed");
		log.info(arg0.getMethod().getMethodName() + " this test passed");

	}

}

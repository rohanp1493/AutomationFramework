package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.BaseTest;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListerner implements ITestListener{
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public void onTestStart(ITestResult result) {
	    logger.info(result.getMethod().getMethodName());
	    logger.info(result.getMethod().getDescription());
	    logger.info(Arrays.toString(result.getMethod().getGroups()));
	    ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	  }
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName());
	  }
	
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName());
		ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		Object testclass = result.getInstance();
		
		BrowserUtility browserUtility = ((BaseTest)testclass).getInstance();
		String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	  }
	
	public void onTestSkipped(ITestResult result) {
	    logger.warn(result.getMethod().getMethodName() + " SKIPPED");
	    ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName());
	  }
	
	public void onStart(ITestContext context) {
		ExtentReportUtility.setUpSparkReporter("report.html");
	    logger.info("Test Suite Started");
	  }
	
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Ended");
		ExtentReportUtility.flushReport();
	  }
}

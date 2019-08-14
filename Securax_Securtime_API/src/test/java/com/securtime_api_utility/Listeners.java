package com.securtime_api_utility;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onStart(ITestContext testcontext){
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/report.html");
		htmlreporter.config().setDocumentTitle("Api Automation Report");
		htmlreporter.config().setReportName("Sax API Testing Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("ProjectName", "Securtime API");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Soumya");
		
	}
	
public void onTestSuccess(ITestResult testresult){
		test= extent.createTest(testresult.getName());
		test.log(Status.PASS, "TestCase Passed is: " +testresult.getName());
	}

public void onTestFailure(ITestResult testresult){
	test= extent.createTest(testresult.getName());
	test.log(Status.FAIL, "TestCase Failed is: " +testresult.getName());
	test.log(Status.FAIL, "TestCase Failed is: " +testresult.getThrowable());
}


public void onTestSkipped(ITestResult testresult){
	test= extent.createTest(testresult.getName());
	test.log(Status.SKIP, "TestCase Skipped is: " +testresult.getName());
}

public void onFinish(ITestContext testcontext){
	extent.flush();
}

}

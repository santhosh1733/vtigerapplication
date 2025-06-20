package com.comcast.crm.generic.listenerutility;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
/**
 * listener implementation class contains override ITestListener ,ISuiteListener methods 
 */
public class ListenerImplimatation  implements ITestListener ,ISuiteListener{
	public ExtentReports report;
	public static ExtentTest test ;
	/**
	 * Invoke each time before the suite will be invoked
	 * Containing about the suite execution
	 * filling with extent reporting steps 
	 */
	@Override
	public void onStart(ISuite suite) {
		/*
		 * getting local time and date 
		 */
		String timedate = LocalDateTime.now().toString().replace(":","-");
		/*
		 * creating instance for ExtentSparkReporter and pass the path of report store location along
		 * with date and time for create report name 
		 */
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advencereport/report--"+timedate+".html");
		/*
		 * providing document name, passing to set document method
		 */
		spark.config().setDocumentTitle("crm test suit");
		/*
		 * passing the report name through set report name method
		 */
		spark.config().setReportName("crm report");
		/*
		 * selecting the theme of the report
		 */
		spark.config().setTheme(Theme.DARK);
		/*
		 * create instance for ExtentReports 
		 */
		report=new ExtentReports();
		/*
		 * passing ExtentSparkReporter instance variable through attach report method
		 */
		report.attachReporter(spark);
		report.setSystemInfo("os", "window-11");


	}

	/**
	 * Invoke each time after suite will be succeed 
	 * filling with extent report save steps
	 */

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	/**
	 * Invoke each time before test start will be invoked 
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onTestStart(ITestResult result) {
		/*
		 * creating the test name along with method name and current date and time
		 */
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===>test get start===>");
	}
	/**
	 * Invoke each time test get succeed
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getMethod().getMethodName()+"===>test get complited===>");
	}
	/**
	 * Invoke each time test will get failure 
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		String testname = result.getMethod().getMethodName();
		String timedate = LocalDateTime.now().toString().replace(":","-");
		/*
		 * type casting driver to take screen shot
		 */
		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();		/*
		 * taking screen shot,out put type is BASE64(to pass the screen shot into html file)
		 */
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,"Errorfile");
		
        //test.log(Status.FAIL, result.getThrowable().getMessage());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===>test get fail===>");
	}
	/**
	 * Invoke each time test get skipped will be invoked 
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	/**
	 * Invoke each time Test Failed But With in Success Percentage will be invoked 
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	/**
	 * Invoke each time on Test Failed With Timeout will be invoked 
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}
	/**
	 * Invoke each time before test will be invoked 
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	/**
	 * Invoke each time after test will be invoked 
	 * Result variable containing information about the run test  
	 */
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}



}

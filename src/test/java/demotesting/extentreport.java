package demotesting;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentreport {
	public ExtentReports report;
	public ExtentTest test;
	@BeforeSuite
public void democonfigBS() {
         //spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advencereport/report.html");
		spark.config().setDocumentTitle("crm test suit");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);
		
		//add env info
		  report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window-11");
		
}
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	@Test
	public void createcontact() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		
		
		 test = report.createTest("create contact");
		 test.log(Status.INFO, "loginapp");
		 if("HDFC".equals("HFDC")) {
				test.log(Status.PASS, "contact is created ");
			}else {
				test.addScreenCaptureFromBase64String(path,"errorfile");
			}
	}
}

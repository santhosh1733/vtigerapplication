package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class perpulle {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.purplle.com/");
		driver.findElement(By.xpath("//input[@type='search']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("vitamin c serum",Keys.ENTER);
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Testdata/screenshot.png");
		FileUtils.copyFile(src, dst);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sort By ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Low Price")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'100% Natural Pineapple')]/../../../..//a[contains(text(),'Add to Cart')]")).click();
		
	}

	
}

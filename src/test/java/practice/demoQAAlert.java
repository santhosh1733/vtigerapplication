package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoQAAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.xpath("//span[contains(text(),'prompt box will appear')]/../..//button")).click();
		Alert ele = driver.switchTo().alert();
		Thread.sleep(2000);
          ele.sendKeys("aaaaaa");
         // ele.accept();
	}

}

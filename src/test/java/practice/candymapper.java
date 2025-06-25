package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class candymapper {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://candymapper.com/");
		driver.findElement(By.xpath("(//a[text()='FIND MY CANDY!'])[4]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1300)");
		//WebElement ele = driver.findElement(By.id("iframe-undefined2"));
		driver.switchTo().frame(1);
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='tCounty']"));
		Thread.sleep(2000);
		//dropdown.click();
		Select s=new Select(dropdown);
		Thread.sleep(2000);
		s.selectByVisibleText("Bristol");

	}

}

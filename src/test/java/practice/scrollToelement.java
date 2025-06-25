package practice;

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class scrollToelement {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://demoqa.com/browser-windows");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 500)");
	String parentwindow = driver.getWindowHandle();
	driver.findElement(By.id("messageWindowButton")).click();
	Set<String> allwindow = driver.getWindowHandles();
	 allwindow.remove(parentwindow);
	 String newwindow = allwindow.iterator().next();
	WebDriver ele = driver.switchTo().window(newwindow);
	System.out.println(driver.findElement(By.tagName("body")).getText());
	/*for(String e:allwindow) {
		if(!e.equals(parentwindow)) {
			driver.switchTo().window(e);
			System.out.println(driver.findElement(By.tagName("body")).getText());
		}
	}*/
	driver.quit();
}
}
////*[local-name()='svg']//*[local-name()='polygon']
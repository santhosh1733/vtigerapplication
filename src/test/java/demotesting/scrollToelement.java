package demotesting;

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
	Thread.sleep(2000);
	Set<String> allwindow = driver.getWindowHandles();
	System.out.println(	allwindow.size());
	for(String s:allwindow) {
		driver.switchTo().window(s);
		String title = driver.getCurrentUrl();
		
		System.out.println(title);
		//System.out.println(driver.findElement(By.cssSelector("body")).getText());
	}

}
}

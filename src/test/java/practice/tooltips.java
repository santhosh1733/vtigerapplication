package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tooltips {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/tool-tips");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		WebElement ele = driver.findElement(By.id("toolTipButton"));
		Actions move = new Actions(driver);
		move.moveToElement(ele).perform();
		Thread.sleep(2000);
		String text = driver.findElement(By.className("tooltip-inner")).getText();
		System.out.println(text);
	}

}

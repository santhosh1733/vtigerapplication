package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class modeldialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/modal-dialogs");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");
	    driver.findElement(By.id("showSmallModal")).click();
		String text = driver.findElement(By.className("modal-body")).getText();
		System.out.println(text);
		driver.findElement(By.id("closeSmallModal")).click();
		driver.close();
	}

}

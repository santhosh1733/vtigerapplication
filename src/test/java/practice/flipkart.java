package practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 2000)");
		String flipkart = driver.getWindowHandle();
		driver.findElement(By.linkText("Cleartrip")).click();
		Set<String> allwindow = driver.getWindowHandles();
		for(String e:allwindow) {
			if(!e.equals(flipkart)) {
				driver.switchTo().window(e);
				driver.findElement(By.xpath("//*[name()='svg' and @data-testid ]")).click();
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				driver.findElement(By.xpath("//div[@class='closeit']")).click();
				js1.executeScript("window.scrollBy(0, 1000)");
				String homewindow = driver.getWindowHandle();
				driver.findElement(By.xpath("//h2[text()='Bangalore']")).click();
				Set<String> allwindow1 = driver.getWindowHandles();
				for(String a:allwindow1) {
					if( !a.equals(homewindow) && !a.equals(flipkart)) {
						driver.switchTo().window(a);
						System.out.println(driver.getCurrentUrl());
						driver.findElement(By.xpath("//p[text()='All filters']")).click();
					}
				}
			
			}
		}
		

	}

}

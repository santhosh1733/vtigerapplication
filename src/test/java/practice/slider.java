package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class slider {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("iphone 16 pro max");
		driver.findElement(By.className("_2iLD__")).click();
		WebElement slider = driver.findElement(By.className("PYKUdo"));
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider, 50, 0).perform();
	}

}

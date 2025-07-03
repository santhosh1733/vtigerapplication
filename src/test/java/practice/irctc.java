package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class irctc {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys("bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' KSR BENGALURU - SBC ']")).click();

	}

}
 
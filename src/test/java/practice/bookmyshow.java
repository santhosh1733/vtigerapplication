package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bookmyshow {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
		//driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='path'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
       // driver.findElement(By.xpath("//span[text()='Bengaluru']/..//div")).click();
	}

}

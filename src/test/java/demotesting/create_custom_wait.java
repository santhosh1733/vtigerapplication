package demotesting;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;


public class create_custom_wait {
 
	
	/*
	 * using fluent wait(java)
	 */
	public void fluentwaut() {
		WebDriver driver =new ChromeDriver();
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
		.pollingEvery(Duration.ofSeconds(10))
		.withTimeout(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
		
			
		}
		
	}

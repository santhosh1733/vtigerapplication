package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public WebDriver selectBrowser(String browser) {
		WebDriver driver=null;
		if(browser.contains("chrome"))
		{
			return driver=new ChromeDriver();
		}	
		else if(browser.contains("firefox")) {
			return driver=new FirefoxDriver();
		}else
		{
			return driver=new ChromeDriver();
		}
		
	}
	
	public Timeouts getImplicitWait() {
		return UtilityClassObject.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void getExpilicityWaitForDD( WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(UtilityClassObject.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public  void switchToWindow(String partiletitle) {
		Set<String> window = UtilityClassObject.getDriver().getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()) {
			String id = it.next();
			UtilityClassObject.getDriver().switchTo().window(id);
			
			@Nullable
			String acturl = UtilityClassObject.getDriver().getTitle();
			if(acturl.contains(partiletitle)) {
				break;
			}
		}
		 
	}
	
	public void switchToParentWindow(String windowid) {
		UtilityClassObject.getDriver().switchTo().window(windowid);
		
	}
	
	public void switchToFrame(int index) {
		 UtilityClassObject.getDriver().switchTo().frame(index);
	}
    
	public void switchToFrame(String name) {
		 UtilityClassObject.getDriver().switchTo().frame(name);
	}
	
	public void switchToFrame(WebElement element) {
		 UtilityClassObject.getDriver().switchTo().frame(element);
	}
	
	public void switchToFrame() {
		 UtilityClassObject.getDriver().switchTo().parentFrame();
	}
	
	public void selectDropDown(WebElement element, String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void selectDropDownUsingIndex(WebElement element,int i) {
		Select s=new Select(element);
		s.selectByIndex(i);
		
	}
	
	public void switchToAlertToAccept() {
		UtilityClassObject.getDriver().switchTo().alert().accept();
	}
	public void switchToAlertToDissmiss() {
		UtilityClassObject.getDriver().switchTo().alert().dismiss();
	}
}

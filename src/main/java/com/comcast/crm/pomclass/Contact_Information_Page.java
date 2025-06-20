package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_Information_Page {
	
	
	 @FindBy(className = "dvHeaderText")
	  private WebElement headerMassage;
	 @FindBy(xpath = "//td[text()='Contact Id']/following-sibling::td")
	  private WebElement contactID;
	 @FindBy(xpath = "//td[text()='Support Start Date']/following-sibling::td")
	  private WebElement startDate;
	 @FindBy(xpath = "//td[text()='Support End Date']/following-sibling::td")
	  private WebElement endDate;
	
	 public Contact_Information_Page(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	 
	 
	 public WebElement getHeadermassage() {
		return headerMassage;
	}


	public WebElement getContactid() {
		return contactID;
	}


	public WebElement getStartdate() {
		return startDate;
	}


	public WebElement getEnddate() {
		return endDate;
	}


	
	 
	
}

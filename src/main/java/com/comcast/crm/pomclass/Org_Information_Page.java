package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Org_Information_Page {
	@FindBy(className ="dvHeaderText")
	private WebElement headerMassage;
	@FindBy(xpath  ="//td[text()='Organization No']/following-sibling::td")
	private WebElement orgnizationNumber;
	@FindBy(xpath ="//td[text()='Created Time']/following-sibling::td")
	private WebElement createdDate;
	@FindBy(id ="mouseArea_Phone")
	private WebElement phoneNumber;
	@FindBy(id ="dtlview_Industry")
	private WebElement industryDropDown;
	@FindBy(id ="dtlview_Type")
	private WebElement typeDropDown;
	

	
	public Org_Information_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getPhonenumber() {
		return phoneNumber;
	}


	public WebElement getHeadermassage() {
		return headerMassage;
	}


	public WebElement getIndustrydropdown() {
		return industryDropDown;
	}


	public WebElement getTypedropdown() {
		return typeDropDown;
	}


	public WebElement orgnizationnumber() {
		return orgnizationNumber;
	}


	public WebElement getCreateddate() {
		return createdDate;
	}
	
	
}

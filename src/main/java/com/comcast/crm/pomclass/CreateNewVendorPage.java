package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	@FindBy(name = "vendorname")
	private WebElement vendorNameTextField;
	@FindBy(name = "button")
	private WebElement saveButton;
	@FindBy(id = "phone")
	private WebElement phoneTextField;
	
	
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getVendornametextfield() {
		return vendorNameTextField;
	}


	public WebElement getSavebutton() {
		return saveButton;
	}


	public WebElement getPhonetextfield() {
		return phoneTextField;
	}
	
	
}

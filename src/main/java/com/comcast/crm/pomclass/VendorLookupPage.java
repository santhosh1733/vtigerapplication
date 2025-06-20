package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorLookupPage {

	@FindBy(id  ="search_txt")
	private WebElement VendorNameTextField;
	@FindBy(name  ="search")
	private WebElement button;
	
	public VendorLookupPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorNametextfield() {
		return VendorNameTextField;
	}

	public WebElement getButton() {
		return button;
	}

	
	
}

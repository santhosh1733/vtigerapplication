package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class purchaseOrderPage
{
	@FindBy(css = "img[title='Create Purchase Order...']")
	private WebElement createNewOrg;

	public purchaseOrderPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateneworg() {
		return createNewOrg;
	}
	
	
}

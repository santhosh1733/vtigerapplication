package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class invoicePage {
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement newinvoice;

	public invoicePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getnewinvoicer() {
		return newinvoice;
	}
}

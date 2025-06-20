package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	@FindBy(css = "img[title='Create Product...']")
	private WebElement newProduct;

	public productPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchtextfield() {
		return searchTextField;
	}

	public WebElement getnewproduct() {
		return newProduct;
	}
}

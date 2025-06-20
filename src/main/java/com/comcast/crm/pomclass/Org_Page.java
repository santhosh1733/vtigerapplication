package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Org_Page {
   
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement createNewOrg;
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	@FindBy(id = "bas_searchfield")
	private WebElement searchDropDown;
	@FindBy(name = "submit")
	private WebElement searchButton;
	
	public Org_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateneworg() {
		return createNewOrg;
	}

	public WebElement getSearchtextfield() {
		return searchTextField;
	}

	public WebElement getSearchdropdown() {
		return searchDropDown;
	}

	public WebElement getSearchbutton() {
		return searchButton;
	}
}

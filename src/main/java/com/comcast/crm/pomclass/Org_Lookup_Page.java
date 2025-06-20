package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Org_Lookup_Page {
	@FindBy(id ="search_txt")
	private WebElement searchTextField;
	@FindBy(name ="search")
	private WebElement searchButton;
	@FindBy(xpath ="//a[@href='javascript:window.close();']")
	private WebElement orgName;
	
	public Org_Lookup_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchtextfield() {
		return searchTextField;
	}

	public WebElement getSearchbutton() {
		return searchButton;
	}

	public WebElement getOrgname() {
		return orgName;
	}
	
	
}

package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Create_Org_Page {

	@FindBy(name = "accountname")
	private WebElement ogrNameTextField;
	@FindBy(id ="phone")
	private WebElement phoneNumberTextField;
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	@FindBy(name = "button")
	private WebElement saveButton;
	

	public Create_Org_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

	public void createorg(String orgname) {

		ogrNameTextField.sendKeys(orgname);
		saveButton.click();
	}
	
	public void createorg(String orgname,String phone) {

		ogrNameTextField.sendKeys(orgname);
		phoneNumberTextField.sendKeys(phone);
		saveButton.click();
	}

	public void createorg(String orgname,String phone,String industry, String type) {

		ogrNameTextField.sendKeys(orgname);
		phoneNumberTextField.sendKeys(phone);
		WebDriverUtility wb=new WebDriverUtility();
		wb.selectDropDown(industryDropDown, industry);
		wb.selectDropDown(typeDropDown, type);
		saveButton.click();
	}

	public void createorg(String orgname,String phone,int industryindex, int typeindex) {

		ogrNameTextField.sendKeys(orgname);
		phoneNumberTextField.sendKeys(phone);
		WebDriverUtility wb=new WebDriverUtility();
		wb.selectDropDownUsingIndex(industryDropDown, industryindex);
		wb.selectDropDownUsingIndex(typeDropDown, typeindex);
		saveButton.click();
	}




	public WebElement getOgrnametextfield() {
		return ogrNameTextField;
	}




	public WebElement getPhonenumbertextfield() {
		return phoneNumberTextField;
	}




	public WebElement getIndustrydropdown() {
		return industryDropDown;
	}




	public WebElement getTypedropdown() {
		return typeDropDown;
	}




	public WebElement getSavebutton() {
		return saveButton;
	}
	



}

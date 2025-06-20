package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_New_Contact_Page {

	

	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	@FindBy(name = "support_start_date")
	private WebElement startDate;
	@FindBy(name = "support_end_date")
	private WebElement endDate;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgButton;
	@FindBy(name = "button")
	private WebElement saveButton;
	
	
	public Create_New_Contact_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createcontact(String lastname) {
		lastNameTextField.sendKeys(lastname);
		saveButton.click();
	}
  
	public void createcontactwithdate(String lastname,String sdate,String edate) {
		lastNameTextField.sendKeys(lastname);
		startDate.clear();
		startDate.sendKeys(sdate);
		endDate.clear();
		endDate.sendKeys(edate);
	
	}
	public WebElement getOrgbutton() {
		return orgButton;
	}

	public WebElement getSavebutton() {
		return saveButton;
	}
	
	
}

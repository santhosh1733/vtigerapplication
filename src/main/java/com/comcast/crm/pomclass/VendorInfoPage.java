package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	
	@FindBy(className ="lvtHeaderText")
	private WebElement headerMassage;
	@FindBy(xpath  ="//td[text()='Vendor Name']/../td[@id='mouseArea_Vendor Name']")
	private WebElement VendorNameTextField;
	@FindBy(xpath  ="(//td[@class='dvtCellInfo'])[2]")
	private WebElement vendorNoTextField;
	@FindBy(xpath  ="//td[text()='Phone']/../td[@id='mouseArea_Phone']")
	private WebElement phoneNumberTextField;
	


	public VendorInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}



	public WebElement getHeadermassage() {
		return headerMassage;
	}



	public WebElement getVendorNametextfield() {
		return VendorNameTextField;
	}



	public WebElement getVendornotextfield() {
		return vendorNoTextField;
	}



	public WebElement getPhonenumbertextfield() {
		return phoneNumberTextField;
	}

}

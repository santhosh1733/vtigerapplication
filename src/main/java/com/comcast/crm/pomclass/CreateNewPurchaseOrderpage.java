package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPurchaseOrderpage {
	@FindBy(name = "subject")
	private WebElement subjectTextField;
	@FindBy(name = "postatus")
	private WebElement statusDropDown;
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorName;
	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img")
	private WebElement contact;
	@FindBy(name = "bill_street")
	private WebElement billingAddressTextField;
	@FindBy(name = "ship_street")
	private WebElement shippingAddressTextField;
	@FindBy(xpath = "//input[@name='productName1']/following-sibling::img")
	private WebElement product;
	@FindBy(name = "button")
	private WebElement saveButton;
	
	
	public CreateNewPurchaseOrderpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getSubjecttextfield() {
		return subjectTextField;
	}


	public WebElement getStatusdropdown() {
		return statusDropDown;
	}


	public WebElement getVendorname() {
		return vendorName;
	}


	public WebElement getContact() {
		return contact;
	}


	public WebElement getBillingaddresstextfield() {
		return billingAddressTextField;
	}


	public WebElement getShippingaddresstextfield() {
		return shippingAddressTextField;
	}


	public WebElement getProduct() {
		return product;
	}


	public WebElement getSavebutton() {
		return saveButton;
	}

}

package com.comcast.crm.pomclass;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


public class CerateNewProductPage {
	
	@FindBy(name = "productname")
	private WebElement productNameTextField;
	@FindBy(name = "productcategory")
	private WebElement productCategoryDropDown;
	@FindBy(name = "sales_start_date")
	private WebElement salesStartDateTextField;
	@FindBy(name = "sales_end_date")
	private WebElement salesEndDateTextField;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButtion;
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorLookUpIcon;
	
	 public JavaUtility java=new JavaUtility();
	
	public CerateNewProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getProductnametextfield() {
		return productNameTextField;
	}


	public void getproductcategorydropdown() {
		WebDriverUtility wd=new WebDriverUtility();
		int category = java.createRandomNumberForCategory();
		wd.selectDropDownUsingIndex(productCategoryDropDown, category);
	}


	public void getSalesstartdatetextfield() {
		salesStartDateTextField.sendKeys(java.getDate().toString());
	}
	

	public void getSalesenddatetextfield() {
		salesEndDateTextField.sendKeys(java.getDatePuleDays().toString());
		
	}


	public WebElement getVendorlookup() {
		return vendorLookUpIcon;
	}


	public WebElement getSavebuttion() {
		return saveButtion;
	}



	
}

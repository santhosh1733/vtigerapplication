package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(className ="lvtHeaderText")
	private WebElement headerMassage;
	@FindBy(xpath  ="//td[text()='Product Name']/..//span[@id='dtlview_Product Name']")
	private WebElement productNameTextField;
	@FindBy(xpath  ="//td[text()='Product No']/following-sibling::td")
	private WebElement productNoTextField;
	@FindBy(xpath  ="//td[text()='Product Category']/..//span[@id='dtlview_Product Category']")
	private WebElement ProductCategoryDropDown;
	@FindBy(xpath  ="//td[text()='Sales Start Date']/../td[@id='mouseArea_Sales Start Date']")
	private WebElement startDateTextField;
	@FindBy(xpath  ="//td[text()='Sales End Date']/../td[@id='mouseArea_Sales End Date']")
	private WebElement endDateTextField;


	public ProductInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	public WebElement getHeadermassage() {
		return headerMassage;
	}


	public WebElement getProductnametextfield() {
		return productNameTextField;
	}


	public WebElement getProductnotextfield() {
		return productNoTextField;
	}


	public WebElement getProductCategorydropdown() {
		return ProductCategoryDropDown;
	}


	public WebElement getStartdatetextfield() {
		return startDateTextField;
	}


	public WebElement getEnddatetextfield() {
		return endDateTextField;
	}
	
	
	
}

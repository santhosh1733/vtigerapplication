package com.comcast.crm.pomclass;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    @FindBy(linkText = "Organizations")
    private WebElement organizationsLink;
    @FindBy(linkText = "Contacts")
    private WebElement contactsLink;
    @FindBy(linkText = "Opportunities")
    private WebElement opportunitiesLink;
    @FindBy(linkText = "Products")
    private WebElement productsLink;
    @FindBy(linkText = "Vendors")
    private WebElement VendorsLink;
    @FindBy(linkText = "More")
    private WebElement MoreLink;
    @FindBy(linkText = "Leads")
    private WebElement leadsLink;
    @FindBy(linkText = "Purchase Order")
    private WebElement PurchaseOrderLink;
    @FindBy(xpath="(//td[@valign='bottom'])[2]")
    private WebElement logoutButton;
    @FindBy(linkText = "Sign Out")
    private WebElement singoutButton;
    @FindBy(linkText = "Sales Order")
    private WebElement SalesOrderLink;
    @FindBy(linkText = "Quotes")
    private WebElement QuotesLink;
    @FindBy(linkText = "Invoice")
    private WebElement InvoiceLink;
    
  
    public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrganizationslink() {
		return organizationsLink;
	}

	public WebElement getContactslink() {
		return contactsLink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitiesLink;
	}

	public WebElement getProductslink() {
		return productsLink;
	}

	public WebElement getLeadslink() {
		return leadsLink;
	}

	 public WebElement getVendorslink() {
		return VendorsLink;
	}


	public void getMorelink(WebDriver driver) {
		Actions a=new Actions(driver);
		a.moveToElement(MoreLink).perform();
		
	}


	public WebElement getPurchaseOrderlink() {
		return PurchaseOrderLink;
	}


	public WebElement getLogoutbutton() {
		return logoutButton;
	}


	public WebElement getSingoutbutton() {
		return singoutButton;
	}


	public WebElement getSalesOrderlink() {
		return SalesOrderLink;
	}


	public WebElement getQuoteslink() {
		return QuotesLink;
	}


	public WebElement getInvoicelink() {
		return InvoiceLink;
	}


	public void getLogout(WebDriver driver) {
			Actions a=new Actions(driver);
			a.moveToElement(logoutButton).perform();
			singoutButton.click();
		}
    
    
}

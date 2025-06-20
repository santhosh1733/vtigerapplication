package com.comcast.crm.product;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.pomclass.CerateNewProductPage;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.ProductInfoPage;
import com.comcast.crm.pomclass.VendorLookupPage;
import com.comcast.crm.pomclass.productPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)

public class CreateProductTest extends Baseclass {
   @Test
	public  void createProduct() throws IOException, InterruptedException
	{
	
		//navigate to new contact page
		HomePage home=new HomePage(driver);
		home.getProductslink().click();
		
		productPage productpg=new productPage(driver);
		productpg.getnewproduct().click();
		
		CerateNewProductPage createproduct=new CerateNewProductPage(driver);
		String productname = excel.getDataFromExcelSheet("product", 1, 0)+java.createRandomNumber();
		createproduct.getProductnametextfield().sendKeys(productname);
		createproduct.getproductcategorydropdown();
		createproduct.getSalesstartdatetextfield();
		createproduct.getSalesenddatetextfield();
		String parentwindow = driver.getWindowHandle();
		createproduct.getVendorlookup().click();
		
		String partialtext = "Vendors&action";
		wd.switchToParentWindow(partialtext);
		VendorLookupPage vendorlookup=new VendorLookupPage(driver);
		int row = excel.getLastRow("vendorinfo");
		String vendorname = excel.getDataFromExcelSheet("vendorinfo", row, 0);
		vendorlookup.getVendorNametextfield().sendKeys(vendorname);
		vendorlookup.getButton().click();
		Thread.sleep(2000);
		driver.close();
		wd.switchToParentWindow(parentwindow);
	    Thread.sleep(2000);
		createproduct.getSavebuttion().click();
		
		Thread.sleep(2000);
		ProductInfoPage product=new ProductInfoPage(driver);
		String headermassage = product.getHeadermassage().getText();
		String productname1 = product.getProductnametextfield().getText();
		String sdate = product.getStartdatetextfield().getText();
		String edate = product.getEnddatetextfield().getText();
		String productcategory = product.getProductCategorydropdown().getText();
		String productno = product.getProductnotextfield().getText();
		
		int row1=excel.getLastRow("productinfo")+1;
		excel.setDataInToExcelSheet("productinfo", row1, 0, productname1);
		excel.setDataInToExcelSheet("productinfo", row1, 1, productno);
		excel.setDataInToExcelSheet("productinfo", row1, 2, productcategory);
		excel.setDataInToExcelSheet("productinfo", row1, 3, sdate);
		excel.setDataInToExcelSheet("productinfo", row1, 4, edate);
		
		
		
	}

}

package com.comcast.crm.product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.pomclass.CerateNewProductPage;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.VendorLookupPage;
import com.comcast.crm.pomclass.productPage;

public class CreatePurchaseOrderTest extends Baseclass{
public void purchaseorder() throws EncryptedDocumentException, IOException, InterruptedException {
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
}
}

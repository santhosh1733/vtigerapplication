package com.comcast.crm.product;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.pomclass.CreateNewVendorPage;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.VendorInfoPage;
import com.comcast.crm.pomclass.VendorPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)
public class Create_VendorTest  extends Baseclass {
@Test
	public  void createVendor() throws IOException {
		
		
		//navigate to new contact page
		HomePage home=new HomePage(driver);
		home.getMorelink(driver);
		home.getVendorslink().click();
		
		VendorPage vendor=new VendorPage(driver);
		vendor.getnewvendor().click();
		
		CreateNewVendorPage newvendor=new CreateNewVendorPage(driver);
		String vendarname=excel.getDataFromExcelSheet("vendor", 1, 0)+java.createRandomNumber();
		long phone = java.createRandomPhoneNumber();
		String phonenum = String.valueOf(phone);
		newvendor.getVendornametextfield().sendKeys(vendarname);
		newvendor.getPhonetextfield().sendKeys(phonenum);
		newvendor.getSavebutton().click();
		
		VendorInfoPage vendorinfo=new VendorInfoPage(driver);
		String headermassage = vendorinfo.getHeadermassage().getText();
		WebElement name = vendorinfo.getVendorNametextfield();
		String phonenumber = vendorinfo.getPhonenumbertextfield().getText();
		String vederno = vendorinfo.getVendornotextfield().getText();
		
		assertTrue(headermassage.equals(vendarname));
		
		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(phonenumber.equals(phonenum));
		sassert.assertAll();
		
		int row = excel.getLastRow("vendorinfo")+1;
		excel.setDataInToExcelSheet("vendorinfo", row, 0, vendarname);
		excel.setDataInToExcelSheet("vendorinfo", row, 1, phonenumber);
		excel.setDataInToExcelSheet("vendorinfo", row, 2, vederno);
		

	}

}

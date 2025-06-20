package com.comcast.crm.orgtest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.pomclass.Create_Org_Page;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.Org_Information_Page;
import com.comcast.crm.pomclass.Org_Page;
/**
 * create organization with industry and type 
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)
public class Create_Org_With_Type_And_IndustryTest extends Baseclass {
	/**
	 *create organization with industry and type  
	 * @return void 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(groups = "RegressionTest")
	public  void orgWithTypeAndIndustry() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		/*
		 * navigate to new organization page
		 */
		HomePage home=new HomePage(driver);
		home.getOrganizationslink().click();
		Org_Page org=new Org_Page(driver);
		org.getCreateneworg().click();
		
		/*
		 * get data from the excel sheet and enter into org name text field
		 */
		Create_Org_Page createorg=new Create_Org_Page(driver);
		int rn = java.createRandomNumber();
		String data = excel.getDataFromExcelSheet("ORG", 1, 2)+rn;
		
		/*
		 * generate phone number and enter into phone text field
		 */
		long phonenum = java.createRandomPhoneNumber();
	    String num = String.valueOf(phonenum);
	    
		int indusrtyran = java.createRandomNumberForIndustry();
		int typeran = java.createRandomNumberForType();
		createorg.createorg(data, num, indusrtyran, typeran);
		createorg.getIndustrydropdown();
		createorg.getTypedropdown();

		/*
		 * get the title and id from org page 
		 */
		Org_Information_Page infopage=new Org_Information_Page(driver);
		wd.getExpilicityWaitForDD(infopage.getHeadermassage());
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		Reporter.log(actualresult,true);
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		String industry = infopage.getIndustrydropdown().getText();
		String type = infopage.getTypedropdown().getText();
		
		/*
		 * verify the title and phone number
		 */
		boolean match = actualresult.contains(expectedresult);
		UtilityClassObject.getTest().log(match?Status.PASS:Status.FAIL, match?"organization name is same":"organization name is not same");
		assertTrue(match);
		SoftAssert sassert=new SoftAssert();
		boolean match1 = phone.contains(num);
		sassert.assertTrue(match1);
		sassert.assertAll();
		UtilityClassObject.getTest().log(match1?Status.PASS:Status.FAIL, match1?"phone number is same":"phone number is not same");

		
		/*
		 * write back to excel sheet
		 */
		int row = excel.getLastRow("create_ORG_with_typenadindustry")+1;
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 0, expectedresult);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 1, orgno);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 2, cdate);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 3, phone);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 4, industry);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 5, type);

		
		

	}

	}



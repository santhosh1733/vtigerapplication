package com.comcast.crm.orgtest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
 * create organization with phone number 
 * Extend to base class1
 * @groups smokeTest
 *  
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)
public class Create_Org_With_PhonenumberTest extends Baseclass {
/**
 * create organization with phone number
 * @return void
 * @throws IOException
 * @throws InterruptedException
 */
	@Test(groups = "smokeTest")
	public  void orgWithPhonenumber() throws IOException, InterruptedException {

		/*
		 * Navigate to new organization page
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
		createorg.createorg(data, num);
       UtilityClassObject.getTest().log(Status.INFO, "organization get created with phone number");
		
       Thread.sleep(2000);
		/*
		 * get the title and id from organization information  page 
		 */
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		
		/*
		 * verify the title and phone number
		 */
		boolean isMatch = actualresult.contains(expectedresult);
		UtilityClassObject.getTest().log(
				 isMatch ? Status.PASS : Status.FAIL,
						    isMatch ? "Organization name is same":"Organization name is not same");
		assertTrue(isMatch);
		
						            
			boolean isMatch1 = num.contains(phone);
			 SoftAssert sassert=new SoftAssert();			            
			 sassert. assertTrue(isMatch1);
			 UtilityClassObject.getTest().log(
					 isMatch1 ? Status.PASS : Status.FAIL,
							    isMatch1 ? "phone number  match" :"phone number miss match");
						

		/*
		 * write data back to excel sheet
		 */
		int row = excel.getLastRow("create_ORG_with_phonenumber")+1;
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 0, expectedresult);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 1, orgno);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 2, cdate);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 3, phone);


	}
}


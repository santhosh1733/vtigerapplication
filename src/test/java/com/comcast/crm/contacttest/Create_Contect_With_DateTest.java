package com.comcast.crm.contacttest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.pomclass.Contact_Information_Page;
import com.comcast.crm.pomclass.Contact_Page;
import com.comcast.crm.pomclass.Create_New_Contact_Page;
import com.comcast.crm.pomclass.HomePage;

@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)
public class Create_Contect_With_DateTest extends Baseclass
{

	@Test (groups = "smokeTest")
	public  void createContact() throws IOException, Exception {

		//navigate to new contact page
		HomePage home=new HomePage(driver);
		home.getContactslink().click();
		Contact_Page contact=new Contact_Page(driver);
		contact.getCreatenewcontactbutton().click();

		//get data from the excel sheet and enter into last name text field
		int rn = java.createRandomNumber();
		String exceldata = excel.getDataFromExcelSheet("create_contect", 1, 0);
		String data = exceldata+rn;
		String startdate = java.getDate().toString();
		String enddate = java.getDate().plusDays(30).toString();
		Create_New_Contact_Page creatcontact=new Create_New_Contact_Page(driver);
		creatcontact.createcontactwithdate(data, startdate, enddate);
		creatcontact.getSavebutton().click();

		Contact_Information_Page contactinfo=new Contact_Information_Page(driver);
		Thread.sleep(2000);
		String actualheader = contactinfo.getHeadermassage().getText();
		String contactid = contactinfo.getContactid().getText();
		Reporter.log(actualheader,true);
       
		assertTrue(actualheader.contains(data));

		String actualstartdate = contactinfo.getStartdate().getText();

		//verification of start date
		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(actualstartdate.contains(startdate));

		String actualenddate = contactinfo.getEnddate().getText();
		sassert.assertTrue(actualenddate.contains(enddate));
		sassert.assertAll();

		int row = excel.getLastRow("create_contect_with_date")+1;
		excel.setDataInToExcelSheet("create_contect_with_date", row, 0, data);
		excel.setDataInToExcelSheet("create_contect_with_date", row, 1, contactid);
		excel.setDataInToExcelSheet("create_contect_with_date", row, 2, startdate);
		excel.setDataInToExcelSheet("create_contect_with_date", row, 3, enddate);

		
	}

}

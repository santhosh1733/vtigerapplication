package com.comcast.crm.testng.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.pomclass.Contact_Information_Page;
import com.comcast.crm.pomclass.Contact_Page;
import com.comcast.crm.pomclass.Create_New_Contact_Page;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.Org_Lookup_Page;
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)
public class CreateContactTest extends  Baseclass{

	@Test (groups = {"smokeTest","RegressionTest"})
	public void createContactWithAllDetailsTest() throws IOException {

		//navigate to new contact page
		HomePage home=new HomePage(driver);
		home.getContactslink().click();
		Contact_Page contact=new Contact_Page(driver);
		contact.getCreatenewcontactbutton().click();

		//get data from the excel sheet and enter into org name text field
		int rn = java.createRandomNumber();
		String exceldata = excel.getDataFromExcelSheet("create_contect", 1, 0);
		String data = exceldata+rn;
		String startdate = java.getDate().toString();
		String enddate = java.getDate().plusDays(30).toString();
		Create_New_Contact_Page creatcontact=new Create_New_Contact_Page(driver);
		creatcontact.createcontactwithdate(data, startdate, enddate);
		creatcontact.getOrgbutton().click();

		String partialtext="Accounts&action";
		wd.switchToWindow(partialtext);
		int row1 = excel.getLastRow("create_ORG_with_typenadindustry");
		String orgname = excel.getDataFromExcelSheet("create_ORG_with_typenadindustry", row1, 0);

		Org_Lookup_Page lookup=new Org_Lookup_Page(driver);
		lookup.getSearchtextfield().sendKeys(orgname);
		lookup.getSearchbutton().click();
		lookup.getOrgname().click();

		String mainwind="Contacts&action";
		wd.switchToWindow(mainwind);
		creatcontact.getSavebutton().click();

		Contact_Information_Page contactinfo=new Contact_Information_Page(driver);
		String actualheader = contactinfo.getHeadermassage().getText();
		String contactid = contactinfo.getContactid().getText();
		Reporter.log(actualheader,true);
		assertTrue(actualheader.contains(data));

		String actualstartdate = contactinfo.getStartdate().getText();		
		//verification of start date
		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(actualstartdate.contains(startdate));	

		String actualenddate = contactinfo.getEnddate().getText();
		//verification of End date
		sassert.assertTrue(actualenddate.contains(enddate));
		sassert.assertAll();		

		int row = excel.getLastRow("create_contect_with_date")+1;
		excel.setDataInToExcelSheet("create_contect_with_date", row, 0, data);
		excel.setDataInToExcelSheet("create_contect_with_date", row, 1, contactid);
		excel.setDataInToExcelSheet("create_contect_with_date", row, 2, startdate);
		excel.setDataInToExcelSheet("create_contect_with_date", row, 3, enddate);

	}
}

package com.comcast.crm.testng.test;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.pomclass.Create_Org_Page;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.Org_Information_Page;
import com.comcast.crm.pomclass.Org_Page;
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)

public class create_organizationTest extends Baseclass {

	@Test (groups = {"smokeTest","RegressionTest"})
	public void creatorg() throws IOException, InterruptedException {

		HomePage home=new HomePage(driver);
		home.getOrganizationslink().click();
		Org_Page org=new Org_Page(driver);
		org.getCreateneworg().click();

		//get data from the excel sheet and enter into org name text field
		Create_Org_Page createorg=new Create_Org_Page(driver);
		int rn = java.createRandomNumber();
		String data = excel.getDataFromExcelSheet("ORG", 1, 2)+rn;
		createorg.createorg(data);

		Thread.sleep(2000);
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		Reporter.log(actualresult,true);
		SoftAssert sassert=new SoftAssert();
		boolean result = actualresult.contains(expectedresult);
		sassert.assertTrue(result);
		sassert.assertAll();

		//write back to excel sheet
		int row = excel.getLastRow("createORG")+1;
		excel.setDataInToExcelSheet("createORG", row, 0, expectedresult);
		excel.setDataInToExcelSheet("createORG", row, 1, orgno);
		excel.setDataInToExcelSheet("createORG", row, 2, cdate);
	}


	@Test(dependsOnMethods = "creatorg")
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage home=new HomePage(driver);
		home.getOrganizationslink().click();
		Org_Page org=new Org_Page(driver);
		org.getCreateneworg().click();

		//get data from the excel sheet and enter into org name text field
		Create_Org_Page createorg=new Create_Org_Page(driver);
		int rn = java.createRandomNumber();
		String data = excel.getDataFromExcelSheet("ORG", 1, 2)+rn;

		//generate phone number and enter into phone text field
		long phonenum = java.createRandomPhoneNumber();
		String num = String.valueOf(phonenum);
		createorg.createorg(data, num);

		Thread.sleep(2000);
		//get the title and id from org page 
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();

		//verify the title and phone number
		boolean result = actualresult.contains(expectedresult);
		assertTrue(result);

		SoftAssert sassert=new SoftAssert();
		boolean res = num.contains(phone);
		sassert.assertTrue(res);
		sassert.assertAll();

		//write back to excel sheet
		int row = excel.getLastRow("create_ORG_with_phonenumber")+1;
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 0, expectedresult);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 1, orgno);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 2, cdate);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 3, phone);

	}

	@Test(groups = "RegressionTest")
	public void createOrganizationWithIndustyryAndType() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage home=new HomePage(driver);
		home.getOrganizationslink().click();
		Org_Page org=new Org_Page(driver);
		org.getCreateneworg().click();

		//get data from the excel sheet and enter into org name text field
		Create_Org_Page createorg=new Create_Org_Page(driver);
		int rn = java.createRandomNumber();
		String data = excel.getDataFromExcelSheet("ORG", 1, 2)+rn;

		//generate phone number and enter into phone text field
		long phonenum = java.createRandomPhoneNumber();
		String num = String.valueOf(phonenum);

		int indusrtyran = java.createRandomNumberForIndustry();
		int typeran = java.createRandomNumberForType();
		createorg.createorg(data, num, indusrtyran, typeran);

		Thread.sleep(2000);
		//get the title and id from org page 
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		String industry = infopage.getIndustrydropdown().getText();
		String type = infopage.getTypedropdown().getText();
		
		//verify the title and phone number
		boolean result = actualresult.contains(expectedresult);
		assertTrue(result);
		SoftAssert sassert=new SoftAssert();
		boolean res = num.contains(phone);
		sassert.assertTrue(res);
		sassert.assertAll();

		//write back to excel sheet
		int row = excel.getLastRow("create_ORG_with_typenadindustry")+1;
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 0, expectedresult);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 1, orgno);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 2, cdate);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 3, phone);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 4, industry);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 5, type);

	}

	@Test(groups = "RegressionTest")
	public void createOrganizationAndDelete() throws InterruptedException, EncryptedDocumentException, IOException {

		HomePage home=new HomePage(driver);
		home.getOrganizationslink().click();
		Org_Page org=new Org_Page(driver);
		org.getCreateneworg().click();


		//get data from the excel sheet and enter into org name text field
		Create_Org_Page createorg=new Create_Org_Page(driver);
		int rn = java.createRandomNumber();
		String data = excel.getDataFromExcelSheet("ORG", 1, 2)+rn;
		createorg.createorg(data);

		Thread.sleep(2000);
		//get the title and id from org page 
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();


		//verify the org name is same 
		boolean result = actualresult.contains(expectedresult);
		assertTrue(result);

		//write back to excel sheet
		int row = excel.getLastRow("createORG")+1;
		excel.setDataInToExcelSheet("createORG", row, 0, expectedresult);
		excel.setDataInToExcelSheet("createORG", row, 1, orgno);
		excel.setDataInToExcelSheet("createORG", row, 2, cdate);

		home.getOrganizationslink().click();
		org.getSearchtextfield().sendKeys(data);
		wd.selectDropDown(org.getSearchdropdown(), "Organization Name");
		org.getSearchbutton().click();

		Thread.sleep(2000);
		//delete the org
		driver.findElement(By.xpath("//a[text()='"+data+"']/../../td[8]/a[text()='del']")).click();

		wd.switchToAlertToAccept();
      
	}

}

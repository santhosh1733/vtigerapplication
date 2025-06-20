package com.comcast.crm.orgtest;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
 * contain methods of create organization with phone number and type and industry
 * and delete the organization.
 * 
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)
public class Create_OrganizationTest extends Baseclass {
	/**
	 * create organization with name and verify the name
	 * @return void
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(groups = {"smokeTest","RegressionTest"},priority = 1)
	public void creatorg() throws IOException, InterruptedException {
		/*
		 * navigate to create new organization page
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
		createorg.createorg(data);
		UtilityClassObject.getTest().log(Status.INFO,"organization name get created");
		/*
		 * verify organization name inside organization information page 
		 */
		Thread.sleep(2000);
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		assertTrue(actualresult.contains(expectedresult));
		/*
		 * write data back to excel sheet
		 */
		int row = excel.getLastRow("createORG")+1;
		excel.setDataInToExcelSheet("createORG", row, 0, expectedresult);
		excel.setDataInToExcelSheet("createORG", row, 1, orgno);
		excel.setDataInToExcelSheet("createORG", row, 2, cdate);
	}

/**
 * create organization with phone number
 * @return void 
 * @throws EncryptedDocumentException
 * @throws IOException
 * @throws InterruptedException
 */
	@Test(priority = 2)
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException, InterruptedException {
		
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

		Thread.sleep(2000);
		/*
		 * get the title and id from org page 
		 */
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		Reporter.log(actualresult,true);

		/*
		 * verify the title and phone number
		 */
		assertTrue(actualresult.contains(expectedresult));

		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(phone.contains(num));
		sassert.assertAll();

		/*
		 * write back to excel sheet
		 */
		int row = excel.getLastRow("create_ORG_with_phonenumber")+1;
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 0, expectedresult);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 1, orgno);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 2, cdate);
		excel.setDataInToExcelSheet("create_ORG_with_phonenumber", row, 3, phone);

	}
/**
 * create organization with industry and type
 * @return void
 * @throws EncryptedDocumentException
 * @throws IOException
 * @throws InterruptedException
 */
	@Test(priority = 3)
	public void createOrganizationWithIndustyryAndType() throws EncryptedDocumentException, IOException, InterruptedException {

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
		System.out.println(indusrtyran);
		System.out.println(typeran);
		createorg.createorg(data, num, indusrtyran, typeran);

		Thread.sleep(2000);
		/*
		 * get the title and id from org page 
		 */
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		String industry = infopage.getIndustrydropdown().getText();
		String type = infopage.getTypedropdown().getText();
		Reporter.log(actualresult,true);

		/*
		 * verify the title and phone number
		 */
		assertTrue(actualresult.contains(expectedresult));
		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(phone.contains(num));
		sassert.assertAll();


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
/**
 * create organization and search and delete the organization 
 * @return void 
 * @throws InterruptedException
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	@Test(priority = 4)
	public void createOrganizationAndDelete() throws InterruptedException, EncryptedDocumentException, IOException {

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
		createorg.createorg(data);

		Thread.sleep(2000);
		/*
		 * get the title and id from org page 
		 */
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();


		/*
		 * verify the org name is same 
		 */
		assertTrue(actualresult.contains(expectedresult));

		/*
		 * write back to excel sheet
		 */
		int row = excel.getLastRow("createORG")+1;
		excel.setDataInToExcelSheet("createORG", row, 0, expectedresult);
		excel.setDataInToExcelSheet("createORG", row, 1, orgno);
		excel.setDataInToExcelSheet("createORG", row, 2, cdate);


		home.getOrganizationslink().click();
		org.getSearchtextfield().sendKeys(data);
		wd.selectDropDown(org.getSearchdropdown(), "Organization Name");
		org.getSearchbutton().click();
		Thread.sleep(2000);
		/*
		 * delete the org
		 */
		driver.findElement(By.xpath("//a[text()='"+data+"']/../../td[8]/a[text()='del']")).click();

		wd.switchToAlertToAccept();

	}

}

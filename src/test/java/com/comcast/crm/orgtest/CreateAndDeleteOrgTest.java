package com.comcast.crm.orgtest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.pomclass.Create_Org_Page;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.Org_Information_Page;
import com.comcast.crm.pomclass.Org_Page;

/**
 * create organization and search ,delete the organization
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)
public class CreateAndDeleteOrgTest extends Baseclass{
/**
 * delete the organization
 * @return void
 * @throws IOException
 * @throws InterruptedException
 */
	@Test(groups = "RegressionTest")
	public  void deletorg() throws IOException, InterruptedException {

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
		/*
		 * get the title and id from org page 
		 */
		Org_Information_Page infopage=new Org_Information_Page(driver);
		wd.getExpilicityWaitForDD(infopage.getHeadermassage());
		String actualresult = infopage.getHeadermassage().getText();
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();

		/*
		 * verify the org name is same 
		 */
		 
		 if(actualresult.contains(expectedresult)) {
			 assertTrue(actualresult.contains(expectedresult));
			 UtilityClassObject.getTest().log(Status.PASS, "oraganization name is same");
		 }else {
			 UtilityClassObject.getTest().log(Status.FAIL, "organization name is not same");
		 }
		 
		 
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
		/*
		 * delete the org
		 */
		 WebElement ele = driver.findElement(By.xpath("//a[text()='"+data+"']/../../td[8]/a[text()='del']"));
          wd.getExpilicityWaitForDD( ele);
          ele.click();
        

	}

}

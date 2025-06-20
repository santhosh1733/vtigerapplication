package com.comcast.crm.testng.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.fileutiity.ExecelSheetUtility;
import com.comcast.crm.generic.fileutiity.PropertyFileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.pomclass.Create_Org_Page;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.Org_Information_Page;
import com.comcast.crm.pomclass.Org_Page;
import com.comcast.crm.pomclass.loginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplimatation.class)

public class createOrganizationWithDependencyTest{
	WebDriver driver;
	PropertyFileUtility pf=new PropertyFileUtility();
	WebDriverUtility wd=new WebDriverUtility();
	loginPage loginpage1=new loginPage(driver);
	ExecelSheetUtility excel=new ExecelSheetUtility();
	JavaUtility java=new JavaUtility();
	HomePage home=new HomePage(driver);
	Org_Page org=new Org_Page(driver);
	Create_Org_Page createorg=new Create_Org_Page(driver);
	String data=null;
	String num = null;

	@Test
	public void login() throws IOException {
		//getting data from property file
		PropertyFileUtility pf=new PropertyFileUtility();
		String browser = pf.getdatafromthepropertyfile("browser");
		String url = pf.getdatafromthepropertyfile("url");
		String username1 = pf.getdatafromthepropertyfile("username");
		String password1 = pf.getdatafromthepropertyfile("password");

		//browser launching and login 
		driver = wd.selectBrowser(browser);
		driver.get(url);
		loginPage loginpage1=new loginPage(driver);
		loginpage1.login(username1,password1);


	}

	@Test(dependsOnMethods = "login")
	public void createOrg() throws EncryptedDocumentException, IOException {
		HomePage home=new HomePage(driver);
		home.getOrganizationslink().click();

		Org_Page org=new Org_Page(driver);
		org.getCreateneworg().click();

		JavaUtility java=new JavaUtility();
		int rn = java.createRandomNumber();

		ExecelSheetUtility excel=new ExecelSheetUtility();
		data = excel.getDataFromExcelSheet("ORG", 1, 2)+rn;

		Create_Org_Page createorg=new Create_Org_Page(driver);
		createorg.getOgrnametextfield().sendKeys(data);


	}
	@Test(dependsOnMethods = "createOrg")
	public void createPhonenumber() {
		JavaUtility java=new JavaUtility();
		long phonenum = java.createRandomPhoneNumber();
		num = String.valueOf(phonenum);

		Create_Org_Page createorg=new Create_Org_Page(driver);
		createorg.getPhonenumbertextfield().sendKeys(num);


	}
	@Test(dependsOnMethods = "createphonenumber")
	public void createTypeIndustry() throws EncryptedDocumentException, IOException {

		JavaUtility java=new JavaUtility();
		int indusrtyran = java.createRandomNumberForIndustry();
		int typeran = java.createRandomNumberForType();

		Create_Org_Page createorg=new Create_Org_Page(driver);
		WebDriverUtility wb=new WebDriverUtility();
		wb.selectDropDownUsingIndex(createorg.getIndustrydropdown(), indusrtyran);
		wb.selectDropDownUsingIndex(createorg.getTypedropdown(), typeran);

		createorg.getSavebutton().click();

	}


	@Test(dependsOnMethods = "createTypeIndustry")
	public void verification() throws IOException, InterruptedException {
		//get the title and id from org page 
		Thread.sleep(2000);
		Org_Information_Page infopage=new Org_Information_Page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		String industry = infopage.getIndustrydropdown().getText();
		String type = infopage.getTypedropdown().getText();

		//verify the title and phone number
		assertTrue(actualresult.contains(expectedresult));

		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(num.contains(phone));
		sassert.assertAll();

		ExecelSheetUtility excel=new ExecelSheetUtility();
		int row = excel.getLastRow("create_ORG_with_typenadindustry")+1;
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 0, expectedresult);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 1, orgno);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 2, cdate);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 3, phone);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 4, industry);
		excel.setDataInToExcelSheet("create_ORG_with_typenadindustry", row, 5, type);
	}


}

package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutiity.ExecelSheetUtility;
import com.comcast.crm.generic.fileutiity.PropertyFileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.pomclass.HomePage;
import com.comcast.crm.pomclass.loginPage;


/**
 * It is present in BaseTest Package, all methods are public.
 * Base class contains configuration annotations {@BeforeSuite,@Beforeclass, @Beforetest, @BeforeMethod
 * @Aftermethod,@AfterTest, @Afterclass, @AfterSuite}, this Class will Extends All the Test Script,
 * this class will take care of connecting Data Base, Lunching Browser, Login, Logout,Close Browser,Close DataBase.
 * 
 *  filling with all utility class instances 
 *  
 */
public class Baseclass {
	public WebDriver driver=null;
    public DataBaseUtility db=new DataBaseUtility();
    public PropertyFileUtility pf=new PropertyFileUtility();
    public WebDriverUtility wd=new WebDriverUtility();
    public ExecelSheetUtility excel=new ExecelSheetUtility();
    public JavaUtility java=new JavaUtility();
   
    /**
     * 
     * This method invoke each time before a suite will be invoked
     */
	//@BeforeSuite (groups = {"smokeTest","RegressionTest"})
	public void confiBS() throws SQLException {
		db.getConnection();
	}
	
	/**
	 * This method invoke each time before a class will be invoked class
	 */
	//@Parameters("browser")
	@BeforeClass (groups = {"smokeTest","RegressionTest"})
	public void configBC() throws IOException {
		/*
		 * select the browser based on condition 
		 */
		//String browser = pf.getdatafromthepropertyfile("browser");
		String browser = System.getProperty("browser");


		if(browser.contains("chrome"))
		{
			driver=new ChromeDriver();
		}	
		else if(browser.contains("firefox")) {
			 driver=new FirefoxDriver();
		}else if(browser.contains("edge"))
		{
			 driver=new EdgeDriver();
		}
		/*
		 * set the driver value into static driver variable 
		 */
		UtilityClassObject.setDriver(driver);
	}
	
	 /**
	  *This method invoke each time before a method will be invoked
	  */
	@BeforeMethod (groups = {"smokeTest","RegressionTest"})
	public void configBM() throws IOException {
		/*
		 * getting url,username,password from property file
		 */
		//String url = pf.getdatafromthepropertyfile("url");
		//String username1 = pf.getdatafromthepropertyfile("username");
		//String password1 = pf.getdatafromthepropertyfile("password");
		String url = System.getProperty("url");
		String username1 = System.getProperty("username");
		String password1 =System.getProperty("password");
		/*
		 * trigger the url 
		 */
		driver.get(url);
		/*
		 * creating instance for loginpage 
		 * pass data into login method
		 */
		loginPage loginpage=new loginPage(driver);
		loginpage.login(username1,password1);
	}
	/**
	 * This method invoke each time After a method will be succeed
	 * 
	 */
	@AfterMethod (groups = {"smokeTest","RegressionTest"})
	public void configAM() {
		/*
		 * creating instance for the homepage
		 * clicking the logout link
		 */
		 HomePage home=new HomePage(driver);
		 home.getLogout(driver);
		
	}
	
	/**
	 *  This method invoke each time After a class will be succeed
	 *
	 */
	
	@AfterClass (groups = {"smokeTest","RegressionTest"})
	public void configAC() {
		/*
		 * closing the browser
		 */
		driver.quit();
	}
	/**
	 *  This method invoke each time After a suite will be succeed
	 */
	
	//@AfterSuite (groups = {"smokeTest","RegressionTest"})
	public void configAS() {
		
	}
}

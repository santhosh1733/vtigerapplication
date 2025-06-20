package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	@FindBy(name ="user_name")
	private WebElement userNameTextField;
	@FindBy(name ="user_password")
	private WebElement passwordTextField;
	@FindBy(id ="submitButton")
	private WebElement loginButtion;
	
	public loginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
    
	public void login(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButtion.click();
	}
}

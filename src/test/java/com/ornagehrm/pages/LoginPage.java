package com.ornagehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.utils.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath=emailNamexpath)
	WebElement emailText;
	
	@FindBy(xpath=passwordxpath)
	WebElement passwordText;
	
	@FindBy(xpath=loginbuttonlxpath)
	WebElement loginbutton;
	
	public void doLogin(String userName,String passWord) {
		try {
			emailText.sendKeys(userName);
			passwordText.sendKeys(passWord);
			loginbutton.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

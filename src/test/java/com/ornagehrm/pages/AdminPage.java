package com.ornagehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.utils.BaseClass;

public class AdminPage extends BaseClass{

	@FindBy(xpath=adminLinkxpath)
	WebElement adminLink;
	
	@FindBy(xpath=addButtonxpath)
	WebElement addButton;
	
	@FindBy(xpath=employeeNameXpath)
	WebElement employeeNameText;
	
	@FindBy(xpath=listBoxXpath)
	WebElement listBoxDrop;
	
	@FindBy(xpath=userRoleXpath)
	WebElement userRoleDropdown;
	
	@FindBy(xpath=statusDropDownxpath)
	WebElement statusDropDown;
	
	@FindBy(xpath=userNameTextXpath)
	WebElement userNameText;
	
	@FindBy(xpath=adinpasswordxpath)
	WebElement adinpasswordtext;
	
	@FindBy(xpath=conpasswordxpath)
	WebElement conpassword;
	
	@FindBy(xpath=saveBtnxpath)
	WebElement saveBtn;
	
	public void prodieAdminRights(String employeeName,String role,String status,String passWord) {
		try {
			adminLink.click();
			addButton.click();
			userRoleDropdown.click();
			Thread.sleep(2000);
			selectDropDown(listBoxDrop,role);
			Thread.sleep(2000);
			statusDropDown.click();
			
			selectDropDown(listBoxDrop,status);
			employeeNameText.sendKeys(employeeName);
			userNameText.sendKeys(employeeName);
			adinpasswordtext.sendKeys(passWord);
			conpassword.sendKeys(passWord);
			saveBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

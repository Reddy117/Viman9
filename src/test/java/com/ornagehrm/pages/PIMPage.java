package com.ornagehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class PIMPage extends BaseClass{

	@FindBy(xpath=PimLinkxpath)
	WebElement pinLink;
	
	@FindBy(xpath=addButtonxpath)
	WebElement addButton;
	
	@FindBy(xpath=fNamexpath)
	WebElement fNameText;
	
	@FindBy(xpath=lNamexpath)
	WebElement lNameText;
	
	@FindBy(xpath=createLoginxpath)
	WebElement createLoginbutton;
	
	@FindBy(xpath=userNamexpath)
	WebElement userNameText;
	
	@FindBy(xpath=saveBtnxpath)
	WebElement saveBtn;
	
	@FindBy(xpath=employeepasswordxpath)
	WebElement employeepasswordText;
	
	@FindBy(xpath=employeeConpasswordxpath)
	WebElement employeeConpasswordText;
	
	@FindBy(xpath=listBoxXpath)
	WebElement listBox;
	
	@FindBy(xpath=nationalityDropDownxapth)
	WebElement nationalityDropDown;

	public void createEmployee(String firstName,String lastName,String userName,String password) {
		try {
			pinLink.click();
			addButton.click();
			fNameText.sendKeys(firstName);
			lNameText.sendKeys(lastName);
			createLoginbutton.click();
			userNameText.sendKeys(userName);
			employeepasswordText.sendKeys(password);
			employeeConpasswordText.sendKeys(password);
			saveBtn.click();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editEmployee(String nationality,String maritalStatus,String bloodType) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

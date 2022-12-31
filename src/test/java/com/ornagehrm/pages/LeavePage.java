package com.ornagehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.utils.BaseClass;

public class LeavePage extends BaseClass{

	@FindBy(xpath=leaveTypexpath)
	WebElement leaveType;
	
	@FindBy(xpath=fromDateDrop)
	WebElement fromDate;
	
	@FindBy(xpath=todateDrop)
	WebElement toDate;
	
	@FindBy(xpath=appluButtonxpath)
	WebElement appluButton;
	
	@FindBy(xpath=applyLinkXpath)
	WebElement applyLink;
	
	public void applyLeave() {
		try {
			applyLink.click();
			
		}catch(Exception e) {
			
		}
	}
}

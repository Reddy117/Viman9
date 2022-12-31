package com.orangehrm.utils;

import org.openqa.selenium.WebDriver;

import com.orangehrm.factory.BasePageFactory;

public class Page {

	public WebDriver driver;
	public WebdriverHelper webDriverHelper;
	BasePageFactory pageFactory;
	
	public Page() {
		if(driver==null) {
			this.driver=DriverManager.getWebDriver();
			webDriverHelper=new WebdriverHelper(driver);
			pageFactory=new BaseClass().getPageFacotry();
		}
	}
}

package com.orangehrm.tests;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.utils.BaseClass;
import com.ornagehrm.pages.AdminPage;
import com.ornagehrm.pages.LoginPage;

public class TC_Admin_002 extends BaseClass {

	@Test(dataProvider = "getTCData")
	public void provideAccessToEmployee(LinkedHashMap<String, String> map)
			throws InterruptedException, FileNotFoundException {
		lp.doLogin(getProperty("userName"), getProperty("password"));
		ap.prodieAdminRights(map.get("Employee Name"), map.get("User role"), map.get("Status"), map.get("Password"));
	}


	@DataProvider
	public Object[][] getTCData() {
		return getData("TC3_ProvideAccessToEmployee", "Sheet1");
	}
}

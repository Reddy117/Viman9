package com.orangehrm.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	public static ThreadLocal<WebDriver> driverForThread = new ThreadLocal<WebDriver>();
	
	public synchronized static WebDriver getWebDriver() {
		return driverForThread.get();
		
	}
	
	public synchronized static void setWebDriver(WebDriver driver) {
		driverForThread.set(driver);
	}
}

package com.orangehrm.utils;

import org.openqa.selenium.WebElement;


public class KeyBoard_MouseUtils extends BaseClass{

	public static void moveToElement(WebElement ele) {
		a.moveToElement(ele).perform();
	}
	
	public static void dragAndDrop(WebElement src,WebElement drop) {
		a.dragAndDrop(src, drop).perform();
	}
	
	public static void dblClick(WebElement src) {
		a.doubleClick(src).click();
	}
	
	
}

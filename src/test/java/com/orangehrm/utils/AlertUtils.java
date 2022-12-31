package com.orangehrm.utils;

import org.openqa.selenium.Alert;

public class AlertUtils extends BaseClass{

	Alert a;
	
	public void alertHandler(String option) {
		a=driver.switchTo().alert();
		if(option.equals("positive"))
			a.accept();
		else
			a.dismiss();
	}
}

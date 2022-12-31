package com.orangehrm.tests;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.utils.BaseClass;
import com.ornagehrm.pages.LoginPage;
import com.ornagehrm.pages.PIMPage;

public class TC_PIM_001 extends BaseClass{

	@Test(priority=1,dataProvider="getTC1Data")
	public void 
	createEmployeeFromPIM(LinkedHashMap<String,String> map) throws IOException, InterruptedException {
		String lname=map.get("Lname")+getRandomNum();
		lp.doLogin("Admin", "admin123");
		pp.createEmployee(map.get("Fname"), lname,lname, map.get("Password"));
		Thread.sleep(10000);
		String employee=driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']")).getText();
		System.out.println("emp is "+employee);
		setTestData("TC2_EditEmployeeDetails","Sheet1","Employee Name",employee);
		setTestData("TC3_ProvideAccessToEmployee","Sheet1","Employee Name",employee);

	}
	
	//@Test(priority=3)
	public void deleteEmployeeFromPIM() throws InterruptedException {

		//lp.doLogin(getProperty("userName"), getProperty("password"));
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//label[text()='Employee Name']/following::input[1]")).sendKeys("Robert");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	    driver.findElement(By.xpath("//div[text()='Henry ']/following::i[1]")).click();
	    driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
	}
	
	//@Test(priority=2,dataProvider="getTC2Data")
	public void editEmployee(LinkedHashMap<String,String> map) throws InterruptedException, FileNotFoundException {
		//String s="Henry Chase11";
		String empName=map.get("Employee Name");
		String[] emp=empName.split(" ");
		String fValue=emp[0];
		
		
		lp.doLogin(getProperty("userName"), getProperty("password"));
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//label[text()='Employee Name']/following::input[1]")).sendKeys(empName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()=\""+fValue+" "+"\"]/following::i[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Nationality']/following::div[1]")).click();
		WebElement Countrybox=driver.findElement(By.xpath("//div[@role='listbox']"));
		selectDropDown(map.get("Nationality"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Marital Status']/following::div[1]")).click();
		selectDropDown(map.get("Marital Status"));
		
		driver.findElement(By.xpath("(//button[text()=' Save '])[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Blood Type']/following::div[1]")).click();
		selectDropDown(map.get("Blood Type"));
		
		driver.findElement(By.xpath("(//button[text()=' Save '])[2]")).click();
	}
	
	public void selectDropDown(String value) {
	//	driver.findElement(By.xpath("//label[text()='Blood Type']/following::div[1]")).click();
		WebElement bloodtypebox=driver.findElement(By.xpath("//div[@role='listbox']"));
		List<WebElement> types=bloodtypebox.findElements(By.tagName("div"));
		
		for(WebElement type:types) {
			if(type.getText().equals(value)) {
				type.click();
				break;
			}
		}
	}
	
	@DataProvider
	public Object[][] getTC1Data(){
		return getData("TC1_CreateEmployeeFromPIM","Sheet1");
	}
	
	@DataProvider
	public Object[][] getTC2Data(){
		return getData("TC2_EditEmployeeDetails", "Sheet1");
	}
	
	
	
}

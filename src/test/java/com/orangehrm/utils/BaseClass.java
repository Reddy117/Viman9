package com.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;

import com.orange.elements.OR;
import com.orangehrm.factory.BasePageFactory;
import com.orangehrm.factory.WebPageFactory;
import com.ornagehrm.pages.AdminPage;
import com.ornagehrm.pages.LeavePage;
import com.ornagehrm.pages.LoginPage;
import com.ornagehrm.pages.PIMPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends OR{

	public static WebDriver driver;
	public static FileInputStream f;
	private static XSSFWorkbook w;
	private static XSSFSheet s;
	private static XSSFRow r;
	private static XSSFCell c;
	public static FileOutputStream out;
	public static Actions a;
	public BasePageFactory pageFactory;
	public LoginPage lp;
	public PIMPage pp;
	public AdminPage ap;
	public LeavePage leavep;
	
	@BeforeMethod
	public void openApp() {
		setup("chrome");
		lp=getPageFacotry().getLoginPage();
		pp=getPageFacotry().getPimPage();
		ap=getPageFacotry().getAdminPage();
		leavep=getPageFacotry().getLeavePage();
	}
	
	public  BasePageFactory getPageFacotry() {
		pageFactory=new WebPageFactory();
		return pageFactory;
	}
	
	
	
	public static void setup(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			DriverManager.setWebDriver(driver);
		}else if(browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			DriverManager.setWebDriver(driver);
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			DriverManager.setWebDriver(driver);
		}
		
		DriverManager.getWebDriver().manage().window().maximize();
		DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverManager.getWebDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.findElement(By.xpath("(//img[@alt='profile picture'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.quit();
	}
	
	public String getProperty(String propertyName) throws FileNotFoundException {
		System.out.println(System.getProperty("user.dir"));
		try {
			FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.property");
			Properties p=new Properties();
			p.load(f);
			return p.getProperty(propertyName);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return propertyName;
	
	}
	
	public static String getCellValue(String sheetName,int rowNum,int colNum) {
		try {
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestDta/OrangeData.xlsx");
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheetName);
			r=s.getRow(rowNum);
			c=r.getCell(colNum);
			
			return c.getStringCellValue();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object[][] getData(String tcName,String sheetName){
		int tcStartRow=0;
		
		while(!getCellValue(sheetName,tcStartRow,0).equals(tcName)) {

			tcStartRow++;
		}
		
		System.out.println(tcStartRow);
		
		int colsStartRow=tcStartRow+1;
		int cols=0;
		while(!getCellValue(sheetName, colsStartRow, cols).equals("N")) {
			//System.out.println(cols);
			cols++;
		}
		System.out.println(cols);
		
		int rows=0;
		int dataStartRow=tcStartRow+2;
		
		while(!getCellValue(sheetName, dataStartRow+rows, 0).equals("N")) {
			rows++;
		}
		System.out.println(rows);
		
		Object[][] data=new Object[rows][1];
		LinkedHashMap<String,String> dataMap;
		int index=0;
		for(int i=dataStartRow;i<dataStartRow+rows;i++) {
			dataMap=new LinkedHashMap();
			for(int j=0;j<cols;j++) {
				String key=getCellValue(sheetName, colsStartRow, j);
				String value=getCellValue(sheetName, i, j);
				dataMap.put(key, value);
				System.out.println(getCellValue(sheetName, i, j));
			}
			data[index][0]=dataMap;
			index++;
		}
		return data;
	}
	
	public static void setTestData(String tcName,String sheetName,String colName,String data) throws IOException {
		try {
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestDta/OrangeData.xlsx");
			w=new XSSFWorkbook(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int colNum=0;
		s=w.getSheet(sheetName);
		int tcRow=0;

		
		while(!getCellValue(sheetName,tcRow,0).equals(tcName)) {

			tcRow++;
		}
		r=s.getRow(tcRow+1);
		for(int i=0;i<r.getLastCellNum();i++) {
			if(r.getCell(i).getStringCellValue().trim().equals(colName)) {
				colNum=i;
			}
		}
		r=s.getRow(tcRow+2);
		c=r.getCell(colNum);
		c.setCellValue(data);
		out=new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/TestDta/OrangeData.xlsx");
		w.write(out);
		out.close();
		f.close();
	}
	
	public static int getRandomNum() {
		  Random rand = new Random();
		  
	        int num = rand.nextInt(100);
	       return num;
	}
	
	public static void main(String[] args) throws IOException {
		//System.out.println(getCellValue("Sheet1",1,2));
		getData("TC2_EditEmployeeDetails","Sheet1");
		//setTestData("TC2_EditEmployeeDetails","Sheet1","Employee Name","Hi");
		System.out.println(getRandomNum());
	}
	
	public static String getTextOfEle(WebElement ele) {
		return ele.getText();
	}
	
	public void selectDropDown(WebElement ele,String value) {
	
			List<WebElement> types=ele.findElements(By.tagName("div"));
			
			for(WebElement type:types) {
				System.out.println(type.getText());
				if(type.getText().equals(value)) {
					type.click();
					break;
				}
			}
		}
	
}

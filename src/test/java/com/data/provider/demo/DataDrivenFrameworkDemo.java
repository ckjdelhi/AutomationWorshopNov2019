package com.data.provider.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.base.DriverFactory;
import com.guru99.framework.keywordDriven.ReusableFuntion;

public class DataDrivenFrameworkDemo {
	ReusableFuntion utils=null;
	private WebDriver driver=null;;
	
	@BeforeClass
	public void setUp() {
		driver=DriverFactory.getBrowser("chrome");
		utils=new ReusableFuntion(driver);
	}
	
	@DataProvider(name = "Guru99Data")
	public Object[][] readDataFromExcel() throws Exception{
		return (Object[][])utils.fetchDataFromExcelSheet();
	}
	@Test(dataProvider = "Guru99Data")
	public void test_case_guru99_demo(String tCaseName,String tStepsName,String desc,String action,String locator,String locatorValue, String parameter) {
		switch(action) {
			case "launchApp":
				utils.launchApplication();
				break;
			case "fillText":
				utils.fillText(locator,locatorValue,parameter);
				break;
			case "click": 
				utils.click(locator,locatorValue);
				break;
			case "selectDropDown": 
				utils.selectDropDown(locator,locatorValue,parameter);
				break;
			case "selectRadio": 
				utils.selectRadio(locator,locatorValue,parameter);
				break;
		}
	}
	@AfterClass
	public void close() {
		driver.quit();
	}
  
}

package com.guru99.framework.keywordDriven;

import org.openqa.selenium.WebDriver;

import com.guru99.base.DriverFactory;

public class ExecutionEngine {

	public static void main(String[] args) throws Exception {
		WebDriver driver=DriverFactory.getBrowser("chrome");
		ReusableFuntion utils=new ReusableFuntion(driver);
		
		String[][] data=utils.fetchDataFromExcelSheet();
		for(int i=1; i<data.length;i++) {
			String action=data[i][3];
			String locator=data[i][4];
			String locatorValue=data[i][5];
			String parameter=data[i][6];
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
		System.out.println("Automation is done \t test again");
	}

}

package com.guru99.framework.keywordDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.guru99.base.DriverFactory;

public class ReusableFuntion {
	WebDriver driver=null;
	public ReusableFuntion(WebDriver driver) {
		this.driver=driver;
	}

	public String[][] fetchDataFromExcelSheet() throws Exception {
		//String path="C:\\Users\\Chandan\\Desktop\\kdd\\selenium_keywords.xlsx";
		String path=fetchProp("EXCEL_PATH");
		FileInputStream fs=new FileInputStream(new File(path));
		String fileExtn=path.substring(path.indexOf('.')+1);
		Workbook workbook=null;
		if(fileExtn.equals("xls")) {
			workbook=new HSSFWorkbook(fs);
		}else {
			workbook=new XSSFWorkbook(fs);
		}
		Sheet sheet=workbook.getSheet(fetchProp("EXCEL_SHEET"));
		int rowNum=sheet.getLastRowNum()+1;
		int colNum=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowNum][colNum];
		for(int i=0;i<rowNum;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<colNum;j++) {
				Cell cell=row.getCell(j);
				String value=cell.toString();
				data[i][j]=value;
			}
		}
		workbook.close();
		return data;
	}

	public void launchApplication() {
		driver.get(fetchProp("URL"));
	}

	public void fillText(String locator, String locatorValue, String parameter) {
		switch(locator) {
			case "id":
				driver.findElement(By.id(locatorValue)).sendKeys(parameter);
				break;
			case "name":
				driver.findElement(By.name(locatorValue)).sendKeys(parameter);
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).sendKeys(parameter);
				break;
		}
	}

	public void click(String locator, String locatorValue) {
		switch(locator) {
			case "id":
				driver.findElement(By.id(locatorValue)).click();
				break;
			case "name":
				driver.findElement(By.name(locatorValue)).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).click();
				break;
			case "linkText":
				driver.findElement(By.linkText(locatorValue)).click();
				break;
		}
	}

	public void selectDropDown(String locator, String locatorValue, String parameter) {
		switch(locator) {
			case "id":
				Select obj=new Select(driver.findElement(By.id(locatorValue)));
				obj.selectByValue(parameter);
				break;
			case "name":
				Select obj1=new Select(driver.findElement(By.name(locatorValue)));
				obj1.selectByValue(parameter);
				break;
			case "xpath":
				Select obj2=new Select(driver.findElement(By.xpath(locatorValue)));
				obj2.selectByValue(parameter);
				break;
			}
		
	}

	public void selectRadio(String locator, String locatorValue, String parameter) {
		switch(locator) {
		case "name":
			if(parameter.equals("m") || parameter.equals("male")) {
				driver.findElements(By.name(locatorValue)).get(0).click();
			}else {
				driver.findElements(By.name(locatorValue)).get(1).click();
			}
			break;
		
		}
		
	}
	
	public static String fetchProp(String key) {
		Properties pro=new Properties();
		FileInputStream fs=null;
		try {
			fs=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/ObjectRepository.properties");
			pro.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro.getProperty(key);
	}

}

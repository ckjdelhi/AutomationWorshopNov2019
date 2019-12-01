package com.data.provider.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.base.DriverFactory;

public class FirstTest {
	private WebDriver driver=null;
	@BeforeTest
	public void setUp() {
		driver=DriverFactory.getBrowser("chrome");
	}
	@Test(priority = 0)
	public void openBrowser() {
		driver.get("http://demo.guru99.com/v4/");
	}
	@Test(priority = 1, dependsOnMethods = "openBrowser")
	public void enterUserId() {
		driver.findElement(By.name("uid")).sendKeys("abc");
	}
	@Test(priority = 1, dependsOnMethods = "enterUserId")
	public void enterPassword() {
		driver.findElement(By.name("uid")).sendKeys("abc");
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
  
}

package com.guru99.pageObject;

import org.openqa.selenium.WebDriver;

import com.guru99.base.DriverFactory;

public class MainTestExecutor {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getBrowser("chrome");
		driver.get("http://demo.guru99.com/v4/index.php");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserId("mgr123");
		loginPage.setPassword("mgr!23");
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnNewCustomer();
		
		NewCustomerPage newCustomerPage=new NewCustomerPage(driver);
		newCustomerPage.setCustomerName("Chandan");
		newCustomerPage.setGender("f");
		newCustomerPage.setDOB("01012000");
		

	}

}

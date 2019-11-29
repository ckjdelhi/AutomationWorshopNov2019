package com.guru99.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "uid")
	private WebElement txtUserId;
	
	@FindBy(name = "password")//WebElement txtPassword = driver.findElement(By.name("password")
	private WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	private WebElement buttonLogin;
	
	@FindBy(xpath = "/html/body/form/table/tbody/tr[3]/td[2]/input[2]")
	private WebElement buttonReset;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setUserId(String userId) {
		this.txtUserId.sendKeys(userId);
	}
	public void setPassword(String password) {
		this.txtPassword.sendKeys(password);
	}
	public void clickOnLoginButton() {
		this.buttonLogin.click();
	}
	public void clickOnResetButton() {
		this.buttonReset.click();
	}
}

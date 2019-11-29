package com.guru99.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "New Customer")
	private WebElement linkNewCustomer;
	
	@FindBy(linkText = "Edit Customer")
	private WebElement linkEditCustomer;
	
	@FindBy(linkText = "Delete Customer")
	private WebElement linkDeleteCustomer;
	
	@FindBy(linkText = "New Account")
	private WebElement linkNewAccount;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewCustomer() {
		this.linkNewCustomer.click();
	}
	public void clickOnEditCustomer() {
		this.linkEditCustomer.click();
	}
	public void clickOnDeleteCustomer() {
		this.linkDeleteCustomer.click();
	}
	public void clickOnNewAccount() {
		this.linkNewAccount.click();
	}
}

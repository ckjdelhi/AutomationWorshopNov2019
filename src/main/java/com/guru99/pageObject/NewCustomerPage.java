package com.guru99.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	@FindBy(name = "name")
	private WebElement txtCustomerName;
	
	@FindBys(@FindBy(name = "rad1"))
	private List<WebElement> radioGender;
	
	@FindBy(id = "dob")
	private WebElement txtDateOfBirth;
	
	public NewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setCustomerName(String customerName) {
		this.txtCustomerName.sendKeys(customerName);
	}
	public void setDOB(String dob) {
		this.txtDateOfBirth.sendKeys(dob);
	}
	public void setGender(String gender) {
		if(gender.equals("m")) {
			this.radioGender.get(0).click();
		}else {
			this.radioGender.get(1).click();
		}
	}
	
}

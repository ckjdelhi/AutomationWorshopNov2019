package com.guru99.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {
	public NewAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

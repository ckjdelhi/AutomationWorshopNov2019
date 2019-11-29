package com.guru99.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	private static WebDriver driver=null;
	public static WebDriver getBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Chandan\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\Chandan\\Downloads\\Compressed\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", 
					"C:\\Users\\Chandan\\Downloads\\Compressed\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if(driver !=null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}
}

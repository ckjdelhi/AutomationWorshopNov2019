package com.guru99.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.guru99.base.DriverFactory;

public class Guru99Automation {

	public static void main(String[] args) {
		/*System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Chandan\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();*/
		
		WebDriver driver = DriverFactory.getBrowser("chrome");
		driver.get("http://demo.guru99.com/v4/index.php");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("uid")).sendKeys("mgr123");
		driver.findElement(By.name("password")).sendKeys("mgr!23");
		driver.findElement(By.name("btnLogin")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("New Customer")).click();
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys("mgr123");
		driver.findElements(By.name("rad1")).get(1).click();
		driver.findElement(By.id("dob")).sendKeys("01012000");
	}

}

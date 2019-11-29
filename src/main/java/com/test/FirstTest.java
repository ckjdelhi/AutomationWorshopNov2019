package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Chandan\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("file:///C:/Users/Chandan/Desktop/index.html");
		//driver.findElement(By.name("userName")).sendKeys("chandan");
		//driver.findElement(By.name("password")).sendKeys("123456");
		//<input type="text" name="q" id="abc" class="someCss"/>
		driver.get("https://www.google.com/");
		//driver.findElement(By.className("someCss")).sendKeys("Selenium webdriver");
		//driver.findElement(By.name("btnK")).submit();
		//WebElement aboutLink = driver.findElement(By.linkText("About"));
		//WebElement aboutLink = driver.findElement(By.partialLinkText("How Search"));
		
		//Absolute XPATH= /html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input
		//Relative Xpath= //*[@id="tsf"]/div[2]/div[1]/div[1]/div/div[2]/input
		
		WebElement textBox = driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
		textBox.sendKeys("automation ");
		
		//#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input
		driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"));
	}

}

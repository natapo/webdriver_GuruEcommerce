package com.natapo.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase01 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://live.guru99.com";
		String actualText;
		String actualTitle;
		String expectedText = "THIS IS DEMO SITE";
		String expectedTitle = "Mobile";
		
		driver.get(baseUrl);
		actualText = driver.findElement(By.cssSelector("h2")).getText();
		if(actualText.contains(expectedText)) {
			System.out.println("Test passed!");
		}else {
			System.out.println("Test failed!");
		}
		
		driver.findElement(By.linkText("MOBILE")).click();
		actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Test passed!");
		}else {
			System.out.println("Test failed!");
		}
		
		Select sortBy = new Select (driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))); 
		sortBy.selectByVisibleText("Name");
				
		driver.quit();
}
}

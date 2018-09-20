package com.natapo.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase02 {
	public static void main(String[] args){
	System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver;
	String baseUrl;
	//StringBuffer verificationErrors = new StringBuffer();
	
	
	//void setUp() throws Exception 
	//{
	driver = new ChromeDriver();
	baseUrl = "http://live.guru99.com/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//}
	
	//void testCase1() throws Exception
	//{
		String actualTitle;
		String expectedTitle = "Mobile";
		String costExperiaFromPageList;
		String costExperiaFromPageDetails;
		String idProductExperia;
		
		driver.get(baseUrl);
			
		driver.findElement(By.linkText("MOBILE")).click();
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if(actualTitle.contains(expectedTitle)) {
			System.out.println("Test passed!");
		}else {
			System.out.println("Test failed!");
		}
		
		/*
		try {
			AssertJUnit.assertEquals(expectedTitle, actualTitle);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		*/
		
		idProductExperia="product-price-1";
		costExperiaFromPageList = driver.findElement(By.id(idProductExperia)).getText();
		System.out.println("Price from Page List:" + costExperiaFromPageList);		
		driver.findElement(By.linkText("SONY XPERIA")).click();
		
		costExperiaFromPageDetails = driver.findElement(By.id(idProductExperia)).getText();
		System.out.println("Price from Page Details:" + costExperiaFromPageDetails);
		if(costExperiaFromPageList.contentEquals(costExperiaFromPageDetails)){
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
		
	//}
	
	//void tearDown() throws Exception 
	//{
		driver.quit();
	//}

	}
}


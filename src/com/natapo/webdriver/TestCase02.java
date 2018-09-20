package com.natapo.webdriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase02 {
	public static void main(String[] args){
	System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver;
	String baseUrl;
	
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
		try {
			assertEquals(expectedTitle, actualTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		idProductExperia="product-price-1";
		costExperiaFromPageList = driver.findElement(By.id(idProductExperia)).getText();
		driver.findElement(By.linkText("SONY XPERIA")).click();
		costExperiaFromPageDetails = driver.findElement(By.id(idProductExperia)).getText();
		try {
			assertEquals(costExperiaFromPageList, costExperiaFromPageDetails);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		System.out.println("Test passed!");
		
	//}
	
	//void tearDown() throws Exception 
	//{
		driver.quit();
	//}

	}
}


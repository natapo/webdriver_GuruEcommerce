package com.natapo.webdriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {
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
	
	//void testCase3() throws Exception
	//{
		String actualTitle;
		String expectedTitle = "Mobile";
		String costExperiaFromPageList;
		String costExperiaFromPageDetails;
		String idProductExperia;
		
		driver.get(baseUrl);
			
		driver.findElement(By.linkText("MOBILE")).click();
		//driver.findElement(By.cssSelector(ADD TO CART XPERIA)).click();
		driver.findElement(By.name("cart[81724][qty]")).clear();
		driver.findElement(By.name("cart[81724][qty]")).sendKeys("1000");
		
		
		
		
		System.out.println("Test passed!");
		
	//}
	
	//void tearDown() throws Exception 
	//{
		driver.quit();
	//}

	}
}



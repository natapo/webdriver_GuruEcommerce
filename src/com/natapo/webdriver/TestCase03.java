package com.natapo.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase03 {
	private WebDriver driver;
	private String baseUrl ="http://live.guru99.com/";
	
	void setUp(){
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	void openBrowserAndGoToBaseLink() {
		driver.get(baseUrl);
	}
	

	
	void runTest3(){
		setUp();
		String pageListOfMobiles = "MOBILE";
		// need to find a locator
		String buttonAddToCartXperia = "";
		
		openBrowserAndGoToBaseLink();
		
		goToPageViaLink(pageListOfMobiles);
		goToPageViaCssSelector(buttonAddToCartXperia);

		
		driver.findElement(By.name("cart[81724][qty]")).clear();
		driver.findElement(By.name("cart[81724][qty]")).sendKeys("1000");
		
		
		endOfTest();
		System.out.println("Test passed!");
	}
	
	void goToPageViaLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	void goToPageViaCssSelector(String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	void endOfTest() {
		driver.quit();
	}
}



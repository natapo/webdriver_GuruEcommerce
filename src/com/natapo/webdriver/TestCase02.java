package com.natapo.webdriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase02 {
	private WebDriver driver;
	private String baseUrl = "http://live.guru99.com/";

	void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	void openBrowserAndGoToLink() {
		driver.get(baseUrl);
	}


	void testRun() {
		// WebDriver driver;
		// String baseUrl;
		setUp();
		String expectedTitle = "Mobile";
		String idProductExperia = "product-price-1";
		String pageListOfMobiles = "MOBILE";
		String pageOfProduct = "SONY XPERIA";
		
		openBrowserAndGoToLink();
        
		goToPageViaLink(pageListOfMobiles);
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
				
		String costExperiaFromPageList = driver.findElement(By.id(idProductExperia)).getText();
		goToPageViaLink(pageOfProduct);
		String costExperiaFromPageDetails = driver.findElement(By.id(idProductExperia)).getText();
		assertEquals(costExperiaFromPageList, costExperiaFromPageDetails);
		
		System.out.println("Test passed!");
		endOfTest();
	}

	void goToPageViaLink(String link){
		driver.findElement(By.linkText(link)).click();
	}
	
	void endOfTest() {
		driver.quit();
	}
}

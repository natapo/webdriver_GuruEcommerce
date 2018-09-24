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

	void openBrowserAndGoToBaseLink() {
		driver.get(baseUrl);
	}

	
	void testRun() {
		setUp();
		String expectedTitle = "Mobile";
		String idProductExperia = "product-price-1";
		String pageListOfMobiles = "MOBILE";
		String pageOfProduct = "SONY XPERIA";
		
		openBrowserAndGoToBaseLink();
        
		goToPageViaLink(pageListOfMobiles);
		assertPageTitle(expectedTitle);
						
		String costExperiaFromPageList = driver.findElement(By.id(idProductExperia)).getText();
		goToPageViaLink(pageOfProduct);
		String costExperiaFromPageDetails = driver.findElement(By.id(idProductExperia)).getText();
		assertEquals(costExperiaFromPageList, costExperiaFromPageDetails);
		
		endOfTest();
		System.out.println("Test passed!");
	}

	void assertPageTitle(String expectedTitle){
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	
	void goToPageViaLink(String link){
		driver.findElement(By.linkText(link)).click();
	}
	
	
	void endOfTest() {
		driver.quit();
	}
}

package com.natapo.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class TestCase01 {
	private WebDriver driver;
	private String baseUrl="http://live.guru99.com";

	
	void setUp(){
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	void openBrowserAndGoToBaseLink() {
		driver.get(baseUrl);
	}
	
	
	public void testRun() {
		setUp();
		String homePageWelcomeTextLocation = "h2";
		String pageListOfMobiles = "MOBILE";
		String demoSiteExpectedText = "THIS IS DEMO SITE FOR";
		String expectedTitle = "Mobile";
		String dropdownLocation = "select[title=\"Sort By\"]";
		String dropdownParametr = "Name";
		
		openBrowserAndGoToBaseLink();
		
		String demoSiteText = driver.findElement(By.cssSelector(homePageWelcomeTextLocation)).getText();
		if(demoSiteText.contains(demoSiteExpectedText)) {
			System.out.println("Test passed!");
		}else {
			System.out.println("Test failed!");
		}
		//assertEquals(demoSiteText, demoSiteExpectedText);
		
		driver.findElement(By.linkText(pageListOfMobiles)).click();
		assertPageTitle(expectedTitle);
		
		sortProducts(dropdownLocation, dropdownParametr);
		takeScreenshot();
		
		endOfTest();
		System.out.println("Test Passed");
	}
	
	
	void assertPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
	
	
	void sortProducts(String dropdownLocation, String dropdownParametr ) {
		Select sortBy = new Select (driver.findElement(By.cssSelector(dropdownLocation))); 
		sortBy.selectByVisibleText(dropdownParametr);
	}
	
	
	void takeScreenshot() {
		int scc = 0;
		scc =(scc+1);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png = ("" + scc + ".png");
		//FileUtils.copyFile(scrFile, new File(png));
		}

	
	void endOfTest() {
		driver.quit();
	}
}


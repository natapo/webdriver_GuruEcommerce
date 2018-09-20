package com.natapo.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;
//import org.testing.AssertJUnit;



public class TestCase01 {
	public static void main(String[] args){
	System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver;
	String baseUrl;
	int scc = 0;
	StringBuffer verificationErrors = new StringBuffer();
	
	
	//void setUp() throws Exception 
	//{
	driver = new ChromeDriver();
	baseUrl = "http://live.guru99.com";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//}
	
	//void testCase1() throws Exception
	//{
		String demoSiteText;
		String actualTitle;
		String demoSiteExpectedText = "THIS IS DEMO SITE";
		String expectedTitle = "Mobile";
		
		driver.get(baseUrl);
		
		demoSiteText = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(demoSiteText);
		if(demoSiteText.contains(demoSiteExpectedText)) {
			System.out.println("Test passed!");
		}else {
			System.out.println("Test failed!");
		}
		/*
		try {
			AssertJUnit.assertEquals(demoSiteExpectedText, demoSiteText);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		*/
		
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
		
		Select sortBy = new Select (driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))); 
		sortBy.selectByVisibleText("Name");
		scc =(scc+1);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png = ("" + scc + ".png");
		//FileUtils.copyFile(scrFile, new File(png));
	//}
	
	//void tearDown() throws Exception 
	//{
		driver.quit();
	//}

	}
}


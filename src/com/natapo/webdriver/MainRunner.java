package com.natapo.webdriver;

public class MainRunner {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\chromedriver_win32\\chromedriver.exe");
		TestCase01 test1 = new TestCase01();
		test1.testRun();
		TestCase02 test2 = new TestCase02();
		test2.testRun();
		
	}
}

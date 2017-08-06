package br.com.huetech.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.huetech.common.Property;
import br.com.huetech.common.Selenium;
import br.com.huetech.test.suite.AllTests;

public class BaseTestCase {
	
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() throws Exception {	
		if (!AllTests.isAllTestsExecution){
			driver = Selenium.getDriver();
			driver.navigate().to(Property.URL);
			driver.manage().window().maximize();
		}
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		if (!AllTests.isAllTestsExecution){
			Selenium.resetDriver();
		}
	}
}
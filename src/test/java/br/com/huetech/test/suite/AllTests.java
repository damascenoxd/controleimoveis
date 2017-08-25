package br.com.huetech.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

import br.com.huetech.common.Property;
import br.com.huetech.common.Selenium;
import br.com.huetech.test.TestClienteIT;
/**
 * Classe que agrupa todas as classes de teste, funcionando com uma suíte de regressão.
 * @author Jarbas
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestClienteIT.class,
	MassaDadosIT.class
})

public class AllTests {
protected static WebDriver driver;
	
	public static Boolean isAllTestsExecution = false;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		isAllTestsExecution = true;
		driver = Selenium.getDriver();
		driver.navigate().to(Property.URL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		Selenium.resetDriver();
	}

}

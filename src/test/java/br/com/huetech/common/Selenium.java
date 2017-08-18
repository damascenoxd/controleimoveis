package br.com.huetech.common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;;



/**
 * Classe Utils para o Selenium
 * Identifica qual o browser escolhido no config.properties e inicializa o webdriver correspondente
 */
public class Selenium {
	
	private static WebDriver driver = null;
	
	
	/**
	 * Verifica qual o browser escolhido no arquivo de propriedades
	 * inicializa o driver apropriado e o retorna
	 * @return retorna instância do WebDriver
	 */
	public static WebDriver getDriver() {
		String browser = Property.BROWSER_NAME;
		if (driver == null) {
			if (Browser.CHROME.equals(browser)) {
				File file = new File(Property.CHROME_DRIVE_PATH);
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
			} else if (Browser.IE.equals(browser)) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				File file = new File(Property.IE64_DRIVE_PATH);
				
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
			} else if (Browser.EDGE.equals(browser)) {
				System.setProperty("webdriver.edge.driver", "drivers/MicrosoftWebDriver.exe");
				
			}else  if (Browser.FIREFOX.equals(browser)){
				//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Jarbas Junior\\Git\\controleimoveis\\src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	public static void resetDriver(){
		if (driver != null) {
			driver.close();
		}
		driver = null;
	}
	
}
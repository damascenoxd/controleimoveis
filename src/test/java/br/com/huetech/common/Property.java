package br.com.huetech.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
* @author jarbas.junior
* Define o caminho do driver dos diferentes browsers
* Acessa as configura��es definidas no config.properties e retorna a informa��o 
*/
public abstract class Property {

	public static       String CHROME_DRIVE_PATH;
	public static       String IE64_DRIVE_PATH;
	public static       String FIREFOX_DRIVE_PATH;
	public static final String BROWSER_NAME;
	public static final String URL_PODIO;
	public static final String LOGIN;
	public static final String PASSWORD;
	
	private static final String PROPERTIES_FILE = "br/com/huetech/config.properties";
	
	static{
		CHROME_DRIVE_PATH  = new File("").getAbsolutePath() + "\\src\\main\\resources\\chromedriver.exe";
		IE64_DRIVE_PATH    = new File("").getAbsolutePath() + "\\src\\main\\resources\\IEDriverServer.exe";
		FIREFOX_DRIVE_PATH = new File("").getAbsolutePath() + "%PROGRAMFILES%\\Mozilla Firefox\\firefox.exe";
		BROWSER_NAME       = get("browser.name");
		URL_PODIO          = get("site.address");
		LOGIN              = get("login");
		PASSWORD           = get("password");
	}
	
	/**
	 * Metodo para pegar o valor de alguma propriedade no arquivo de configuracao do Selenium
	 * O caminho e o nome do arquivo pode ser trocados
	 */
	private static String get(String name) {
		Properties properties = new Properties();
		String     value      = null;
		try {
			properties.load(Property.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		    value = properties.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}

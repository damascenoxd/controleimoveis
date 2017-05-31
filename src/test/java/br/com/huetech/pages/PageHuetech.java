package br.com.huetech.pages;

import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.huetech.common.Property;
import br.com.huetech.common.Selenium;
import br.com.huetech.util.Utils;

public abstract class PageHuetech<T> {

	private static final String URL_HUETECH = Property.URL;
	private static final int LOAD_TIMEOUT = 15;
	private String windowHandleJanelaInicial;

	public PageHuetech() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	public T abrirPagina(Class<T> clazz) {
		T pagina = PageFactory.initElements(Selenium.getDriver(), clazz);
		Selenium.getDriver().navigate().to(URL_HUETECH);
		return pagina;
	}

	public void preencherCampo(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (WebDriverException e) {
//			Utils.takeScreenshot("Erro ao preencher campo " + nomeCampo);
		}
	}
	
	public void preencherCampoObrigatorio(String idCampo, WebElement campoDesabilitado, WebElement campoHabilitado, String value) {
		try {
			campoDesabilitado.click();
			aguardarElementoVisivel(campoHabilitado);
			preencherCampo(campoHabilitado, value);
			String prefixoCampoObrigatorio = ".//*[@id='"+idCampo+"']/div[1]/div[2]/div/div[2]/div/ul/li[@class='item ']/div/div[2]/div[1]/span[contains(text(), '";
			String sufixoCampoObrigatorio = "')]";
			Utils.wait(1000);
			WebElement opcaoEscolhida = Selenium.getDriver().findElement(By.xpath(prefixoCampoObrigatorio+value+sufixoCampoObrigatorio));
			opcaoEscolhida.click();
		} catch (WebDriverException e) {
//			Utils.takeScreenshot("Erro ao preencher campo " + nomeCampo);
		}
	}
	
	public void preencherCampoClicando(WebElement elemento, WebElement elementoHabilitado, String value) {
		try {
			elemento.click();
			aguardarElementoVisivel(elementoHabilitado);
			elementoHabilitado.sendKeys(value);
			elementoHabilitado.click();
		} catch (WebDriverException e) {
//			Utils.takeScreenshot("Erro ao preencher campo " + nomeCampo);
		}
	}

	public void click(WebElement element) {
		try {
			aguardarElementoVisivel(element);
			element.click();
		} catch (Exception e) {
//			Utils.takeScreenshot("");
		}
	}

	public String getValorAtributo(WebElement element) {
		return element.getAttribute("value");
	}

	public void selectElementByVisibleText(WebElement element,
			String textVisible) {
		try {
			new Select(element).selectByVisibleText(textVisible);
		} catch (NoSuchElementException e) {
			Assert.fail("Erro ao selecionar no elemento: ["
					+ element.getTagName() + "] com o o valor: " + textVisible);
		}
	}

	public void selectElementByVisibleValue(WebElement element,
			String valueVisibel) {
		try {
			new Select(element).selectByValue(valueVisibel);
		} catch (NoSuchElementException e) {
//			Utils.takeScreenshot("");
			Assert.fail("Erro ao selecionar no elemento: ["
					+ element.getTagName() + "] com o o valor: " + valueVisibel);
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = Selenium.getDriver().switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			Assert.fail("Erro ao realizar a confirma��o do Alerta");
		}
	}

	public String getAlert() {
		String alerta = "";
		try {
			Alert alert = Selenium.getDriver().switchTo().alert();
			alerta = alert.getText();
		} catch (Exception e) {
		}
		return alerta;
	}

	public void aguardarElementoVisivel(WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(Selenium.getDriver(),
					LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Assert.fail("Tempo excedido para aguardar elemento: " + element);
		}
	}

	public void aguardarElementoVisivelComTexto(WebElement element, String text) {
		try {
			WebDriverWait driverWait = new WebDriverWait(Selenium.getDriver(),
					LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.textToBePresentInElement(
					element, text));
		} catch (Exception e) {
			Assert.fail("Tempo excedido para aguardar elemento: " + element);
		}
	}

	public boolean isVisibility(WebElement elemento) {
		try {
			return elemento.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isVisibility(By locator) {
		try {
			WebElement element = Selenium.getDriver().findElement(locator);
			element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void selectComboValue(WebElement element, final String value) {
		Select selectBox = new Select(element); 
		selectBox.selectByValue(value);
	}

	public void clicarBotaoDireito(WebElement elemento) {
		Actions action = new Actions(Selenium.getDriver());
		action.contextClick(elemento).build().perform();
	}

	public void moverCursorPara(WebElement elemento) {
		Actions action = new Actions(Selenium.getDriver());
		action.moveToElement(elemento).build().perform();
	}
	
	public boolean existText(WebElement elemento, String texto) {
		aguardarElementoVisivel(elemento);
		return elemento.getText().contains(texto);
	}

	public void voltarPagina() {
		Selenium.getDriver().navigate().back();
	}

	/**
	 * Seta para nova janela aberta
	 */
	public void alternarJanela() {
		windowHandleJanelaInicial = Selenium.getDriver().getWindowHandle();
		Set<String> windowHandles = Selenium.getDriver().getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(windowHandleJanelaInicial)) {
				Selenium.getDriver().switchTo().window(windowHandle);
			}
		}
		setWindowHandleJanelaInicial(windowHandleJanelaInicial);
	}

	public String getWindowHandleJanelaInicial() {
		return windowHandleJanelaInicial;
	}

	public void setWindowHandleJanelaInicial(String windowHandleJanelaInicial) {
		this.windowHandleJanelaInicial = windowHandleJanelaInicial;
	}

	public void alertaSaidaDoSistema() {
		Alert alert = Selenium.getDriver().switchTo().alert();
		alert.accept();
	}

	/**
	 * 
	 * @return Janela anterior
	 */
	public void retonarJanelaOriginal() {
		Selenium.getDriver().switchTo().window(getWindowHandleJanelaInicial());
	}

	public WebElement getElement(By by) {
		return Selenium.getDriver().findElement(by);
	}

	// public void isEquals(String esperado, String retornado){
	// if(!esperado.equals(retornado)){
	// Log.erro("Erro - Esperado: "+ esperado+ "| mas retornou: "+retornado);
	// }
	// }
}

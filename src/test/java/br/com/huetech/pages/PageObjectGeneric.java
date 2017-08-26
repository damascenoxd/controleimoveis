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
import br.com.huetech.util.Log;
import br.com.huetech.util.Utils;

public abstract class PageObjectGeneric<T> {

	private static final String URL_HUETECH  = Property.URL;
	private static final int    LOAD_TIMEOUT = 10;
	private              String windowHandleJanelaInicial;

	public PageObjectGeneric() {
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
			Log.erro("["+element+"] não encontrado, valor ["+value+"] não pode ser preenchido.");
			Assert.fail("["+element+"] não encontrado, valor ["+value+"] não pode ser preenchido.");
		}
	}
	
	public void click(WebElement element) {
		try {
			aguardarElementoVisivel(element);
			element.click();
		} catch (WebDriverException e) {
			Log.erro("Erro ao clicar no elemento ["+element+"].");
			Assert.fail("Erro ao clicar no elemento ["+element+"].");
		}
	}

	public String getValorAtributo(WebElement element) {
		try {
			return element.getAttribute("value");
		} catch (Exception e) {
			Log.erro("Erro ao buscar valor de atributo do elemento ["+element+"].");
			Assert.fail("Erro ao buscar valor de atributo do elemento ["+element+"].");
			return null;
		}
	}

	public void selectElementByVisibleText(WebElement element, String textVisible) {
		try {
			new Select(element).selectByVisibleText(textVisible);
		} catch (WebDriverException e) {
			Log.erro("["+element+"] do combobox não encontrado, valor ["+textVisible+"] não pode ser selecionado.");
			Assert.fail("["+element+"] do combobox não encontrado, valor ["+textVisible+"] não pode ser selecionado.");
		}
	}

	public void selectElementByVisibleValue(WebElement element, String valueVisible) {
		try {
			new Select(element).selectByValue(valueVisible);
		} catch (WebDriverException e) {
			Log.erro("["+element+"] do combobox não encontrado, valor ["+valueVisible+"] não pode ser selecionado.");
			Assert.fail("["+element+"] do combobox não encontrado, valor ["+valueVisible+"] não pode ser selecionado.");
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = Selenium.getDriver().switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			Log.erro("Erro ao realizar a confirmacao do Alerta");
			Assert.fail("Erro ao realizar a confirmacao do Alerta");
		}
	}

	public String getAlert() {
		String alerta = "";
		try {
			Alert alert = Selenium.getDriver().switchTo().alert();
			alerta = alert.getText();
		} catch (Exception e) {
			Log.erro("Erro ao realizar a confirmacao do Alerta");
			Assert.fail("Erro ao realizar a confirmacao do Alerta");
		}
		return alerta;
	}

	public void aguardarElementoVisivel(WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(Selenium.getDriver(),
					LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Log.erro("Tempo excedido para aguardar elemento: " + element);
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
			Log.erro("Tempo excedido para aguardar elemento: " + element);
			Assert.fail("Tempo excedido para aguardar elemento: " + element);
		}
	}
	
	public void aguardarMensangemDesaparecer(By elemento, int limiteSegundos){
		try {
			int contadorSegundos = 1;
			while (isVisibility(elemento) && (limiteSegundos != contadorSegundos)) {
				Utils.wait(1000);
				contadorSegundos++;
			}
		} catch (Exception e) {
			Log.erro("Tempo excedido para aguardar elemento: " + elemento);
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
}

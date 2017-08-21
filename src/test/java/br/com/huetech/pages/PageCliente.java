package br.com.huetech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;
import br.com.huetech.util.Log;

public class PageCliente extends PageObjectGeneric<PageCliente> {

	public PageCliente() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(css = ".caret")
	WebElement menu;
	
	@FindBy(xpath = ".//*[@id='menu']/ul/li/ul/li[1]/a")
	WebElement addCliente;
	
	public void adicionarNovoCliente(){
		aguardarElementoVisivel(menu);
		menu.click();
		aguardarElementoVisivel(addCliente);
		addCliente.click();
		Log.info("Direcionando para página de formulário de cliente...");
	}
}

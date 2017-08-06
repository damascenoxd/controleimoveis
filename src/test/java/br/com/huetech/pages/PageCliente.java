package br.com.huetech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;

public class PageCliente extends PageObjectGeneric<PageCliente> {

	public PageCliente() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(xpath = "html/body/div[1]/div/div/a/span")
	WebElement botaoAddCliente;
	
	public void adicionarCliente(){
		aguardarElementoVisivel(botaoAddCliente);
		botaoAddCliente.click();
	}
}

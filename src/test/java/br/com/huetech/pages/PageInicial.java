package br.com.huetech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;

public class PageInicial extends PageObjectGeneric<PageInicial> {

	public PageInicial() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "welcome.button.contato")
	WebElement botaoContato;
	
	@FindBy(id = "index.navlink.paginainicial")
	WebElement abaPaginaInicial;
	
	public void irParaPaginaContato(){
		aguardarElementoVisivel(botaoContato);
		botaoContato.click();
		botaoContato.click();
	}
	
	public void irParaPaginaInicial(){
		aguardarElementoVisivel(abaPaginaInicial);
		abaPaginaInicial.click();
	}

}

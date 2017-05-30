package br.com.huetech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;

public class PageInicial extends PagePodio<PageInicial> {

	public PageInicial() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(xpath = ".//*[@id='header-global']/nav/div[2]/ul[2]/li[3]/a/div")
	WebElement iconeMinhaConta;

	@FindBy(css = ".section>ul>li>div>a[href='/logout']")
	WebElement linkDesconectar;
	
	@FindBy(xpath = ".//*[@id='wrapper']/div/div/div/div/div[2]/div/div[2]/ul/li[1]/div[9]/div[1]/h5")
	WebElement menuItensRecentes;
	
	@FindBy(css = ".icon.icon-16.icon-16-hamburger")
	WebElement menuInicial;
	
	@FindBy(css = ".top-space.regular-space>a[href='https://podio.com/canuto-imoveis-teste/administrativo']")
	WebElement menuInicialAdministrativo;
	
	public void desconectarConta() {
		aguardarElementoVisivel(iconeMinhaConta);
		iconeMinhaConta.click();
		aguardarElementoVisivel(linkDesconectar);
		linkDesconectar.click();
	}
	
	public void irParaAreaAdministrativa(){
		aguardarCarregamentoPaginaInicial();
		menuInicial.click();
		aguardarElementoVisivel(menuInicialAdministrativo);
		menuInicialAdministrativo.click();
	}
	
	public void aguardarCarregamentoPaginaInicial(){
		aguardarElementoVisivel(menuItensRecentes);
	}

}

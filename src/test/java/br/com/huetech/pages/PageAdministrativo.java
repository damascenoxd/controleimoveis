package br.com.huetech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;

public class PageAdministrativo extends PagePodio<PageAdministrativo> {

	public PageAdministrativo() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	@FindBy(css = ".image-container")
	WebElement menuInicialAdministrativo;
	
	@FindBy(xpath = ".//*[@id='space-navigation']/div/ul/li[2]/a/span[1]")
	WebElement appImoveis;
	
	@FindBy(xpath = ".//*[@id='space-navigation']/div/ul/li[3]/a/span[1]")
	WebElement appClientes;
	
	@FindBy(xpath = ".//*[@id='space-navigation']/div/ul/li[4]/a/span[1]")
	WebElement appAtendimentos;
	
	@FindBy(xpath = ".//*[@id='space-navigation']/div/ul/li[5/a/span[1]")
	WebElement appVendas;
	
	@FindBy(xpath = ".//*[@id='space-navigation']/div/ul/li[6]/a/span[1]")
	WebElement appVisitas;
	
	
	public void irParaGestaoDeImoveis(){
		aguardarCarregamentoPaginaAdministrativo();
		appImoveis.click();
	}
	
	public void aguardarCarregamentoPaginaAdministrativo(){
		aguardarElementoVisivel(menuInicialAdministrativo);
	}
	

}

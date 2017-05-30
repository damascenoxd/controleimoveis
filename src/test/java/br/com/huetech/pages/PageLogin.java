package br.com.huetech.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Property;
import br.com.huetech.common.Selenium;



/*
 * Executa todas as acoes na pagina formulario simples
 */
public class PageLogin extends PagePodio<PageLogin> {

	public PageLogin(){
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	@FindBy(id = "email")
	WebElement campoEmail;
	
	@FindBy(id = "password")
	WebElement campoSenha;
	
	@FindBy(css = ".login-form-component__button")
	WebElement botaoConectar;
	
	@FindBy(id= "remember_me")
	WebElement checkLembrar;
	
	public void fazerLoginPodio(){
		abrirPaginaPodio(PageLogin.class);
		aguardarElementoVisivel(checkLembrar);
		preencherCampo(campoEmail, Property.LOGIN);
		preencherCampo(campoSenha, Property.PASSWORD);
		desmarcarCheckLembrar();
		botaoConectar.click();
	}
		
	public void desmarcarCheckLembrar(){
		if (checkLembrar.isSelected()) {
			checkLembrar.click();
		}
	}
}
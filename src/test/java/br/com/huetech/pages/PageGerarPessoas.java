package br.com.huetech.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;
import br.com.huetech.util.Utils;

public class PageGerarPessoas extends PageObjectGeneric<PageGerarPessoas> {

	public PageGerarPessoas() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	/*
	 * TODO MAPEAR CAPTURA DOS DADOS DE PESSOA
	 */
	
	@FindBy(id = "bt_gerar_pessoa")
	WebElement botaoGerarPessoa;
	
	public List<String>  gerarPessoa(){
		
		List<String> dados = new ArrayList<String>();
		
		aguardarElementoVisivel(botaoGerarPessoa);
		botaoGerarPessoa.click();
		Utils.wait(2000);
		
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
		dados.add(0, botaoGerarPessoa.getText());
				//index 2 = estadoCivil
				//index 3 = profissao
				//index 6 = rendaBruta
				//index 7 = dataCadastro
				//index 11 = referencia
				//index 13 = complemento
				//index 16 = operadora
		return dados;
	}
}

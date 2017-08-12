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
	
	@FindBy(id = "idade")
	WebElement comboIdadde;
	
	@FindBy(id = "cep_estado")
	WebElement comboEstado;
	
	@FindBy(id = "cep_cidade")
	WebElement comboCidade;
	
	@FindBy(id = "bt_gerar_pessoa")
	WebElement botaoGerarPessoa;
	
	@FindBy(id = "nome")
	WebElement nome;
	
	@FindBy(id = "cpf")
	WebElement CPF;
	
	@FindBy(id = "rg")
	WebElement RG;
	
	@FindBy(id = "data_nasc")
	WebElement dataNacimento;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "cep")
	WebElement CEP;
	
	@FindBy(id = "endereco")
	WebElement endereco;
	
	@FindBy(id = "numero")
	WebElement numero;
	
	@FindBy(id = "bairoo")
	WebElement bairro;
	
	@FindBy(id = "cidade")
	WebElement cidade;
	
	@FindBy(id = "estado")
	WebElement estado;
	
	@FindBy(id = "celular")
	WebElement celular;
	
	public List<String>  gerarPessoa(){
		
		aguardarElementoVisivel(botaoGerarPessoa);

		Selenium.getDriver().navigate().to("http://www.4devs.com.br/gerador_de_pessoas");
		List<String> dados = new ArrayList<String>();
		
		selectElementByVisibleValue(comboIdadde, Utils.getNumeroStringEntreIntervalo(18, 80));
		selectElementByVisibleValue(comboEstado, "PB");
		Utils.wait(1000);
		selectElementByVisibleValue(comboCidade, "João Pessoa");
		botaoGerarPessoa.click();
		Utils.wait(3000);
		
		dados.add(5 , RG.getText());
		dados.add(4 , CPF.getText());
		dados.add(8 , CEP.getText());
		dados.add(0 , nome.getText());
		dados.add(13, bairro.getText());
		dados.add(11, numero.getText());
		dados.add(14, celular.getText());
		dados.add(9 , endereco.getText());
		dados.add(1 , dataNacimento.getText());
		dados.add(3 , Utils.getProfissao());
		dados.add(7 , Utils.getDataAtual());
		dados.add(15, Utils.getOperadora());
		dados.add(2 , Utils.getEstadoCivil());
		dados.add(6 , Utils.getNumeroStringEntreIntervalo(800, 20000));
		dados.add(10, "Ligue para mamãe.");
		dados.add(12, "Quando chegar, pode perguntar que todo mundo me conhece.");
		return dados;
	}
}

package br.com.huetech.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Property;
import br.com.huetech.common.Selenium;
import br.com.huetech.util.Log;
import br.com.huetech.util.Utils;

public class PageGerarPessoas extends PageObjectGeneric<PageGerarPessoas> {

	public PageGerarPessoas() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	By msgCarregandoCidades = By.xpath(".//*[@id='cep_cidade']/option[contains(text(),'Carregando cidades...')]");
	
	By msgGerandoPessoas = By.xpath(".//*[@id='area_resposta']/div/img[@src='imagens/loader.gif']");
	
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
	
	@FindBy(id = "bairro")
	WebElement bairro;
	
	@FindBy(id = "cidade")
	WebElement cidade;
	
	@FindBy(id = "estado")
	WebElement estado;
	
	@FindBy(id = "celular")
	WebElement celular;
	
	public List<String>  gerarPessoa(int registroAtual, int totalRegistros){

		if (registroAtual == 0) {
			String geraPessoas = "http://www.4devs.com.br/gerador_de_pessoas";
			Log.info("Navegando para: " + geraPessoas);
			Selenium.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
			Selenium.getDriver().navigate().to(geraPessoas);
			selectElementByVisibleValue(comboEstado, "PB");
			aguardarMensangemDesaparecer(msgCarregandoCidades, Utils.converteStringParaInt(Property.TEMPO_ESPERA));
			selectElementByVisibleText(comboCidade, "João Pessoa");
		}
		List<String> dados = new ArrayList<String>();

		String renda = Utils.getNumeroStringEntreIntervalo(800, 20000); 
		aguardarElementoVisivel(comboIdadde);
		selectElementByVisibleValue(comboIdadde, Utils.getNumeroStringEntreIntervalo(18, 80));
		botaoGerarPessoa.click();
		Log.info("Gerando dados...");
		aguardarMensangemDesaparecer(msgGerandoPessoas, Utils.converteStringParaInt(Property.TEMPO_ESPERA));
		
		Log.info("Capturando dados...");
		dados.add(0 , nome.getAttribute("value"));
		dados.add(1, celular.getAttribute("value"));
		dados.add(2, Utils.getOperadora());
		dados.add(3 , dataNacimento.getAttribute("value"));
		dados.add(4 , Utils.getEstadoCivil());
		dados.add(5 , Utils.getProfissao());
		dados.add(6 , CPF.getAttribute("value"));
		dados.add(7 , RG.getAttribute("value"));
		dados.add(8 , renda+",00");
		dados.add(9 , Utils.getDataAtual());
		dados.add(10 , CEP.getAttribute("value"));
		dados.add(11 , endereco.getAttribute("value"));
		dados.add(12, "Ligue pra mamãe.");
		dados.add(13, numero.getAttribute("value"));
		dados.add(14, "Quando chegar, pode perguntar que todo mundo me conhece.");
		dados.add(15, bairro.getAttribute("value"));
		
		if (registroAtual == (totalRegistros-1)) {
			Selenium.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"w");
			Selenium.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
		}
		return dados;
	}
}

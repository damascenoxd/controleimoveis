package br.com.huetech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;

public class PageAppImoveis extends PagePodio<PageAppImoveis> {

	public PageAppImoveis() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	@FindBy(xpath = ".//*[@id='wrapper']/section/section[2]/main/div/div[4]/table/thead/tr/th[@title='Imóvel']")
	WebElement colunaImovel;
	
	@FindBy(xpath = ".//*[@id='wrapper']/section/header/nav/a")
	WebElement botaoAdicionarImovel;
	
	@FindBy(xpath =".//*[@id='tipo-do-imovel']/div[1]/div[2]/div/div")
	WebElement campoTipoImovel;
	
	@FindBy(xpath =".//*[@id='cidade-2']/div[1]/div[2]/div/div")
	WebElement campoCidade;
	
	@FindBy(xpath =".//*[@id='relacionamento-2']/div[1]/div[2]/div/div")
	WebElement campoBairro;
	
	@FindBy(xpath =".//*[@id='modalidade']/div[1]/div[2]/div/ul/li[1]")
	WebElement modalidadeNovo;
	
	@FindBy(xpath =".//*[@id='modalidade']/div[1]/div[2]/div/ul/li[2]")
	WebElement modalidadeUsado;
	
	@FindBy(xpath =".//*[@id='modalidade']/div[1]/div[2]/div/ul/li[3]")
	WebElement modalidadeNaPlanta;
	
	@FindBy(xpath =".//*[@id='modalidade']/div[1]/div[2]/div/ul/li[4]")
	WebElement modalidadeEmConstrucao;
	
	@FindBy(xpath =".//*[@id='modalidade']/div[1]/div[2]/div/ul/li[5]")
	WebElement modalidadePronto;
	
	@FindBy(xpath =".//*[@id='modalidade']/div[1]/div[2]/div/ul/li[6]")
	WebElement modalidadePreLancamento;
	
	@FindBy(xpath =".//*[@id='modalidade']/div[1]/div[2]/div/ul/li[7]")
	WebElement modalidadeLancamento;
	
	@FindBy(xpath =".//*[@id='finalidade']/div[1]/div[2]/div/ul/li[1]")
	WebElement finalidadeResidencial;
	
	@FindBy(xpath =".//*[@id='finalidade']/div[1]/div[2]/div/ul/li[2]")
	WebElement finalidadeComercial;
	
	@FindBy(xpath =".//*[@id='finalidade']/div[1]/div[2]/div/ul/li[3]")
	WebElement finalidadeEmpresarial;
	
	@FindBy(xpath =".//*[@id='finalidade']/div[1]/div[2]/div/ul/li[4]")
	WebElement finalidadeIndustrial;
	
	@FindBy(xpath =".//*[@id='finalidade']/div[1]/div[2]/div/ul/li[5]")
	WebElement finalidadeMista;
	
	@FindBy(xpath =".//*[@id='titulo']/div[1]/div[2]/div/div")
	WebElement nomeEmpreendimento;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select")
	WebElement comboQuartos;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='1']")
	WebElement comboQuartos1;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='2']")
	WebElement comboQuartos2;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='3']")
	WebElement comboQuartos3;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='4']")
	WebElement comboQuartos4;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='5']")
	WebElement comboQuartos5;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='6']")
	WebElement comboQuartos1e2;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='7']")
	WebElement comboQuartos2e3;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='8']")
	WebElement comboQuartos3e4;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='9']")
	WebElement comboQuartos4e5;
	
	@FindBy(xpath =".//*[@id='quartos-3']/div[1]/div[2]/div/div/select/option[@value='10']")
	WebElement comboQuartosOutros;
	
	@FindBy(xpath =".//*[@id='suites']/div[1]/div[2]/div/div")
	WebElement campoSuite;
	
	@FindBy(xpath =".//*[@id='dce']/div[1]/div[2]/div/div")
	WebElement campoDCE;
	
	@FindBy(xpath =".//*[@id='dce']/div[1]/div[2]/div/div")
	WebElement vagasGaragem;
	
	@FindBy(xpath =".//*[@id='especificacao-do-imovel']/div[1]/div[2]/div/div")
	WebElement especificacaoImovel;
	
	@FindBy(xpath =".//*[@id='especificacao-do-emprrendimento']/div[1]/div[2]/div/div")
	WebElement especificacaoEmpreendimento;
	
	@FindBy(xpath =".//*[@id='tamanho-m2']/div[1]/div[2]/div/div")
	WebElement tamanhoM2;
	
	@FindBy(xpath =".//*[@id='valor-do-imovel']/div[1]/div[2]/div/div")
	WebElement valorImovel;
	
	@FindBy(xpath =".//*[@id='valor-m2']/div[1]/div[2]/div")
	WebElement valorM2;
	
	@FindBy(xpath =".//*[@id='condicoes-de-pagamento']/div[1]/div[2]/div/div")
	WebElement condicoesPagamento;
	
	@FindBy(xpath =".//*[@id='previsao-de-entrega']/div[1]/div[2]/div/div")
	WebElement previsaoEntrega;
	
	@FindBy(xpath =".//*[@id='endereco']/div[1]/div[2]/div/section/div/div[1]/input")
	WebElement campoEndereco;
	
	@FindBy(css =".button-new.cancel-item-create-button.silver")
	WebElement botaoCancelar;

	@FindBy(css =".button-new.save-item-button.green")
	WebElement botaoSalvarImovel;
	
	@FindBy(xpath =".left.icon-16.icon-16-arrow-down-white-large")
	WebElement botaoOpcoesDeSalvarImovel;
	
	@FindBy(xpath =".//*[@id='wrapper']/div[4]/div/ul/li[1]/span")
	WebElement botaoSalvarImovelCriarDuplicado;
	
	@FindBy(xpath =".//*[@id='wrapper']/div[4]/div/ul/li[2]/span")
	WebElement botaoSalvarImovelCriarOutro;
	
	public void irParaPaginaAdicionarImovel(){
		aguardarCarregamentoPaginaAppImoveis();
		botaoAdicionarImovel.click();
	}
	
	public void aguardarCarregamentoPaginaAppImoveis(){
		aguardarElementoVisivel(colunaImovel);
	}
	

}

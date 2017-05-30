package br.com.huetech.pages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;

public class PageAdicionarImoveis extends PagePodio<PageAdicionarImoveis> {

	public PageAdicionarImoveis() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	                
	@FindBy(xpath =".//*[@id='tipo-do-imovel']/div[1]/div[2]/div/div")
	WebElement campoTipoImovel;

	@FindBy(xpath =".//*[@id='tipo-do-imovel']/div[1]/div[2]/div/div[2]/ul/li/div/div[2]/input")
	WebElement campoTipoImovelHabilitado;
	                
	@FindBy(xpath =".//*[@id='tipo-do-imovel']/div[1]/div[2]/div[1]/div[2]/div/ul/li[2]/div/div[2]/div[1]/span/b")
	WebElement tipoImovelHabilitadoSelecionar;
	                
	@FindBy(xpath =".//*[@id='cidade-2']/div[1]/div[2]/div/div")
	WebElement campoCidade;
	
	@FindBy(xpath =".//*[@id='cidade-2']/div[1]/div[2]/div/div[2]/ul/li/div/div[2]/input")
	WebElement campoCidadeHabilitado;
	
	@FindBy(xpath =".//*[@id='cidade-2']/div[1]/div[2]/div/div[2]/div/ul/li[2]/div/div[2]/div[1]")
	WebElement campoCidadeSelecionar;
	
	@FindBy(xpath =".//*[@id='relacionamento-2']/div[1]/div[2]/div/div")
	WebElement campoBairro;
	
	@FindBy(xpath =".//*[@id='cidade-2']/div[1]/div[2]/div/div[2]/ul/li/div/div[2]/label")
	WebElement campoBairroHabilitado;
	
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
	WebElement campoNomeEmpreendimento;
	
	@FindBy(xpath =".//*[@id='titulo']/div[1]/div[2]/div/input")
	WebElement campoNomeEmpreendimentoHabilitado;
	
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
	
	@FindBy(xpath =".//*[@id='suites']/div[1]/div[2]/div/input")
	WebElement campoSuiteHabilitado;
	
	@FindBy(xpath =".//*[@id='dce']/div[1]/div[2]/div/div")
	WebElement campoDCE;
	
	@FindBy(xpath =".//*[@id='dce']/div[1]/div[2]/div/input")
	WebElement campoDCEhabilitado;
	
	@FindBy(xpath =".//*[@id='vagas-de-garagem']/div[1]/div[2]/div/div")
	WebElement campoVagasGaragem;
	
	@FindBy(xpath =".//*[@id='vagas-de-garagem']/div[1]/div[2]/div/input")
	WebElement campoVagasGaragemHabilitado;
	
	@FindBy(xpath =".//*[@id='especificacao-do-imovel']/div[1]/div[2]/div/div")
	WebElement campoEspecificacaoImovel;
	
	@FindBy(id ="tinymce")
	WebElement campoEspecificacaoImovelHabilitado;
	
	@FindBy(xpath =".//*[@id='especificacao-do-emprrendimento']/div[1]/div[2]/div/div")
	WebElement campoEspecificacaoEmpreendimento;
	
	@FindBy(id ="tinymce")
	WebElement campoEspecificacaoEmpreendimentoHabilitado;
	
	@FindBy(xpath =".//*[@id='tamanho-m2']/div[1]/div[2]/div/div")
	WebElement campoTamanhoM2;
	
	@FindBy(xpath =".//*[@id='tamanho-m2']/div[1]/div[2]/div/input")
	WebElement campoTamanhoM2Habilitado;
	
	@FindBy(xpath =".//*[@id='valor-do-imovel']/div[1]/div[2]/div/div")
	WebElement campoValorImovel;
	
	@FindBy(xpath =".//*[@id='valor-do-imovel']/div[1]/div[2]/div/div/div[2]/input")
	WebElement campoValorImovelHabilitado;
	
	@FindBy(xpath =".//*[@id='valor-m2']/div[1]/div[2]/div")
	WebElement campoValorM2;
	
	@FindBy(xpath =".//*[@id='condicoes-de-pagamento']/div[1]/div[2]/div/div")
	WebElement campoCondicoesPagamento;
	
	@FindBy(id =".//*[@id='tinymce']")
	WebElement campoCondicoesPagamentoHabilitado;
	
	@FindBy(xpath =".//*[@id='previsao-de-entrega']/div[1]/div[2]/div/div")
	WebElement campoPrevisaoEntrega;
	
	@FindBy(id =".//*[@id='tinymce']")
	WebElement campoPrevisaoEntregaHabilitado;
	
	@FindBy(xpath =".//*[@id='endereco']/div[1]/div[2]/div/section/div/div[1]/input")
	WebElement campoEndereco;
	
	@FindBy(xpath =".//*[@id='endereco']/div[1]/div[2]/div/section/div/div[1]/input")
	WebElement campoEnderecoHabilitado;
	
	@FindBy(css =".button-new.cancel-item-create-button.silver")
	WebElement botaoCancelar;

	@FindBy(css =".button-new.save-item-button.green")
	WebElement botaoSalvarImovel;
	
	@FindBy(css =".button-new.save-item-button.green")
	WebElement botaoOpcoesDeSalvarImovel;
	
	@FindBy(xpath =".//*[@id='wrapper']/div[5]/div/ul/li[1]/span")
	WebElement botaoSalvarImovelCriarDuplicado;
	
	@FindBy(xpath =".//*[@id='wrapper']/div[5]/div/ul/li[2]/span")
	WebElement botaoSalvarImovelCriarOutro;
	
	@FindBy(xpath =".//*[@id='tipo-do-imovel']/div[1]/div[2]/div[2]")
	WebElement tipoImovelRequerido;
	
	
	public void cadastroImovelIncompleto(){
		aguardarCarregamentoPaginaAdicionarImoveis();
		preencherCampoObrigatorio("tipo-do-imovel", campoTipoImovel, campoTipoImovelHabilitado, "Flat");
		preencherCampoObrigatorio("cidade-2", campoCidade, campoCidadeHabilitado, "João Pessoa");
		modalidadeNaPlanta.click();
		finalidadeMista.click();
//		preencherCampoClicando(campoNomeEmpreendimento, campoNomeEmpreendimentoHabilitado, "Lotes Água Fria");
//		preencherCampoClicando(campoEndereco, campoEnderecoHabilitado, "R. Diógenes Chianca");
		botaoSalvarImovel.click();		
		Assert.assertTrue("Mensagem de alerta não foi exibida!", isVisibility(tipoImovelRequerido));
	}
	
	public void cancelarCadastroImovel(){
		aguardarCarregamentoPaginaAdicionarImoveis();
		botaoCancelar.click();
	}
	
	public void aguardarCarregamentoPaginaAdicionarImoveis(){
		aguardarElementoVisivel(botaoSalvarImovel);
	}
	

}

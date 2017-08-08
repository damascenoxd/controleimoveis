package br.com.huetech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;


public class PageFormularioCliente extends PageObjectGeneric<PageFormularioCliente> {

	public PageFormularioCliente() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	private String rg;
	private String cpf;
	private String cep;
	private String rua;
	private String nome;
	private String renda;
	private String bairro;
	private String numero;
	private String telefone;
	private String operadora;
	private String profissao;
	private String referencia;
	private String estadoCivil;
	private String complemento;
	private String dataCadastro;
	private String dataNascimento;
	
	

	public PageFormularioCliente(String rg, String cpf, String cep, String rua,
			String nome, String renda, String bairro, String numero,
			String telefone, String operadora, String profissao,
			String referencia, String estadoCivil, String complemento,
			String dataCadastro, String dataNascimento) {
		super();
		this.rg 			= rg;
		this.cpf 			= cpf;
		this.cep 			= cep;
		this.rua 			= rua;
		this.nome 			= nome;
		this.renda 			= renda;
		this.bairro 		= bairro;
		this.numero 		= numero;
		this.telefone 		= telefone;
		this.operadora 		= operadora;
		this.profissao 		= profissao;
		this.referencia 	= referencia;
		this.estadoCivil 	= estadoCivil;
		this.complemento 	= complemento;
		this.dataCadastro   = dataCadastro;
		this.dataNascimento = dataNascimento;
	}

	@FindBy(id = "nome")
	WebElement campoNomeCliente;
	
	@FindBy(id = "dataAniversario")
	WebElement campoDataNascimento;
	
	@FindBy(id = "estadoCivil")
	WebElement campoEstadoCivil;
	
	@FindBy(id = "profissao")
	WebElement campoProfissao;
	
	@FindBy(id = "cpf")
	WebElement campoCPF;
	
	@FindBy(id = "rg")
	WebElement campoRG;
	
	@FindBy(id = "renda")
	WebElement campoRendaBruta;
	
	@FindBy(id = "dataCadastro")
	WebElement campoDataCadastro;
	
	@FindBy(id = "endereco.cep")
	WebElement campoCEP;
	
	@FindBy(id = "endereco.logradouro")
	WebElement campoRua;
	
	@FindBy(id = "endereco.pontoReferencia")
	WebElement campoReferencia;
	
	@FindBy(id = "endereco.numero")
	WebElement campoNumero;
	
	@FindBy(id = "endereco.complemento")
	WebElement campoComplemento;
	
	@FindBy(id = "endereco.bairro.id")
	WebElement comboBairro;
	
	@FindBy(id = "telefone.telefone")
	WebElement campoTelefone;
	
	@FindBy(id = "telefone.operadora")
	WebElement campoOperadora;
	
	public void preencherFormulárioCliente(){
		preencherCampo(campoNomeCliente, this.nome);
		preencherCampo(campoDataNascimento, this.dataNascimento);
		preencherCampo(campoEstadoCivil, this.estadoCivil);
		preencherCampo(campoProfissao, this.profissao);
		preencherCampo(campoCPF, this.cpf);
		preencherCampo(campoRG, this.rg);
		preencherCampo(campoRendaBruta, this.renda);
		preencherCampo(campoDataCadastro, this.dataCadastro);
		preencherCampo(campoCEP, this.cep);
		preencherCampo(campoRua, this.rua);
		preencherCampo(campoReferencia, this.referencia);
		preencherCampo(campoNumero, this.numero);
		preencherCampo(campoComplemento, this.complemento);
		preencherCampo(comboBairro, this.bairro);
		preencherCampo(campoTelefone, this.telefone);
		preencherCampo(campoOperadora, this.operadora);
	}
	
}

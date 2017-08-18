package br.com.huetech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Property;
import br.com.huetech.common.Selenium;
import br.com.huetech.util.ExcelUtils;
import br.com.huetech.util.Log;

public class PageFormularioCliente extends PageObjectGeneric<PageFormularioCliente> {

	public PageFormularioCliente() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	
	/*==============================================
	 * CAMPOS DA APLICAÇÃO DE CADASTRO DE CLIENTES	
	 */
	
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
	/*
	 * =======================================
	 */
	
	public void preencherFormulárioCliente(){
	
	}
	
	public void inserirDadosDoClienteNaPlanilha(String planilha, List<String> dados, int numeroDeRegistros){
		try {
			ExcelUtils.gravaRegistrosExcel(numeroDeRegistros, planilha, dados);
		} catch (Exception e) {
			Log.erro("Erro na gravação da planilha de dados!", e);
		}
	}
	
	public void lerArquivoXLS(String planilha){
		try {
			ExcelUtils.getArquivoExcel(planilha);
		} catch (Exception e1) {
			Log.erro("["+Property.PATH_ARQUIVO_TESTE + Property.ARQUIVO_TESTE_XLS+"] Diretorio nao encontrado!", e1);
		}
	}
}
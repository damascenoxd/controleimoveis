package br.com.huetech.pages;

import java.util.ArrayList;
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
	
	public void preencherFormulárioCliente(int qtdRegistros){
		List<String>     planilha  = lerPlanilha(qtdRegistros);
		List<WebElement> elementos = new ArrayList<>();
		
		for (int linha = planilha.size(); linha < planilha.size(); linha++) {
    		for (int coluna = 0; coluna < 16; coluna++) {
    			try {
    				preencherCampo(elementos.get(linha), planilha.get(coluna));
    			} catch (Exception e) {
    				Log.erro("Erro no preenchimento do valor ["+planilha.get(linha)+"], do elemeto["+elementos.get(coluna)+"]", e);
    			}
    		}
    	}
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
			Log.info("Buscando arquivo xls...");
			ExcelUtils.getArquivoExcel(planilha);
		} catch (Exception e1) {
			Log.erro("["+Property.PATH_ARQUIVO_TESTE + Property.ARQUIVO_TESTE_XLS+"] Diretorio nao encontrado!", e1);
		}
	}
	
	public List<String> lerPlanilha(int qtdRegistros){
		List<String> planilha = new ArrayList<>();
		try {
			planilha = ExcelUtils.varrerPlanilha(Property.PLANILHA_CLIENTE, qtdRegistros);
		} catch (Exception e) {
			return null;
		}
		return planilha;
	}
	
	public List<WebElement> elementosFormulario(){
		List<WebElement> elementos = new ArrayList<>();
		
		elementos.add(campoNomeCliente);
		elementos.add(campoTelefone);
		elementos.add(campoOperadora);
		elementos.add(campoDataNascimento);
		elementos.add(campoEstadoCivil);
		elementos.add(campoProfissao);
		elementos.add(campoCPF);
		elementos.add(campoRG);
		elementos.add(campoRendaBruta);
		elementos.add(campoDataCadastro);
		elementos.add(campoCEP);
		elementos.add(campoRua);
		elementos.add(campoReferencia);
		elementos.add(campoNumero);
		elementos.add(campoComplemento);
		elementos.add(comboBairro);
		return elementos;
	}
}

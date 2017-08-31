package br.com.huetech.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Selenium;
import br.com.huetech.util.ExcelUtils;
import br.com.huetech.util.Log;
import br.com.huetech.util.Utils;

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
	
	@FindBy(css = ".btn.btn-success[type='submit']")
	WebElement botaoSalvar;
	
	@FindBy(css = ".btn.btn-success")
	WebElement botaoNovoCliente;
	
	@FindBy(xpath = ".//*[@id='msg-session']/div/b")
	WebElement msgSucesso;
	
	@FindBy(xpath = "html/body/div[2]/div/div/div/h2")
	WebElement tituloAtualizarCliente;
	/*
	 * =======================================
	 */
	
	public void preencherFormularioCliente(){

		int              cont          = 1;
		int 			 linha         = 0;
		boolean          isRegistro    = true;
		String     		 valorCelula   = null;
		List<WebElement> elementos     = elementosFormulario();

		// VERIFICA SE PLANILHA CONTÉM REGISTROS
		try {
			isRegistro = ExcelUtils.isProximaLinha(linha); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		aguardarElementoVisivel(botaoSalvar);
		Log.info("Iniciando preenchimento do formulário cliente...");
		
		// VARRE A PLANILHA ENQUANTO HOUVER REGISTROS
		while (isRegistro){
    		for (int coluna = 0; coluna < elementos.size(); coluna++) {
    			try {
    				valorCelula = ExcelUtils.getDadosCelula(linha, coluna);
    				
    				Log.info("Inserindo o valor ["+valorCelula+"]");

    				if (coluna == (elementos.size()-1)) {
						selectElementByVisibleText(elementos.get(coluna), valorCelula);
					}else
						preencherCampo(elementos.get(coluna), valorCelula);
    			} catch (Exception e) {
    				Log.erro("Quantidade de registros inseridos ["+cont+"]");
    				Log.erro("Erro no preenchimento do valor ["+valorCelula+"], do elemento["+elementos.get(coluna)+"]", e);
    			}
    		}
    		botaoSalvar.click();
    		//TESTE DE FEEDBACK
    		Utils.assertEquals("CLIENTE CADASTRADO COM SUCESSO!", msgSucesso.getText());
    		linha++;
    		
    		// VERIFICA SE AINDA HÁ REGISTROS NA PLANILHA
    		try {
				isRegistro = ExcelUtils.isProximaLinha(linha);
				if (isRegistro) {
					botaoNovoCliente.click();
					aguardarElementoVisivel(elementos.get(elementos.size()-1));
				}
			} catch (Exception e) {
				Log.erro("Quantidade de registros inseridos ["+cont+"]");
				e.printStackTrace();
			} 
    	}
	}
	
	// GUARDA TODOS ELEMETOS DO FORMULÁRIO EM UMA LISTA
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
		elementos.add(campoCEP);
		elementos.add(campoRua);
		elementos.add(campoReferencia);
		elementos.add(campoNumero);
		elementos.add(campoComplemento);
		elementos.add(comboBairro);
		return elementos;
	}
	
	public String alterarNomeCliente(String cliente) {
		aguardarElementoVisivel(tituloAtualizarCliente);
		cliente = cliente+" TESTE EDICAO";
		preencherCampo(campoNomeCliente, cliente);
		botaoSalvar.click();
		aguardarElementoVisivel(msgSucesso);
		//TESTE DE FEEDBACK
		Utils.assertEquals("CLIENTE ATUALIZADO COM SUCESSO!", msgSucesso.getText());
		return cliente;
	}
	
	public void excecaoTituloAtualizarCliente(){
		aguardarElementoVisivel(tituloAtualizarCliente);
		if (!tituloAtualizarCliente.getText().equals("Atualizar Cliente")) {
			throw new RuntimeException();
		}
	}
}

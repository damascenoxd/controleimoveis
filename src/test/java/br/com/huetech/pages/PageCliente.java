package br.com.huetech.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.common.Property;
import br.com.huetech.common.Selenium;
import br.com.huetech.util.ExcelUtils;
import br.com.huetech.util.Log;
import br.com.huetech.util.Utils;

public class PageCliente extends PageObjectGeneric<PageCliente> {

	public PageCliente() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(css = ".caret")
	WebElement menu;
	
	@FindBy(xpath = ".//*[@id='menu']/ul/li/ul/li[1]/a")
	WebElement addCliente;
	
	@FindBy(xpath = ".//*[@id='menu']/ul/li/ul/li[2]/a")
	WebElement listCliente;
	
	@FindBy(xpath = "html/body/div[2]/div/div/div/h2")
	WebElement tituloCliente;
	
	public void adicionarNovoCliente(){
		aguardarElementoVisivel(menu);
		menu.click();
		aguardarElementoVisivel(addCliente);
		addCliente.click();
		Log.info("Direcionando para página de formulário de cliente...");
	}
	
	public void listarClientes(){
		aguardarElementoVisivel(menu);
		menu.click();
		aguardarElementoVisivel(listCliente);
		listCliente.click();
		Log.info("Direcionando para página listagem de cliente...");
	}
	
	public void excluirClientes(int qtdClientes){
		String path = "";
		List<String> clientes = selecionarClientes(qtdClientes);
		aguardarElementoVisivel(tituloCliente);
		
		for (int i = 0; i < clientes.size(); i++) {
			path = "html/body/div[2]/div/div/table/tbody/tr/td[contains(.,'"+clientes.get(i)+"')]//..//td/a[contains(.,'Excluir')]";
			try {
				WebElement excluirCliente = Selenium.getDriver().findElement(By.xpath(path));
				excluirCliente.click();
			} catch (Exception e) {
				Log.erro("Não foi possível encontrar o dado: ["+clientes.get(i)+"] na listagem de clientes");
			}
		}
	}
	
	public List<String> selecionarClientes(int qtdClientes){
		List<String> clientes = new ArrayList<>();
		String path = "";
		aguardarElementoVisivel(tituloCliente);
		
		for (int i = 0; i < qtdClientes; i++) {
			path = "html/body/div[2]/div/div/table/tbody/tr["+(i+1)+"]/td[1]";
			try {
				WebElement cliente = Selenium.getDriver().findElement(By.xpath(path));
				clientes.add(cliente.getText());
			} catch (Exception e) {
				Log.erro("Não foi possível capturar cliente da linha ["+(qtdClientes+1)+"] na listagem de clientes");
			}
		}
		return clientes;
	}
	
	public void validaDadosInseridos(){
		
		int 		 linha           = 0;
		int 		 cAtual          = 0;
		int 		 posicao         = 0;
		boolean      passou          = true;      
		boolean      achouDado       = false;
		boolean      isRegistro      = true;
		String       dadoTela        = "";
		String       dadoCelula      = "";
		List<String> dadosTela       = new ArrayList<>();
		
		// VERIFICA SE PLANILHA CONTÉM REGISTROS
		try {
			isRegistro = ExcelUtils.isProximaLinha(linha); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// VARRE A PLANILHA ENQUANTO HOUVER REGISTROS
		while (isRegistro){
			for (int coluna = 0; coluna <= 8; coluna++) {
				Log.info("Capturando listagem exibida na tela...");
				try {
					dadosTela  = listaDadosDeClientesNaTela(cAtual+1);
					dadoCelula = ExcelUtils.getDadosCelula(linha, coluna);

					/* VERIFICA SE EXITE ALGUM DADO NA COLUNA DA LISTAGEM DA TELA, 
					   IGUAL AO DA CELULA */
					if (coluna != 2){
						cAtual++;
						if (coluna == 0) {
							for (int i = 0; i < dadosTela.size(); i++) {
								if (dadoCelula.equals(dadosTela.get(i))){
									posicao = i;
									i = dadosTela.size();
									Log.info("Valor da celula ["+dadoCelula+"], encontrado na aplicacao");
									achouDado = true;
								}
							}
						}else{
							Log.info("Valor esperado (referencia)["+dadoCelula+"], valor exibido ["+dadoTela+"]");
							Utils.assertEquals(dadoCelula, dadosTela.get(posicao));
							achouDado = true;
						}
					}
					if (!achouDado){
						passou    = false;
						Log.info("Valor esperado ["+dadoCelula+"], nao encontrado na listagem");
					}
				} catch (Exception e) {
					Log.erro("Valor esperado (referencia)["+dadoCelula+"], valor exibido ["+dadoTela+"]",e);
				}
			}
			linha++;
			cAtual=0;
			
			// VERIFICA SE AINDA HÁ REGISTROS NA PLANILHA
			try {
				isRegistro = ExcelUtils.isProximaLinha(linha);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		Utils.assertTrue("E R R O -> verificar evidencias em: ["+Property.PATH_ARQUIVO_TESTE+"]", passou);
	}

	//	 GUARDA TODOS ELEMETOS DO FORMULÁRIO EM UMA LISTA
	public List<String> listaDadosDeClientesNaTela(int coluna){
		
		int linha = 1;
		List<String> dados = new ArrayList<>();
		By colunaDaTela = By.xpath("html/body/div[2]/div/div/table/tbody/tr["+linha+"]/td["+coluna+"]");
		
		while (isVisibility(colunaDaTela)) {
			WebElement textoColuna = Selenium.getDriver().findElement(colunaDaTela);
			dados.add(textoColuna.getText());
			linha++;
			colunaDaTela = By.xpath("html/body/div[2]/div/div/table/tbody/tr["+linha+"]/td["+coluna+"]");
		}
		return dados;
	}
}

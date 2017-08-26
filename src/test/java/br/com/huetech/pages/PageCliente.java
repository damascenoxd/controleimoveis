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
		
		int          i               = 0;
		int 		 linha           = 0;
		String       atual           = "";
		String       esperado        = "";
		boolean      passou          = true;      
		boolean      isRegistro      = true;
		List<String> dadosDaTela     = new ArrayList<>();
		
		// VERIFICA SE PLANILHA CONTÉM REGISTROS
		try {
			isRegistro = ExcelUtils.isProximaLinha(linha); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Log.info("Capturando dados no repositorio...");
		// VARRE A PLANILHA ENQUANTO HOUVER REGISTROS
		while (isRegistro){
			dadosDaTela = listagemDeClientesNaTela(linha+1);
			for (int coluna = 0; coluna < dadosDaTela.size(); coluna++) {
				try {
					if ((coluna != 2) && (!(coluna >= 9 && coluna <= 14))){
						esperado = ExcelUtils.getDadosCelula(linha, coluna);
						atual    = dadosDaTela.get(i);
						i++;
						Log.info("Valor esperado (referencia)["+esperado+"], valor exibido ["+atual+"]");
						if (!esperado.equals(atual)) {
							passou = false;
							Log.erro("E R R O -> Valores Divergentes");
							Utils.takeScreenshot("["+atual+"] nao exibido");
						}
					}
				} catch (Exception e) {
					Log.erro("Valor esperado (referencia)["+esperado+"], valor exibido ["+atual+"]",e);
				}
			}
			linha++;
			i=0;
			
			// VERIFICA SE AINDA HÁ REGISTROS NA PLANILHA
			try {
				isRegistro = ExcelUtils.isProximaLinha(linha);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		Utils.assertTrue("E R R O -> verificar evidencias em: ["+Property.PATH_ARQUIVO_TESTE+"]", passou);
	}
	// GUARDA TODOS ELEMETOS DO FORMULÁRIO EM UMA LISTA
	public List<String> listagemDeClientesNaTela(int linha){
		Log.info("Capturando dados exibidos na tela...");
		List<String> dados = new ArrayList<>();
		String       path  = "";
		
		for (int i = 1; i <= 8; i++) {
			path               = "html/body/div[2]/div/div/table/tbody/tr["+linha+"]/td["+i+"]";
			WebElement element = Selenium.getDriver().findElement(By.xpath(path));
			dados.add(element.getText());
		}
		return dados;
	}
}
package br.com.huetech.test.imoveis;

import org.junit.After;
import org.junit.Test;

import br.com.huetech.common.Selenium;
import br.com.huetech.pages.PageInicial;
import br.com.huetech.test.BaseTestCase;

/**
 * 
 * Classe de testes com cen�ios relacionados a gest�o de im�veis
 * @author Jarbas
 * 
 * */
public class TestCadastroImoveisIT extends BaseTestCase {

	
	PageInicial          pageInicial          = new PageInicial();

	/**
	 * HUE-1:
	 * 
	 * OBJETIVO:
	 * 
	 * 
	 * PRÉ-CONDI�OES: 
	 * 			
	 * 
	 * RESULTADO ESPERADO: 
	 * 
	 */

	@Test
	public void verificaMsgTipoDuvidaIdadeMenorQue18(){
		pageInicial.irParaPaginaContato();
	}
	
	@Test
	public void fecharDriver(){
		
	}
}

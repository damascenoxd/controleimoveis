package br.com.huetech.test.imoveis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.huetech.common.Selenium;
import br.com.huetech.pages.PageInicial;
import br.com.huetech.pages.PageLogin;
import br.com.huetech.test.BaseTestCase;

/**
 * 
 * Classe de testes com cen�ios relacionados a gest�o de im�veis
 * @author Jarbas
 * 
 * */
public class TestCadastroImoveisIT extends BaseTestCase {

	
	PageLogin            pageLogin            = new PageLogin();
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
	public void test(){
		
	}
	@Before
	public void fazerLogin(){
		pageLogin.fazerLoginPodio();
		pageInicial.irParaAreaAdministrativa();
	}
	
	@After
	public void fecharDriver(){
		Selenium.getDriver().close();
	}
}

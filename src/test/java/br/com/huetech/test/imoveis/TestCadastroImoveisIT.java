package br.com.huetech.test.imoveis;

import org.junit.Test;

import br.com.huetech.pages.PageCliente;
import br.com.huetech.pages.PageFormularioCliente;
import br.com.huetech.test.BaseTestCase;

/**
 * 
 * Classe de testes com cen�ios relacionados a gest�o de im�veis
 * @author Jarbas
 * 
 * */
public class TestCadastroImoveisIT extends BaseTestCase {

	
	PageCliente           pageCliente 			= new PageCliente();
	PageFormularioCliente pageFormularioCliente = new PageFormularioCliente();
	
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
		pageCliente.adicionarCliente();
	}
}

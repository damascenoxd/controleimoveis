package br.com.huetech.test.imoveis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.huetech.common.Selenium;
import br.com.huetech.pages.PageAdicionarImoveis;
import br.com.huetech.pages.PageAdministrativo;
import br.com.huetech.pages.PageAppImoveis;
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
	PageAppImoveis       pageAppImoveis       = new PageAppImoveis();
	PageAdministrativo   pageAdministrativo   = new PageAdministrativo();
	PageAdicionarImoveis pageAdicionarImoveis = new PageAdicionarImoveis();
	

	/**
	 * HUE-2:Cancelar cadastro de im�vel durante inser��o dos dados
	 * 
	 * OBJETIVO:
	 * 
	 * 				Garantir o comportamento correto do sistema quando um usu�rio faz o procedimento 
	 * 				de cadastro de um im�vel e Cancela o cadastro no fim do procedimento.
	 * 
	 * PR�-CONDI�OES: 
	 * 			
	 * 				- Usu�rio com permiss�o de realizar cadastro de im�veis no Podio;
	 * 				- Usu�rio logado no sistema.
	 * 
	 * RESULTADO ESPERADO: 
	 * 
	 * 				Sistema deve retornar a tela anterior e N�O deve exibir na listagem im�veis, 
	 * 				o im�vel cancelado.
	 */
	
	@Test
	public void cancelarCadastroImovel() {
		pageAdministrativo.irParaGestaoDeImoveis();
		pageAppImoveis.irParaPaginaAdicionarImovel();
		pageAdicionarImoveis.cancelarCadastroImovel();
	}
	
	/**
	 * HUE-4:Impedir cadastro de im�veis sem o preenchimento correto de todos campos obrigat�rios - Com Sucesso
	 * 
	 * OBJETIVO:
	 * 
	 * 				Garantir ao usu�rio que o cadastro de im�veis s� ser� realizado com sucesso, se houver o 
	 * 				preenchimento correto de todos os campos obrigat�rios.
	 * 
	 * PR�-CONDI�OES: 
	 * 			
	 * 				- Usu�rio com permiss�o de realizar cadastro de im�veis no Podio;
	 * 				- Usu�rio logado no sistema.
	 * 
	 * RESULTADO ESPERADO: 
	 * 
	 * 				Sistema deve exibir o alerta de corre��o em vermelho nos campos:
	 *					- Tipo do im�vel;
	 *					- Bairro.
	 *				E n�o deve realizar o cadastro do im�vel.
	 */
	
	@Test
	public void verificaObrigatoriedadeCamposCadsastroImoveis() {
		pageAdministrativo.irParaGestaoDeImoveis();
		pageAppImoveis.irParaPaginaAdicionarImovel();
		pageAdicionarImoveis.cadastroImovelIncompleto();
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

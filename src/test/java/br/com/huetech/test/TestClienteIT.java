package br.com.huetech.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.huetech.common.Property;
import br.com.huetech.pages.PageCliente;
import br.com.huetech.pages.PageFormularioCliente;
import br.com.huetech.pages.PageGerarPessoas;
import br.com.huetech.test.configuration.BaseTestCase;
import br.com.huetech.util.ExcelUtils;
import br.com.huetech.util.Log;
import br.com.huetech.util.Utils;

/**
 * 
 * Classe de testes com cenários relacionados ao cadastro de imóveis
 * @author Jarbas
 * 
 * */
public class TestClienteIT extends BaseTestCase {

	private String           nomeTeste             = null;
	PageCliente              pageCliente           = new PageCliente();
	PageGerarPessoas         pageGeraPessoas       = new PageGerarPessoas();
	PageFormularioCliente    pageFormularioCliente = new PageFormularioCliente();
	
	@Before
	public void lerArquivoXLS() throws Exception{
		ExcelUtils.getArquivoExcel(Property.PLANILHA_CLIENTE);
	}
	
	/*
	 * TESTES DE SUCESSO
	 * 
	 * ===============================================================
	 */
	
	/*
	 * O TESTE ABAIXO TAMBÉM SERVE PARA TESTE DE PERFORMANCE.
	 * A DIFERENÇA ESTÁ NA PROPRIEDADE ESCOLHIDA
	 * "xls.teste=Pasta1.xls" -> PARA POUCOS REGISTROS
	 * "xls.teste=carga.xls"  -> COM MAIS DE 100 REGISTROS 
	 * 
	 */
	@Test
	public void adicionarClientesComSucesso() {
		nomeTeste = "adicionarClientesComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.adicionarNovoCliente();
		pageFormularioCliente.preencherFormularioCliente();
		pageCliente.validaDadosMassa_X_Aplicacao();
	}
	
	@Test
	public void pesquisarClienteComSucesso() {
		nomeTeste = "pesquisarClienteComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.listarClientes();
		pageCliente.validaDadosMassa_X_Aplicacao();
	}
	
	@Test
	public void atualizarClienteComSucesso() {
		nomeTeste = "atualizarClienteComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.listarClientes();
		String dadoAnterior = pageCliente.atualizarCliente();
		String dadoAtual    = pageFormularioCliente.alterarNomeCliente(dadoAnterior);
		pageCliente.listarClientes();
		Utils.assertTrue("Dado nao foi atualizado corretamente", pageCliente.validaAtualizacaoCliente(dadoAtual));
	}
	
	@Test
	public void excluirClienteComSucesso() {
		nomeTeste = "excluirClienteComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.listarClientes();
		String clienteExcluido = pageCliente.excluirCliente();
		Utils.assertTrue("Nome de cliente excluido esta sendo exibido na listagem", pageCliente.validaExclusaoCliente(clienteExcluido));
	}
	/*
	 * =============================================================== 
	 */
	
	
	
	/*
	 * TESTES DE EXCECAO
	 * 
	 * ===============================================================
	 */
	@Test(expected=RuntimeException.class)
	public void verificaExcecaoTituloAtualizarCliente() {
		nomeTeste = "adicionarClientesComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.listarClientes();
		pageCliente.atualizarCliente();
		pageFormularioCliente.excecaoTituloAtualizarCliente();
	}
	
	@Test(expected=RuntimeException.class)
	public void verificaMsgExclusaoCliente() {
		nomeTeste = "adicionarClientesComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.listarClientes();
		pageFormularioCliente.excecaoTituloAtualizarCliente();
	}
	/*
	 * ===============================================================
	 */
	
	@After
	public void fechaArquivoExcel(){
		Log.msgFimTeste(nomeTeste);
	}
}

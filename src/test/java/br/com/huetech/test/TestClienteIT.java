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
	
	@Test
	public void preencherFormularioComSucesso() {
		nomeTeste = "preencherFormularioComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.adicionarNovoCliente();
		pageFormularioCliente.preencherFormularioCliente();
		pageCliente.validaDadosInseridos();
	}
	
	@Test
	public void pesquisarClientesComSucesso() {
		nomeTeste = "pesquisarClientesComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.listarClientes();
		pageCliente.excluirClientes(20);
	}
	
	@Test
	public void excluirClientesComSucesso() {
		nomeTeste = "excluirClientesComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageCliente.listarClientes();
		pageCliente.excluirClientes(20);
	}
	
	@After
	public void fechaArquivoExcel(){
		Log.msgFimTeste(nomeTeste);
	}
}

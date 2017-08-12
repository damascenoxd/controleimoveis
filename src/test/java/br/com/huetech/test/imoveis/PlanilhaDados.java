package br.com.huetech.test.imoveis;

import org.junit.Test;

import br.com.huetech.pages.PageCliente;
import br.com.huetech.pages.PageFormularioCliente;
import br.com.huetech.pages.PageGerarPessoas;
import br.com.huetech.test.BaseTestCase;


public class PlanilhaDados extends BaseTestCase{

	PageCliente           pageCliente           = new PageCliente();
	PageGerarPessoas      pageGeraPessoas       = new PageGerarPessoas();
	PageFormularioCliente pageFormularioCliente = new PageFormularioCliente(); 
	
	@Test
	public void criarPlanilhaCliente() {
		int qtdRegistros = 3;
		pageFormularioCliente.criarPlanilhaDadosCliente(qtdRegistros, pageGeraPessoas.gerarPessoa());
	}
	
}
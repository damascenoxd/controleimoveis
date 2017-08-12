package br.com.huetech.test.imoveis;

import org.junit.Test;

import br.com.huetech.pages.PageCliente;
import br.com.huetech.pages.PageFormularioCliente;
import br.com.huetech.pages.PageGerarPessoas;
import br.com.huetech.test.BaseTestCase;


public class MassaDadosIT extends BaseTestCase{

	PageCliente              pageCliente           = new PageCliente();
	PageGerarPessoas         pageGeraPessoas       = new PageGerarPessoas();
	PageFormularioCliente    pageFormularioCliente = new PageFormularioCliente();
	private final static int NUMERO_DE_REGISTROS   = 3;
	
	@Test
	public void criarPlanilhaCliente() {
		pageFormularioCliente.criarPlanilhaDadosCliente(NUMERO_DE_REGISTROS, pageGeraPessoas.gerarPessoa());
	}
	
}
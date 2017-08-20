package br.com.huetech.test.imoveis;

import org.junit.Test;

import br.com.huetech.common.Property;
import br.com.huetech.pages.PageCliente;
import br.com.huetech.pages.PageFormularioCliente;
import br.com.huetech.pages.PageGerarPessoas;
import br.com.huetech.test.BaseTestCase;


public class MassaDadosIT extends BaseTestCase{

	PageCliente              pageCliente           = new PageCliente();
	PageGerarPessoas         pageGeraPessoas       = new PageGerarPessoas();
	PageFormularioCliente    pageFormularioCliente = new PageFormularioCliente();
	private final static int NUMERO_DE_REGISTROS   = 20;
	
	@Test
	public void criarPlanilhaCliente() {
		
		pageFormularioCliente.lerArquivoXLS(Property.PLANILHA_CLIENTE);
		for (int i = 0; i < NUMERO_DE_REGISTROS; i++) {
			pageFormularioCliente.inserirDadosDoClienteNaPlanilha(Property.PLANILHA_CLIENTE, pageGeraPessoas.gerarPessoa(i, NUMERO_DE_REGISTROS), i);
		}
	}
	
	@Test
	public void preencherFormularioComSucesso() {
		
		pageFormularioCliente.preencherFormulárioCliente(NUMERO_DE_REGISTROS);
	}
	
}
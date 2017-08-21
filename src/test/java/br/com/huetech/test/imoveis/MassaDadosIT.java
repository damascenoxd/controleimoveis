package br.com.huetech.test.imoveis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.huetech.common.Property;
import br.com.huetech.pages.PageGerarPessoas;
import br.com.huetech.test.BaseTestCase;
import br.com.huetech.util.ExcelUtils;
import br.com.huetech.util.Log;


public class MassaDadosIT extends BaseTestCase{

	private String           nomeTeste             = null;
	PageGerarPessoas         pageGeraPessoas       = new PageGerarPessoas();
	private final static int NUMERO_DE_REGISTROS   = 20;
	
	@Before
	public void lerArquivoXLS() throws Exception{
		ExcelUtils.getArquivoExcel(Property.PLANILHA_CLIENTE);
	}
	
	@Test
	public void criarPlanilhaCliente() {
		nomeTeste = "Criar Planilha de Dados [Cliente]";
		Log.msgInicioTeste(nomeTeste);	
		pageGeraPessoas.popularPlanilhaCliente(NUMERO_DE_REGISTROS);
	}
	
	@After
	public void fechaArquivoExcel() throws Exception{
		ExcelUtils.fecharArquivo();
		Log.msgFimTeste(nomeTeste);
	}
}
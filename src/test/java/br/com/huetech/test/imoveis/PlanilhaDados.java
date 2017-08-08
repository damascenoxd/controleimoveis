package br.com.huetech.test.imoveis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.huetech.pages.PageCliente;
import br.com.huetech.pages.PageFormularioCliente;
import br.com.huetech.test.BaseTestCase;
import br.com.huetech.util.SpreadsheetData;

@RunWith(value = Parameterized.class)
public class PlanilhaDados extends BaseTestCase{

	PageCliente           pageCliente           = new PageCliente();
	PageFormularioCliente pageFormularioCliente = new PageFormularioCliente(); 
	
	@Test
	public void teste(){
		pageCliente.adicionarCliente();
		pageFormularioCliente.preencherFormulárioCliente();
	}
	
	@Parameters
	public static Collection planilhaDados() throws IOException {
		InputStream planilha = new FileInputStream("src\\test\\resources\\Pasta1.xls");
		return new SpreadsheetData(planilha).getData();
	}
	
}

package br.com.huetech.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import br.com.huetech.common.Property;

public class ExcelUtils {

	private static 		 HSSFRow 	  linha;
	private static 		 HSSFCell 	  celula;
	private static 		 HSSFSheet 	  planilha;
	private static 		 HSSFWorkbook excelWBook;
	private static final String       ARQUIVO_TESTE 	 = Property.ARQUIVO_TESTE_XLS;
	private static final String       PATH_ARQUIVO_TESTE = Property.PATH_ARQUIVO_TESTE;

	//Busca o caminho e abre o arquivo excel
	public static void getArquivoExcel(String nomePlanilha)throws Exception {
		
		try {
			// Abre arquivo excel
			FileInputStream arquivoXls = new FileInputStream(PATH_ARQUIVO_TESTE + ARQUIVO_TESTE);
			excelWBook = new HSSFWorkbook(arquivoXls);
		} catch (Exception e) {
			Log.erro("["+ARQUIVO_TESTE+"] Diretorio nao encontrado!", e);
		}
		
		try {
			// Define a planilha do arqruivo que será utilizada no teste
			planilha = excelWBook.getSheet(nomePlanilha);
		} catch (Exception e) {
			Log.erro("["+nomePlanilha+"] Planilha não encontrada no arquivo", e);
		}
	}
	
	//Realiza a leitura das células
    public static String getDadosCelula(int numeroLinha, int numeroColuna) throws Exception{
		try{
  			celula = planilha.getRow(numeroLinha).getCell(numeroColuna);
  			String valorCelula = celula.getStringCellValue();
  			return valorCelula;
  		}catch (Exception e){
  			Log.erro("Erro no diretório na captura da celula", e);
			return"";
  		}
    }
    
    //Realiza a escrita nas células
    public static void setDadosCelula(String dados,  int numeroLinha, int numeroColuna) throws Exception {

		try{
			linha  = planilha.getRow(0);
			celula = linha.createCell(1);
			if (celula == null) {
				celula = linha.createCell(numeroColuna);
				celula.setCellValue(dados);
			} else {
				celula.setCellValue(dados);
			}
		}catch(Exception e){
			Log.erro("Erro na inserção do valor ["+dados+"]", e);
		}
    }
    
    // Grava os registro no arquivo excel
    public static void gravaRegistrosExcel(int qtdRegistros, String planilha, List<String> dados) throws Exception{
    	FileOutputStream fileOut = new FileOutputStream(PATH_ARQUIVO_TESTE + ARQUIVO_TESTE);
    	int qtdColunas = 0;
    	
    	switch (planilha) {
		case "cliente":
			qtdColunas = 15;
			break;

		default:
			break;
		}
    	
    	for (int linha = 0; linha < qtdRegistros; linha++) {

			for (int coluna = 0; coluna < qtdColunas; coluna++) {
				try {
					setDadosCelula(dados.get(linha), linha, coluna);
					excelWBook.write(fileOut);
				} catch (Exception e) {
					Log.erro("Erro na inserção do valor ["+dados.get(linha)+"]", e);
				}
			}
    	}
		fileOut.flush();
		fileOut.close();
    }
}


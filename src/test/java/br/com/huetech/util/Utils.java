package br.com.huetech.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.huetech.common.Selenium;

/**
 * Classe com m�todos de apoio, que otimizam a codifica��o das classes de
 * p�gina.
 * 
 * @author jarbas.junior
 *
 */
public abstract class Utils {

	private static final WebDriver     driver;
	private static final WebDriverWait driverWait;

	static {
		driver = Selenium.getDriver();
		driverWait = new WebDriverWait(driver, 10);
	}

	public static void isVisible(By locator) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void isVisible(String id) {
		isVisible(By.id(id));
	}

	public static void isLocated(By locator) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void isLocated(String id) {
		isLocated(By.id(id));
	}

	public static void isClickable(WebElement element) {
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void wait(final int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void assertEquals(Object esperado, Object atual) {
		try {
			Assert.assertEquals(esperado, atual);
		} catch (Exception e) {
			assertFail("Erro encontrado: Esperado ["+esperado+"], mas retornou ["+atual+"]");
		}
	}
	
	public static void assertTrue(String message, boolean bol){
		Assert.assertTrue(message, bol);
	}
	
	public static void assertFail(String message) {
		Assert.fail(message);
	}
	
	public static String conversorDoubleString(double valor){
		DecimalFormat df = new DecimalFormat("#,###.00");  
		String novoValor = df.format(valor);
		return novoValor;
	}
	
	public static Double conversorStringDouble(String valorString){
		String valorDouble = valorString.replace(",", "");
		return Double.valueOf(valorDouble);
	} 
	
	public static String converterValoresFloatToString(Float value) {
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		return nf.format(value).replace(",","");
	}
	
	public static int geraNumeroEntreIntervalo(int min, int max){
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public static String getNumeroStringEntreIntervalo(int min, int max){
		return converteInteiroParaString(geraNumeroEntreIntervalo(min, max));
	}
	
	public static String converteInteiroParaString(int numero){
		return Integer.toString(numero);
	}
	
	public static int converteStringParaInt(String str){
		return Integer.parseInt(str);
	}

	/*
	 * TODO GERAR DADOS FICTÍCIOS PARA CLIENTES
	 */
	public static String getEstadoCivil(){
		List<String> estadoCivil = new ArrayList<String>();
		estadoCivil.add("Solteiro");
		estadoCivil.add("Casado");
		estadoCivil.add("Viúvo");
		estadoCivil.add("Divorciado");
		estadoCivil.add("Outros");
		
		List<String> sorteio = new ArrayList<String>(estadoCivil);
		String sorteado = sorteio.remove((int) (Math.random() * sorteio.size()));
		return sorteado;
	}
	
	public static String getProfissao(){
		List<String> profissoes = new ArrayList<String>();
		profissoes.add("Administrador");
		profissoes.add("Advogado");
		profissoes.add("Pedagogo");
		profissoes.add("Contador");
		profissoes.add("Engenheiro");
		profissoes.add("Enfermeiro");
		profissoes.add("Psicólogo");
		profissoes.add("Bombeiro");
		profissoes.add("Analista de sistemas");
		profissoes.add("Odontologista");
		profissoes.add("Fonoaudilógo");
		
		List<String> sorteio = new ArrayList<String>(profissoes);
		String sorteado = sorteio.remove((int) (Math.random() * sorteio.size()));
		return sorteado;
	}
	public static String getDataAtual(){
		return null;
	}
	public static String getOperadora(){
		List<String> operadora = new ArrayList<String>();
		operadora.add("Oi");
		operadora.add("Tim");
		operadora.add("Claro");
		operadora.add("Vivo");
		
		List<String> sorteio = new ArrayList<String>(operadora);
		String sorteado = sorteio.remove((int) (Math.random() * sorteio.size()));
		return sorteado;
	}
	
	/**
	 * M�todo para capturar screenshot
	 * @param fileName - Nome do arquivo
	 */
//	public static void takeScreenshot(String fileName){
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		Date data = new Date();
//	    try {
//			FileUtils.copyFile(scrFile, new File("C:\\Users\\Jarbas\\Desktop\\"+fileName+ data.getTime()+".jpeg"),true);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void calculaTempoDoTest(Date tempoInicio, Date tempoFinal) {
//		long diferencaSegundos = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000);
//		long diferencaMinutos = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000 * 60);
//		long diferencaHoras = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000 * 60 * 60);
//		Log.info("Tempo de execu��o:"+ String.format("%02d:%02d:%02d ", diferencaHoras, diferencaMinutos, diferencaSegundos));
//	}
}
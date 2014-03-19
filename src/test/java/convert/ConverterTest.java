package convert;

import static junit.framework.Assert.assertEquals;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import support.FileSupport;

import detector.Detector;

public class ConverterTest {
	String testFile = FileSupport.getDirectory() + "/novoArquivo.txt";
	
	@After
	public void apagaArquivo() {
		File file = new File(testFile);
		file.delete();
	}
	
	@Test
	public void naoAlteraArquivoUTF8() {
		String resposta = Converter.execute("src/test/resources/outros/UTF-8.txt");
		
		assertEquals("src/test/resources/outros/UTF-8.txt", resposta);
	}
	
	@Test
	public void criaArquivoUTF8() {
		Converter.execute("src/test/resources/outros/UTF-16LE.txt");
		
		String resultado = Detector.execute(testFile);
		
		Assert.assertEquals("UTF-8", resultado);
	}
	
	@Test
	public void criaArquivoUTF8comWINDOWS1252() {
		Converter.execute("src/test/resources/outros/WINDOWS-1252.txt");
		
		String resultado = Detector.execute(testFile);
		
		Assert.assertEquals("UTF-8", resultado);
	}
}

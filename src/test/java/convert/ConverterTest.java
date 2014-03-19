package convert;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import junit.framework.Assert;

import org.junit.Test;

import detector.Detector;

public class ConverterTest {
	
	@Test
	public void naoAlteraArquivoUTF8() {
		String resposta = Converter.execute("src/test/resources/outros/UTF-8.txt");
		
		assertEquals("src/test/resources/outros/UTF-8.txt", resposta);
	}
	
	@Test
	public void criaArquivoUTF8() {
		Converter.execute("src/test/resources/outros/UTF-16LE.txt");
		
		String resultado = Detector.execute("target/novoArquivo.txt");
		
		Assert.assertEquals("UTF-8", resultado);
	}
	
	@Test
	public void criaArquivoUTF8comWINDOWS1252() {
		Converter.execute("src/test/resources/outros/WINDOWS-1252.txt");
		
		String resultado = Detector.execute("target/novoArquivo.txt");
		
		Assert.assertEquals("UTF-8", resultado);
	}

}

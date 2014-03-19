package convert;

import static junit.framework.Assert.assertEquals;
import java.io.File;
import junit.framework.Assert;
import org.junit.Test;
import detector.Detector;

public class ConverterTest {
	
	@Test
	public void naoAlteraArquivoUTF8() {
		Converter converter = new Converter("src/test/resources/outros/UTF-8.txt");
		String resposta = converter.execute();
		
		assertEquals("src/test/resources/outros/UTF-8.txt", resposta);
		apagaArquivo(converter);
	}
	
	@Test
	public void criaArquivoUTF8() {
		Converter converter = new Converter("src/test/resources/outros/UTF-16LE.txt");
		converter.execute();
		
		String resultado = Detector.execute(converter.getNewFileName());
		Assert.assertEquals("UTF-8", resultado);
		
		apagaArquivo(converter);
	}
	
	@Test
	public void criaArquivoUTF8comWINDOWS1252() {
		Converter converter = new Converter("src/test/resources/outros/WINDOWS-1252.txt");
		converter.execute();
		
		String resultado = Detector.execute(converter.getNewFileName());
		Assert.assertEquals("UTF-8", resultado);
		
		apagaArquivo(converter);
	}
	
	public void apagaArquivo(Converter converter) {
		File file = new File(converter.getNewFileName());
		file.delete();
	}
}

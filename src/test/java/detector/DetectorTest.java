package detector;

import junit.framework.Assert;

import org.junit.Test;

public class DetectorTest {
	
	@Test
	public void reconheceUTF8() {
		String resultado = Detector.execute("src/test/resources/outros/UTF-8.txt");
	
		Assert.assertEquals("UTF-8", resultado);
	}
	
	@Test
	public void reconheceWINDOWS1252() {
		String resultado = Detector.execute("src/test/resources/outros/WINDOWS-1252.txt");
	
		Assert.assertEquals("WINDOWS-1252", resultado);
	}
	
	@Test
	public void reconheceUTF16LE() {
		String resultado = Detector.execute("src/test/resources/outros/UTF-16LE.txt");
	
		Assert.assertEquals("UTF-16LE", resultado);
	}

}

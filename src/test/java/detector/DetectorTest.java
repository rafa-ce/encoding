package detector;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.mozilla.universalchardet.UniversalDetector;

public class DetectorTest {
	
	UniversalDetector detector = new UniversalDetector(null);	

	@After
	public void detectorReset() {
		detector.reset();
	}
	
	@Test
	public void reconheceUTF8() {
		String resultado = Detector.execute("src/test/resources/outros/UTF-8.txt", detector);
	
		Assert.assertEquals("UTF-8", resultado);
	}
	
	@Test
	public void reconheceWINDOWS1252() {
		String resultado = Detector.execute("src/test/resources/outros/WINDOWS-1252.txt", detector);
	
		Assert.assertEquals("WINDOWS-1252", resultado);
	}
	
	@Test
	public void reconheceUTF16LE() {
		String resultado = Detector.execute("src/test/resources/outros/UTF-16LE.txt", detector);
	
		Assert.assertEquals("UTF-16LE", resultado);
	}

}

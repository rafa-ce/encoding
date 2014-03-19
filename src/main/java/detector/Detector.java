package detector;

import java.io.FileInputStream;
import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;

import support.FileSupport;

public class Detector {
  
	public static String execute(String fileName) {
		UniversalDetector detector = new UniversalDetector(null);
		String encoding = null;
		FileInputStream file = FileSupport.openFileInputStream(fileName);
		
		try {
			encoding = detect(file, detector);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		detector.reset();
		FileSupport.closeFile(file);
		
		return encoding;
	}

	private static String detect(FileInputStream fis, UniversalDetector detector) throws IOException {
		int nread;
		byte[] buf = new byte[4096];
		
		while ((nread = fis.read(buf)) > 0 && !detector.isDone())
		  detector.handleData(buf, 0, nread);

		detector.dataEnd();
		
		return detector.getDetectedCharset();
	}

}

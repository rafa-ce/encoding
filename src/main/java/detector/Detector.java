package detector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;

public class Detector {
  
	public static String execute(String fileName, UniversalDetector detector) {
		byte[] buf = new byte[4096];
		FileInputStream fis = openFile(fileName);
		String encoding = null;
		
		try {
			encoding = detect(buf, fis, detector);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return encoding;
	}

	private static String detect(byte[] buf, FileInputStream fis,	UniversalDetector detector) throws IOException {
		int nread;
		while ((nread = fis.read(buf)) > 0 && !detector.isDone())
		  detector.handleData(buf, 0, nread);

		detector.dataEnd();
		
		return detector.getDetectedCharset();
	}

	private static FileInputStream openFile(String fileName) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return fis;
	}
}

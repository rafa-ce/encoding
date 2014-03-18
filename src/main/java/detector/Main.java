package detector;

import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;

public class Main {
	
	public static void execute(String[] args) throws IOException {
		UniversalDetector detector = new UniversalDetector(null);
		
		String resposta = Detector.execute(args[0], detector);
		
		detector.reset();
		
		System.out.println(resposta != null ? resposta : "No encoding detected.");
	}

}

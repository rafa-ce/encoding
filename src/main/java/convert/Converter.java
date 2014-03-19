package convert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import support.FileSupport;

import detector.Detector;

public class Converter {

	public static String execute(String fileName) {
		String encoding = Detector.execute(fileName);
		
		if (encoding == "UTF-8")
			return fileName;
		
		try {
			convertFile(fileName, encoding);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private static void convertFile(String fileName, String encoding) throws IOException {
		BufferedReader myBuffer = null;
		OutputStreamWriter newFile = null;

		try {
			myBuffer = new BufferedReader(new InputStreamReader(FileSupport.openFileInputStream(fileName), encoding));
			newFile = new OutputStreamWriter(new FileOutputStream("target/novoArquivo.txt"), "UTF-8");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (myBuffer.ready()) {
			String linha = myBuffer.readLine();
			newFile.write(linha + "\n");
		}
		
		newFile.close();
		myBuffer.close();
	}
}

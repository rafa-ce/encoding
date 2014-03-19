package convert;

import java.io.BufferedReader;
import java.io.FileInputStream;
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
		
		if (encoding == null)
			return null;
		
		if (encoding == "UTF-8")
			return fileName;
		
		try {
			convertFile(fileName, encoding);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newFileName();
	}

	private static void convertFile(String fileName, String encoding) throws IOException {
		FileInputStream fileInputStream = FileSupport.openFileInputStream(fileName);
		BufferedReader originalFile = null;
		OutputStreamWriter newFile = null;

		try {
			originalFile = openOriginalFile(fileInputStream, encoding);
			newFile = createNewFile();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		copy(originalFile, newFile);
		
		FileSupport.closeFile(fileInputStream);
		newFile.close();
		originalFile.close();
	}

	private static void copy(BufferedReader originalFile, OutputStreamWriter newFile) throws IOException {
		while (originalFile.ready()) {
			String linha = originalFile.readLine();
			newFile.write(linha + "\n");
		}
	}

	private static OutputStreamWriter createNewFile() throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream out = new FileOutputStream(newFileName());
		OutputStreamWriter newFile = new OutputStreamWriter(out, "UTF-8");
		return newFile;
	}

	private static String newFileName() {
		return FileSupport.getDirectory() + "/novoArquivo.txt";
	}

	private static BufferedReader openOriginalFile(FileInputStream file, String encoding) throws UnsupportedEncodingException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file, encoding));
		
		return bufferedReader;
	}
}

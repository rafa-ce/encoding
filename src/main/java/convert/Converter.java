package convert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import support.FileSupport;
import detector.Detector;

public class Converter {
	
	private String newFileName;
	private String originalFile;
	
	public Converter(String fileName) { 
		setNewFileName(fileName);
		originalFile = fileName;
	}

	public String execute() {
		String encoding = Detector.execute(originalFile);
		
		if (encoding == null)
			return null;
		
		if (encoding == "UTF-8")
			return originalFile;
		
		try {
			convertFile(originalFile, encoding);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return getNewFileName();
	}

	private void convertFile(String fileName, String encoding) throws IOException {
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

	private void copy(BufferedReader originalFile, OutputStreamWriter newFile) throws IOException {
		while (originalFile.ready()) {
			String linha = originalFile.readLine();
			newFile.write(linha + "\n");
		}
	}

	private OutputStreamWriter createNewFile() throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream out = new FileOutputStream(getNewFileName());
		OutputStreamWriter newFile = new OutputStreamWriter(out, "UTF-8");
		return newFile;
	}

	private BufferedReader openOriginalFile(FileInputStream file, String encoding) throws UnsupportedEncodingException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file, encoding));
		
		return bufferedReader;
	}
	
	private void setNewFileName(String fileName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		String date = dateFormat.format(new Date());
		
		newFileName = FileSupport.getDirectory() + "/" + fileName + date + ".txt";
	}
	
	public String getNewFileName() {
		return newFileName;
	}
}

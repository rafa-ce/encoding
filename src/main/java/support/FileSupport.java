package support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileSupport {
	
	private static String directory = System.getProperty("user.dir");
	
	public static FileInputStream openFileInputStream(String fileName) {
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return file;
	}

	public static void closeFile(FileInputStream file) {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getDirectory() {
		return directory;
	}
	
	public static void setDirectory(String directory) {
		FileSupport.directory = directory;
	}

}

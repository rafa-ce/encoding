package principal;

import java.io.IOException;

import support.FileSupport;

import convert.Converter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		if (args.length > 1)
			FileSupport.setDirectory(args[1]);

		Converter converter = new Converter(args[0]);
	
		String resposta = converter.execute();
		
		System.out.println(resposta != null ? resposta : "No encoding detected.");			
	}

}

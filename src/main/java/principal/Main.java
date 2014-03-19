package principal;

import java.io.IOException;

import convert.Converter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Converter converter = new Converter(args[0]);
		
		String resposta = converter.execute();
		
		System.out.println(resposta != null ? resposta : "No encoding detected.");
	}

}

package principal;

import java.io.IOException;

import convert.Converter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String resposta = Converter.execute(args[0]);
		
		System.out.println(resposta != null ? resposta : "No encoding detected.");
	}

}

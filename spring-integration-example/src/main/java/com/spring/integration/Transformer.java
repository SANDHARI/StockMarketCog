package com.spring.integration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class Transformer {
	
	public String transform(String filepath) throws IOException {
		
		
		
		String content = new String (Files.readAllBytes(Paths.get(filepath)));
		
		
		
		return "Transformed: " + content;
	}
	

}

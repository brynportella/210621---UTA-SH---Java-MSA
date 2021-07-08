package com.example.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamFileIO {
	
	public static void main(String[] args) {
		String filename = "characterStream.txt";
		
		writeCharacterStream(filename, "Hello, we are writing to a character stream");
		readCharacterStream(filename);
	}
	
	
	private static void writeCharacterStream(String filename, String message) {
		try {
			//The file writer constructor takes in the filename, and a boolean for if it should append or override the file
			FileWriter writer = new FileWriter(filename, false);
			writer.write(message);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readCharacterStream(String filename) {
		try {
			FileReader read = new FileReader(filename);
			int i;
			while((i = read.read()) != -1) {
				System.out.println((char)i);
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

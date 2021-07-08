package com.example.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileIO {
	
	public static void main(String[] args) {
		String filename = "bufferedFile.txt";
		writeBufferedStream(filename, "We are writing with a BufferedWriter");
		readBufferedStream(filename);
	}
	
	
	private static void writeBufferedStream(String filename, String message) {
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter(filename, true));
			write.write(message);
			write.newLine();
			write.flush();
			write.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readBufferedStream(String filename) {
			try {
				BufferedReader read = new BufferedReader(new FileReader(filename));
				String line = "";
				while((line=read.readLine()) != null) {
					System.out.println(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}

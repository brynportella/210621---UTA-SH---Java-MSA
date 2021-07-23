package com.example.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO<T> {
	
	private String filename;
	
	public FileIO(String filename) {
		this.filename = filename;
	}
	
	public ArrayList<T> readObject() throws FileNotFoundException, IOException{
		ArrayList<T> ret;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		try {
			ret = (ArrayList<T>) ois.readObject();
			return ret;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			ois.close();
		}
		return ret = new ArrayList<T>();
	}
	
	public void writeObject(ArrayList<T> objList) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(objList);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

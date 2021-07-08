package com.example.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectIO<T> {

	public static void main(String[] args) {
		ObjectIO<User> io = new ObjectIO<User>();
		
		ArrayList<User> userList = new ArrayList<User>();
		String filename = "objectStore.txt";
		
		try {
			System.out.println(io.readObjects(filename));
		} catch (Exception e) {
			System.out.println("There are no current users in the file");
			System.out.println(userList);
		}
		
		userList.add(new User("Summer", "Smith", "sssumertime"));
		userList.add(new User("Jerry", "Smith", "jsmith"));
		userList.add(new User("Rick", "Sanchez", "ricketyrick"));
		
		
		io.writeObjects(filename, userList);
		
		try {
			System.out.println(io.readObjects(filename));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		//Object files do not like being appended to, you must completely rewrite the file each time
		userList.add(new User("Morty", "Smith", "passdawg"));
		
		io.writeObjects(filename, userList);
		
		try {
			System.out.println(io.readObjects(filename));
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void writeObjects(String filename, ArrayList<T> objList) {
		//try with resources
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));){
			
			out.writeObject(objList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<T> readObjects(String filename) throws IOException, FileNotFoundException, ClassNotFoundException{
		ArrayList<T> ret;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		ret = (ArrayList<T>) in.readObject();
		return ret;
	}
	
}

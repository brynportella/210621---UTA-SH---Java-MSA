package constructors;

/*
 * By Default, Java will look for references
 * within the same package a class is declared
 * However, if you declare an import statement
 * explicitly, these take precedence
 */
import example.Data;

/*
 * The wildcard indicator '*' is used to declare, 
 * broadly, that you want to search all classes within
 * a package when defining the data you are using
 * 
 * Any class you explictly state with an import statement
 * always takes precedence 
 */
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;

public class Simulator {
	public static void main(String[] args) {
		/*
		 * You can also use a Fully Qualified Class Name
		 * (FQCN) when you declare any datatype or 
		 * class reference in your program.
		 */
		constructors.Data d_1 = new constructors.Data("Data 1", 1);
		Data d = new Data();
		
		/* 
		 * error because example.Data does not have 
		 * other constructors
		 */
//		Data d_2 = new Data("Data 2", 2);	
//		Data d_3 = new Data("Data 3", 3);
//		Data d_4 = new Data("Data 4", 4);
//		Data d_5 = new Data(4, "Data 5", 5.9, 9);
	}
}

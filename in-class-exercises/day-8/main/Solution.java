package main;

import java.util.List; 
import java.util.ArrayList;
import java.util.Set; 
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Solution{

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i<=10; i++){
            list.add(i); 
        }
        System.out.println(list); 
        for(int counter = 1; counter<= 10; counter++){
            for(int temp: list){
                System.out.print(temp * counter+" ");
            }
            System.out.println();
        }

        for (int i = 0; i< list.size(); i++){
            for(int j = 1; j<=10; j++){
                System.out.print(list.get(i) * j+" ");
            }
            System.out.println();    
        }

        Set<String> mySet = new HashSet<>(); 
        mySet.add("A");
        mySet.add("B"); 
        mySet.add("A");
        mySet.add("A");
        mySet.add("C"); 

        System.out.println(mySet); 

        Queue<String> myQ = new LinkedList<String>(); 
        myQ.add("A");
        myQ.add("B"); 
        myQ.add("A");
        myQ.add("A");
        myQ.add("C"); 

        System.out.println(myQ); 
    }

}
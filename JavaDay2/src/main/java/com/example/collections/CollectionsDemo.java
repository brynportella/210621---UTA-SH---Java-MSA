package com.example.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo {
	
	public static void main(String[] args) {
		//Lists
		List<User> userArrayList = new ArrayList<User>();
		
		//To add to an arraylist we use .add()
		userArrayList.add(new User("Summer", "Smith", "sssumertime"));
		userArrayList.add(new User("Jerry", "Smith", "jsmith"));
		userArrayList.add(new User("Rick", "Sanchez", "ricketyrick"));
		
		//We can use these just like arrays
		System.out.println("Regular old for loop with an ArrayList");
		for(int i=0; i<userArrayList.size(); i++) {
			System.out.println(userArrayList.get(i));
		}
		
		System.out.println();
		
		//Linked Lists and Iterators
		List<User> userLinkedList = new LinkedList<User>();
		
		userLinkedList.add(new User("Summer", "Smith", "sssumertime"));
		userLinkedList.add(new User("Jerry", "Smith", "jsmith"));
		userLinkedList.add(new User("Rick", "Sanchez", "ricketyrick"));
		
		Iterator<User> linkedListIterator = userLinkedList.iterator();
		
		System.out.println("Iterating through the linked list with an iterator");
		while(linkedListIterator.hasNext()) {
			System.out.println(linkedListIterator.next());
		}
		System.out.println();
		
		//Sets
		Set<User> userSet = new HashSet<User>();
		
		User beth = new User("Beth", "Smith", "beths");
		
		userSet.add(beth);
		//Lets see what happens if we try to add her twice
		//userSet.add(beth); // This will not add beth a second time
		userSet.add(new User("Summer", "Smith", "sssumertime"));
		userSet.add(new User("Jerry", "Smith", "jsmith"));
		userSet.add(new User("Rick", "Sanchez", "ricketyrick"));
		
		
		System.out.println("Looping through the set");
		for(User user: userSet) {
			System.out.println(user);
		}
		System.out.println();
		
		//Queue and Deqeue
		ArrayDeque<User> userQueue = new ArrayDeque<User>();
		
		//To add a user to the front of the queue use push
		userQueue.push(beth);
		System.out.println(userQueue);
		//If we want to add a user to the end of the queue use add
		userQueue.add(new User("Jerry", "Smith", "jsmith"));
		System.out.println(userQueue);
		userQueue.push(new User("Rick", "Sanchez", "ricketrick"));
		System.out.println(userQueue);
		userQueue.add(new User("Summer", "Smith", "sssumertime"));
		System.out.println(userQueue);
		
		//We use .pop() to remove an element from the front of the queue
		User rick = userQueue.pop();
		System.out.println(userQueue);
		
		//We can use removeLast() or .pollLast() will grab the element from the end of the queue
		User summer = userQueue.removeLast();
		System.out.println(userQueue);
		
		System.out.println();
		
		//Maps
		//Map<Key,Value>
		Map<String,User> userMap = new HashMap<String, User>();
		
		//Use .put() to add to a map
		userMap.put("Summer", summer);
		userMap.put("Beth", beth);
		userMap.put("Rick", rick);
		
		//Use .get(key) to retrieve an element from the map
		System.out.println(userMap.get("Summer"));
		
		//You cannot directly iterate over a map, but you can iterate over the entrySet
		//keySet, and the values
		
		Iterator<User> mapValues = userMap.values().iterator();
		
		while(mapValues.hasNext()) {
			System.out.println(mapValues.next());
		}
		System.out.println();
		
		
		//The Collections class has useful methods that we can use on collections, including sorting
		// In order for Collections.sort to work, the object being sorted in the colleciton must
		// Implement comparable
		Collections.sort(userArrayList);
		System.out.println(userArrayList);
		System.out.println();
		
		//TreeSets will sort the elements based on a comparator
		Set<User> userTree = new TreeSet<User>(new UserComparator());
		userTree.add(new User("Jerry", "Smith", "jsmith"));
		userTree.add(new User("Rick", "Sanchez", "ricketyrick"));
		userTree.add(beth);
		userTree.add(summer);
		userTree.add(new User("Morty", "Smith", "passdawg"));
		
		System.out.println(userTree);
	}
	
}

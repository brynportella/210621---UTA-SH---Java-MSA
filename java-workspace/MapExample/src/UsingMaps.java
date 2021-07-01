import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsingMaps {
	public static void main(String[] args) {
		Map<String, Integer> myMap = new HashMap<String,Integer>(); 
		myMap.put("A", 1); 
		myMap.put("A", 2); 
		myMap.put("B", 1); 
		myMap.put("C", 7); 
		//Option 1//A = 1, A =2, B = 1, C= 7 
		//Option 2//A =2, B = 1, C= 7
		//Option 3//A = 1, B = 1, C= 7
		System.out.println(myMap);
		Map<String, List<Integer>> myMapOfLists =new HashMap<String,List<Integer>>();
		myMapOfLists.put("A", new ArrayList<Integer>()); 
		
		List<Integer> valueFromA = myMapOfLists.get("A");
		valueFromA.add(1);
		valueFromA.add(2);
		valueFromA.add(1);
		System.out.println(myMapOfLists);
		
		//Iterating over a map
		//get the keys
		for(String key: myMap.keySet()) {
			System.out.println(key+":"+myMap.get(key));
		}
		
		for(Integer value: myMap.values()) {
			System.out.println("?:"+value);
		}
		
		for(Map.Entry<String, Integer> entry : myMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}

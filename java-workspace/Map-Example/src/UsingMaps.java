import java.util.HashMap;
import java.util.Map;

public class UsingMaps {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		
		map.put("A", 1); 
		map.put("B", 2);
		map.put("C", 1);
		
		System.out.println(map.get("A"));
		
		for(String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		
		CandyStorage storage = new CandyStorage(); 
		
		storage.storeCandy("A", new Candy("Abba Zabba"));
		storage.storeCandy("B", new Candy("Butterfingers"));
		storage.storeCandy("C", new Candy("Chocolate")); 
		
		storage.printContents();
	}
}

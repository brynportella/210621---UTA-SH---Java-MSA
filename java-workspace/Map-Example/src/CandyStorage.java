import java.util.HashMap;

public class CandyStorage {
	private HashMap<String, Candy> candies = new HashMap<String, Candy>();
	
	public void storeCandy(String key, Candy candy) {
		candies.put(key.toLowerCase().trim(), candy); 
	}
	
	public Candy getCandy(String key) {
		return candies.get(key); 
	}
	
	public void printContents() {
		for(String key : candies.keySet()) {
			System.out.println(key+":"+candies.get(key).toString());
		}
	}
}

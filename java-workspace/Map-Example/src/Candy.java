
public class Candy {
	private String type;
	
	public Candy() {}
	
	public Candy(String t) {
		this.type = t; 
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Candy [type=" + type + "]";
	} 
	
	
}

package multidimensional;

public class Simulator {
	
	static int[][][] multi = {{{1,2,3}}};
	
	public static void main(String[] args) {
//							 0		  1	 	   2
//						   0 1 2	0 1 2	 0 1 2  
		int[][] multi = { {1,2,3}, {4,5,6}, {7,8,9} };
		
		System.out.println(multi[0][0]); // 1
		System.out.println(multi[1][1]); // 5
		multi[0][0] = 1000;
		System.out.println(multi[0][0]); // 1000
		
		System.out.println(Simulator.multi);
	}
}

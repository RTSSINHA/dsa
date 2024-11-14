package array;

public class SieveEratosthenes {

	public static void main(String args[]) {
		
//		int num = 10;
		int num = 100;
		System.out.println(num);
		
		PrintPrimes(num);
	}
	static void PrintPrimes(int num) {
		
		boolean[] vis = new boolean[num+1];
		
		for(int i=2; i<=(int)Math.sqrt(num); i++) {
			
			int j = i*i;
			if(vis[j]) continue;
			while(j < vis.length) {
				vis[j] = true;
				j += i;
			}
		}
		
		for(int i=1; i<vis.length; i++) {
			if(!vis[i]) System.out.print(i+" ");
		}
	}
}

package recursion;
import java.util.*;

public class JosephusProblem {
	
	public static void main(String args[]) {
		JosephusProblem jose = new JosephusProblem();
		
		int n = 14, k = 2;
		System.out.println("N: "+n+" K: "+k);
		System.out.println(jose.getJosephusResult(n, k, 1));
	}
	
	int getJosephusResult(int n, int k, int itr) {
		
		if(n == 1) return 1;
//		System.out.println("Killed: "+(itr * k)%n);
		
		return (getJosephusResult(n-1, k, itr+1) + k-1) % n+1;
	}
}

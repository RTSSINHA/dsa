package recursion;
import java.util.*;

public class RopeCutting {
	
	public static void main(String args[]) {
		int N = 5, A = 2, B = 1, C = 5;
//		int N = 10, A=9, B=7, C=11;
//		int N = 17, A = 10, B = 11, C = 3;
		System.out.println("N: "+N+" A: "+A+" B: "+B+" C: "+C);
		System.out.println("Maximum cuts: "+maxCut(N, A, B, C));
	}
	
//	T/C: O(3^N)
//	S/C: O(N) Recursive stack
	static int maxCut(int N, int A, int B, int C) {
		
		if(N == 0) return 0;
		if(N <= -1) return -1;
		
		int res = Math.max(maxCut(N-A, A, B, C),
				  Math.max(maxCut(N-B, A, B, C),
				  maxCut(N-C, A, B, C)));
		
		if(res == -1) return -1;
		return res + 1;
	}
}

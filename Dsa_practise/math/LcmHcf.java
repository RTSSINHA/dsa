package math;
import java.util.*;

public class LcmHcf {
	
	public static void main(String args[]) {
		
		int a = 30;
		int b = 24;
		
//		System.out.println(TotalDivisor(a));
		
		System.out.println(LCM(a, b));
	}
	
	static int TotalDivisor(int n) {
		
		int total = 0;
		for(int i=2; i<Math.sqrt(n); i++) {
			
			if(n % i == 0) total += (i + (n/i));
		}
		return total;
	}
	
	static int LCM(int a, int b) {
		
		int gcd = GCD(a, b);
		System.out.println("GCD: "+gcd);
		
		return (a * b)/gcd;
	}
	
	static int GCD(int a, int b) {
		if(a < b) return GCD(b, a);
		if(a % b == 0) return b;
		
		return GCD(a % b, b);
	}
}

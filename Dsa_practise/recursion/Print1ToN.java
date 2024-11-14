package recursion;
import java.util.*;

public class Print1ToN {
	public static void main(String args[]) {
		Print1ToN printN = new Print1ToN();
		int n = 10;
		System.out.println("Number: "+n);
		printN.print1ToN(n);
	}
	
	void print1ToN(int n) {
		
		if(n == 0) return;
		
		print1ToN(n-1);
		System.out.println(n);
	}
}

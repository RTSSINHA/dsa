package recursion;
import java.util.*;

public class SumNaturalNumber {
	
	public static void main(String args[]) {
		
		int sum = 0;
		int n = 10;
		System.out.println(findSum(n));
	}
	static int findSum(int n) {
		
		if(n == 1) return 1;
		int smallerSum = findSum(n-1);
		System.out.println("N: "+n+" Smaller Sum: "+smallerSum+" Total: "+(smallerSum+n));
		
		return smallerSum + n;
	}
}

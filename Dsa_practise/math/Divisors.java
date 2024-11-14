package math;
import java.util.*;

public class Divisors {
	
	public static void main(String args[]) {
		
		int num = 30;
		System.out.println(num);
		List<Integer> list = new ArrayList<>();
		
		printDivisors(num, list);
		Collections.sort(list, (x,y) -> y-x);
		System.out.println(list);
		countDivisors(num);
	}
	
	static void countDivisors(int num) {
		
		if(num < 0) return;
		
		boolean[] primes = getPrime(num);
		System.out.println("Length primes: "+primes.length);
		
		int count = 0;
		for(int i= 2; i<primes.length; i++) {
			
			if(primes[i]) {
				while(num % i == 0 && num > 0) {
					num /= i;
					count++;
				}
			}
		}
		
		System.out.println(Arrays.toString(primes));
		System.out.println("Count: "+count);
	}
	
	static boolean[] getPrime(int n) {
		
		boolean[] primes = new boolean[(n/2)+1];
		Arrays.fill(primes, true);
		
		for(int j=2; j<Math.sqrt(n); j++) {
		for(int i=j*2; i<primes.length; i+=j) {
			primes[i] = false;
		}
		}
		return primes;
	}
	
	static void printDivisors(int n, List list) {
		
		for(int i=1; i<Math.sqrt(n); i++) {
			
			if(n % i == 0) {
				
				int div = n / i;
				if(i == div) {
					list.add(i);
				} else {
					list.add(i);
					list.add(div);
				}
			}
		}
	}
}

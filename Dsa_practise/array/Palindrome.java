package array;
import java.util.*;

public class Palindrome {
	
	public static void main(String args[]) {
		
//		int num = 2002;
		int num = 123;
		System.out.println(num);
		
		Palindrome(num);
	}
	static void Palindrome(int num) {
		
		int palindrome = 0;
		int nDig = 0;
		
		int sec = num;
		while(sec > 0) {
			int rem = sec % 10;
			palindrome = palindrome * 10 + rem;
			sec = sec / 10;
		}
		System.out.println(palindrome);
		System.out.println(num);
		if(palindrome == num) {
			System.out.println("Palindrome");
		} else System.out.println("Not a Palindrome");
		
		
	}
}

package recursion;
import java.util.*;

public class Permutation {
	
	public static void main(String args[]) {
		
		String str = "abc";
		System.out.println(str);
		System.out.println("Permutation\n..............\n");
		Permute(str.toCharArray(), 0, str.length()-1);
	}
	static void Permute(char[] str, int l, int h) {
		
		if(l == h) {
			System.out.println(String.valueOf(str));
			return;
		}
		
		for(int i=l; i<=h; i++) {
			swap(str, l, i);
			Permute(str, l+1, h);
			swap(str, l, i);
		}
	}
	
	static void swap(char[] chars, int l, int h) {
//		char[] chars = s.toCharArray();
		char temp = chars[l];
		chars[l] = chars[h];
		chars[h] = temp;
//		s = String.valueOf(chars);
	}
}

package recursion;
import java.util.*;

public class Subset {
	
	public static void main(String args[]) {
		
		String str = "abc";
		System.out.println("Input string: "+str);
		printSubset(str, "", 0, str.length());
	}
	static void printSubset(String str, String ans, int idx, int len) {
		
		if(idx == len) {
			System.out.println(ans);
			return;
		}
		if(idx >= str.length()) return;
		
		
		printSubset(str, ans + str.charAt(idx), idx+1, len);
		printSubset(str, ans, idx+1, len);
		ans = "";
		
	}
}

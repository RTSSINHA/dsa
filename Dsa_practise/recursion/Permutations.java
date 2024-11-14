package recursion;
import java.util.*;

public class Permutations {
	
	public static void main(String args[]) {
		Permutations permutation = new Permutations();
		
		String str = "abc";
		System.out.println("INput: "+str);
		ArrayList<String> res = new ArrayList<>();
		permutation.getPermutations(str, 0, str.length()-1, res);
		System.out.println(res);
		Collections.sort(res);
		System.out.println(res);
		
	}
	
	void getPermutations(String str, int idx, int len, ArrayList<String> res) {
		
		if(idx == len) {
			res.add(str);
		}
		
		for(int i=idx; i<=len; i++) {
			
			str = swap(str, idx, i);
			getPermutations(str, idx+1, len, res);
			str = swap(str, idx, i);
		}
	}
	static String swap(String str, int i, int j) {
		
		char[] ch = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return String.valueOf(ch);
	}
}

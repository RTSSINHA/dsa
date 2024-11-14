package recursion;
import java.util.*;

public class Subsequence {
	
	public static void main(String args[]) {
		
		String str = "abc";
		System.out.println(str);
		
		List<String> res = new ArrayList<>();
		Subseq(str, 0, "", res);
		System.out.println(res);
		Collections.sort(res, (a, b) -> a.length() - b.length());
		System.out.println(res);
	}
	
	static void Subseq(String str, int idx, String res, List<String> ans) {
		
		if(idx == str.length()) {
			ans.add(res);
			return;
		}
		
		Subseq(str, idx + 1, res, ans);
		Subseq(str, idx + 1, res += str.charAt(idx), ans);
		
	}
}

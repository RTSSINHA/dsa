package array;
import java.util.*;

public class longestSubArrayWithSumK {
	
	public static void main(String args[]) {
		
//		int[] arr = {10, 15, 2, 7, 10, 9};
		int[] arr = {-5, 8, -14, 2, 4, 12};
		System.out.println(Arrays.toString(arr));
//		int k = 15;
		int k = -5;
		
		System.out.println(longestLength(arr, k));
	}
	
	static int longestLength(int[] arr, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxLen = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			sum += arr[i];
			
			if(sum == k) maxLen = i + 1;
			if(map.size() == 0 || !map.containsKey(sum)) {
				map.put(arr[i], i);
			}
			if(map.size() > 0 && map.containsKey(sum - k)) {
				int val = map.get(sum - k);
				maxLen = Math.max(maxLen, i - val);
			}
		}
		return maxLen;
	}
}

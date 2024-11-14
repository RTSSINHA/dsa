package Hashing;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LongestSubArrayWithSumK {
	
	public static void main(String args[]) {
		
//		int[] arr = {10, 5, 2, 7, 1, 9};
//		int k = 15;
		int[] arr = {-5, 8, -14, 2, 4, 12};
		int k = -5;
		
		System.out.println("Array: "+Arrays.toString(arr));
		System.out.println("K: "+k);
		System.out.println(LongestSubArrayWithSumK(arr, k));
	}
	static int LongestSubArrayWithSumK(int[] arr, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int preSum = 0;
		int maxLen = 0;
		
		for(int i=0; i<arr.length; i++) {
			preSum += arr[i];
			
			if(map.containsKey(preSum - k) || preSum == k) {
				int currLen = 0;
				
				if(preSum == k) {
					System.out.println("Subarray found till index "+i);
					currLen = (i+1);
				} else {
					int val = map.get(preSum - k);
					System.out.println("Subarray found from index "+(val + 1)+" to index "+i);
					currLen =  i - val;
				}
				maxLen = Math.max(maxLen, currLen);
				
			} 
			
			if(!map.containsKey(preSum)) {
				map.put(preSum, i);
			}
			
		}
		return maxLen == 0? -1: maxLen;
		
	}
}

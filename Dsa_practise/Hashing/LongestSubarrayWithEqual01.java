package Hashing;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LongestSubarrayWithEqual01 {
	
	public static void main(String args[]) { 
//		int[] arr = {1, 0, 1, 1, 1, 0, 0};
//		int[] arr = {1, 1, 1, 1};
		int[] arr = {0, 0, 1, 1, 0};
		System.out.println(Arrays.toString(arr));
		System.out.println(GetLongestDesiredSubarray(arr));
	}
	
	static int GetLongestDesiredSubarray(int[] arr) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int presum = 0;
		int maxLen = 0;
		for(int i=0; i<arr.length; i++) {
		if(arr[i] == 0) arr[i] = -1;
	}
		
		for(int i=0; i<arr.length; i++) {
		presum += arr[i];
		if(map.containsKey(presum) || presum == 0) {
			
			if(presum == 0) {
	System.out.println("Sum found till index: "+i);
	maxLen = Math.max(maxLen, (i+1));
	} else {
		int val = map.get(presum);
		System.out.println("Index found from "+(val+1)+" to index "+i);
	maxLen = Math.max(maxLen, i-(val));
	}
	}
	if(!map.containsKey(presum)) map.put(presum, i);
	}
	 return maxLen == 0? -1: maxLen;
	}

}






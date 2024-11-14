package Hashing;
import java.util.*;

public class SubArrayGivenSum {
	
	public static void main(String args[]) {
		
//		int[] arr = {1, 4, 20, 3, 10, 5};
//		int k = 33;
		int[] arr = {1, 4, 0, 0, 1, 2, 10, 5};
		int k = 7;
//		int[] arr = {1, 4};
//		int k = 0;
		System.out.println(Arrays.toString(arr));
		System.out.println("Target sum: "+k);
		System.out.println(isSubArrayWithSumK(arr, k));
		
	}
	static boolean isSubArrayWithSumK(int[] arr, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int preSum = 0;
		
		for(int i=0; i<arr.length; i++) {
			preSum += arr[i];
			
			if(map.containsKey(preSum - k) || preSum == k) {
				
				if(preSum == k) {
					System.out.println("SubArray till index "+i);
				} else {
					int val = map.get(preSum - k);
					System.out.println("Subarray found from index "+(val + 1) +" to index: "+i);
				}
				return true;
			} else {
				map.put(preSum, i);
			}
		}
		return false;
		
	}
}

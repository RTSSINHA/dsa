package Hashing;
import java.util.*;

public class SubArrayZeroSum {
	
	public static void main(String args[]) {
		
//		int[] arr = {4, 2, -3, 0, 6};
		int[] arr = {-3, 2, 3, 1, 0, 6};
		System.out.println(Arrays.toString(arr));
		
		System.out.println(hasZeroSumSubArray(arr));
	}
	static boolean hasZeroSumSubArray(int[] arr) {
		
		Map<Integer, Integer> set = new HashMap<>();
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			if(set.containsKey(sum) || sum == 0) {
				System.out.println("Map: "+set);
				if(sum == 0) {
					System.out.println("Start: "+0+" End: "+i);
				}
//					else if(arr[i] == 0) {
//					System.out.println("Start: "+i+" End: "+i);
//				}
				else {
					System.out.println("Start: "+(set.get(sum) + 1)+"  End: "+i);
				}
				return true;
			} else {
				set.put(sum, i);
			}
		}
		return false;
	}
}

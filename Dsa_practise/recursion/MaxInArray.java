package recursion;
import java.util.*;

public class MaxInArray {
	
	public static void main(String args[]) {
		
		int[] arr = {5, 10, 4, 33, 21, 99, 2, 0, 43, 34, 20};
		System.out.println(Arrays.toString(arr));
		if(arr.length == 0) {
			System.out.println(-1);
			return;
		}
		
		int max = Max(arr, 0, arr[0]);
		System.out.println(max);
	}
	static int Max(int[] arr, int idx, int maxnow) {
		
		if(idx == arr.length) return maxnow;
		
		maxnow = Math.max(arr[idx], maxnow);
		return Max(arr, idx + 1, maxnow);
	}
}

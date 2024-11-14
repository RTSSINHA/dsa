package recursion;
import java.util.*;

public class FirstIdx {
	
	public static void main(String args[]) {
		
		int[] arr = {2, 3, 9, 8, 7, 6, 4, 12, 7, 3, 8};
		int target = 8;
		System.out.println(Arrays.toString(arr));
		System.out.println("Target: "+target);
		
		System.out.println(firstOccurance(arr, target, 0));
		System.out.println(lastOccurance(arr, target, 0, -1));
		allOccurance(arr, target, 0);
	}
	
	static void allOccurance(int[] arr, int t, int idx) {
		
		if(idx == arr.length) return;
		
		if(arr[idx] == t) {
			System.out.print(idx+" ");
		}
		
		allOccurance(arr, t, idx + 1);
	}
	
	static int lastOccurance(int[] arr, int t, int idx, int targetIdx) {
		
		if(idx == arr.length) return targetIdx;
		if(arr[idx] == t) targetIdx = idx;
		return lastOccurance(arr, t, idx + 1, targetIdx);
		
	}
	
	static int firstOccurance(int[] arr, int t, int idx) {
		if(idx == arr.length) return -1;
		if(arr[idx] == t) return idx;
		return firstOccurance(arr, t, idx+1);
	}
}

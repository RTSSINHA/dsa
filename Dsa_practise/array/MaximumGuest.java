package array;
import java.util.*;

class Intervals {
	int entry;
	int exit;
	Intervals(int entry, int exit) {
		this.entry = entry;
		this.exit = exit;
	}
}

public class MaximumGuest {
	
	public static void main(String args[]) {
		
		int[] entry = {1, 2, 9, 5, 5};
		int[] exit = {4, 5, 12, 9, 12};
		
		Intervals[] arr = new Intervals[entry.length];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Intervals(entry[i], exit[i]);
		}
		
		printIntervals(arr);
		
//		System.out.println(numberMaximumGuest(arr));
		System.out.println(numberMaximumGuest2(entry, exit));
		
	}
	static int numberMaximumGuest2(int[] arrl, int[] exit) {
		
		Arrays.sort(arrl);
		Arrays.sort(exit);
		int maxGuest = 0;
		int guestIn = 0;
		int i=0, j=0;
		while(i < arrl.length && j < exit.length) {
			
			if(arrl[i] <= exit[j]) {
				guestIn++;
				maxGuest = Math.max(maxGuest, guestIn);
				i++;
			} else {
				guestIn--;
				j++;
			}
		}
		return maxGuest;
	}
	
	static int numberMaximumGuest(Intervals[] arr) {
		
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			min = Math.min(min, arr[i].entry);
			max = Math.max(max, arr[i].exit);
		}
		
		int max_people = Integer.MIN_VALUE;
		int[] meet = new int[max - min+1];
		for(int i=0; i<arr.length; i++) {
			int entry = arr[i].entry;
			int exit  = arr[i].exit;
			for(int itr = entry; itr <= exit; itr++) {
				meet[itr - min]++;
				max_people = Math.max(max_people, meet[itr - min]);
			}
		}
		System.out.println("Meet");
		System.out.println(Arrays.toString(meet));
		return max_people;
	}
	
	static void printIntervals(Intervals[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("["+arr[i].entry+", "+arr[i].exit+"] ");
		}
	}
}

package array;
import java.util.Stack;
import java.util.Arrays;
import java.util.Comparator;

class Interval {
	int start;
	int end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeOverlappingIntervals {
	
	public static void main(String args[]) {
		
		Interval[] arr = new Interval[4];
		arr[0] = new Interval(6, 8);
		arr[1] = new Interval(2, 6);
		arr[2] = new Interval(2, 4);
		arr[3] = new Interval(9, 17);
		printIntervals(arr);
		
		mergeOverLapping(arr);
		
		
	}
	
	static void mergeOverLapping(Interval[] arr) {
		
		Stack<Interval> stk = new Stack<>();
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		System.out.println("Intervals after sorting");
		printIntervals(arr);
		stk.push(arr[0]);
		
		for(int i=1; i<arr.length; i++) {
			
			Interval top = stk.peek();
			
			if(arr[i].start > top.end) {
				stk.push(arr[i]);
			} else if(arr[i].end > top.end) {
				top.end = arr[i].end;
				stk.pop();
				stk.push(top);
			}
		}
		
		while(!stk.isEmpty()) {
			
			Interval top = stk.pop();
			System.out.print("["+top.start+" ,"+top.end+"] ");
		}
	}
	
	static void printIntervals(Interval[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("["+arr[i].start+", "+arr[i].end+"] ");
		}
		System.out.println();
	}
}

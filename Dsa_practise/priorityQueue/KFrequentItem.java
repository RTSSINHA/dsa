package priorityQueue;
import java.util.Queue;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

class Pair {
	int num;
	int freq;
	
	Pair(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}
}

class SortByFreq implements Comparator<Pair> {
	
	public int compare(Pair a, Pair b) {
		
		if(a.freq == b.freq) {
			return a.num - b.num;
		} else return b.freq - a.freq;
	}
	
}



public class KFrequentItem {
	
	public static void main(String args[]) {
		
//		Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
		Queue<Pair> pq = new PriorityQueue<>(new SortByFreq());
		
		int[] arr = {10, 5, 20, 5, 10, 10, 30};
		int k = 2;
		
//		int[] arr = {20, 40, 30, 20, 30, 40, 40, 60, 60};
//		int k = 3;
		
		System.out.println(Arrays.toString(arr));
		System.out.println("K: "+k);
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i: arr) {
			if(map.containsKey(i)) {
				int val = map.get(i);
				map.put(i, val + 1);
			} else map.put(i, 1);
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			pq.add(new Pair(entry.getKey(), entry.getValue()));
		}
		
		while(k > 0) {
			Pair p = pq.poll();
			System.out.println((int)p.num);
			k--;
		}
		
		
	}
}

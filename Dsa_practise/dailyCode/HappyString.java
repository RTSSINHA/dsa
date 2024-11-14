package dailyCode;
import java.util.*;

class Pair {
	
	int count;
	char ch;
	
	Pair(char ch, int count) {
		this.ch = ch;
		this.count = count;
	}
	
	Pair() {}
	
	public int getCount() {
		return this.count;
	}
	
	public String toString() {
		return this.ch+" -> "+this.count;
	}
}

class SortByCount implements Comparator<Pair>{
	
	public int compare(Pair a, Pair b) {
		return b.count - a.count;
	}
}

public class HappyString {
	
	public static void main(String args[]) {
		
		int a = 1, c = 7,  b = 1;
		
		System.out.println("a: "+a+" b: "+b+" c: "+c);
		Queue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
//		Queue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		if(a > 0) pq.offer(new Pair('a', a));
		if(b > 0) pq.offer(new Pair('b', b));
		if(c > 0) pq.offer(new Pair('c', c));
		
		Iterator itr = pq.iterator();
		while(itr.hasNext()) {
			Pair p = (Pair)itr.next();
			System.out.println(p.ch+" -> "+p.count);
		}
		
		String ans = "";
		
		while(!pq.isEmpty()) {
			
			Pair first = pq.poll();
			
			if(ans.length() >= 2 && ans.charAt(ans.length() - 1) == first.ch && ans.charAt(ans.length() - 2) == first.ch) {
				
				if(pq.isEmpty()) {
					System.out.println("Intermediate break");
					break;
				}
				
				Pair sec = pq.poll();
				ans += sec.ch;
				sec.count = sec.count - 1;
				System.out.println("Second count: "+sec.count);
				if(sec.getCount() > 0) pq.offer(sec);
				
			} else {
				
				ans += first.ch;
				first.count = first.count - 1;
				System.out.println("FIrst count: "+first.count);
				if(first.getCount() > 0) pq.offer(first);
//				while(itr.hasNext()) {
//					Pair p = (Pair)itr.next();
//					System.out.println(p.ch+" -> "+p.count);
//				}
			}
		}
		while(itr.hasNext()) {
			Pair p = (Pair)itr.next();
			System.out.println(p.ch+" -> "+p.count);
		}
		System.out.println(ans);
		
	}
}

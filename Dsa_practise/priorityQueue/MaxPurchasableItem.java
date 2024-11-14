package priorityQueue;
import java.util.*;

public class MaxPurchasableItem {
	
	public static void main(String args[]) {
		
		int[] cost = {1, 12, 5, 11, 200};
		int money = 10;
		
		System.out.println(maxItem(cost, money));
	}
	
	static int maxItem(int[] cost, int money) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int price: cost) pq.add(price);
		
		Iterator itr = pq.iterator();
		System.out.println("Printing priority queue");
		while(itr.hasNext()) {
			int price = (int)itr.next();
			System.out.print(price+" ");
		}
		System.out.println();
		int itemCount = 0;
		while(money > 0 && pq.size() > 0) {
			int price = (int)pq.remove();
			System.out.println("Price: "+price);
			if(price > money) break;
			itemCount++;
			money -= price;
		}
		return itemCount;
	}
}

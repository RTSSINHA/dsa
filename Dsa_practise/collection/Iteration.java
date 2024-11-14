package collection;
import java.util.*;

public class Iteration {

	public static void main(String args[]) {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(13);
		list.add(14);
		list.add(12);
		list.add(18);
		list.add(21);
		System.out.println(list);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			int val = (int)itr.next();
			if(val % 2 == 0) itr.remove();
		}
		System.out.println(list);
	}
}

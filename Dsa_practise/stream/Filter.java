package stream;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Filter {
	
	public static void main(String args[]) {
		
		List<Integer> list = Arrays.asList(5, 10, 30, 20, 30, 45, 8, 7);
		List<Integer> first = new ArrayList<>();
		
		list.stream()
		.filter(x -> x % 2 ==0)
		.filter(x -> x > 10)
		.sorted()
		.forEach(x -> first.add(x));
		
		System.out.println(list);
		System.out.println(first);
	}

}

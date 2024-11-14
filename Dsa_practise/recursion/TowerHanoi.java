package recursion;
import java.util.*;

public class TowerHanoi {
	
	public static void main(String args[]) {
		
		int n = 2;
		System.out.println("N: "+n);
		TOH(n, 'A', 'C', 'B');
	}
	static void TOH(int n, char from, char to, char aux) {
		
		if(n == 0) return;
		
		TOH(n-1, from, aux, to);
		System.out.println("Move disk "+n+" from "+from+" to "+to);
		TOH(n-1, aux, to, from);
	}
}

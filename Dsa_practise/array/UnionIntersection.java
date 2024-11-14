package array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class UnionIntersection {
	
	public static void main(String args[]) {
		
//		int[] a1 = {1, 3, 4, 5, 7};
//		int[] a2 = {2, 3, 5, 6};
		int[] a1 = {2, 5, 5, 5, 6};
		int[] a2 = {4, 6, 8, 10};
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		
		UnionIntersection(a1, a2);
	}
	static void UnionIntersection(int[] a1, int[] a2) {
		
		List union = new ArrayList<>();
		List intersect = new ArrayList<>();
		
		int i1 = 0, i2 = 0;
		while(i1 < a1.length && i2 < a2.length) {
			if(a1[i1] == a2[i2]) {
				if(union.size() == 0 || (int)union.getLast() != a1[i1]) {
					union.add(a1[i1]);
				}
				if(intersect.size() == 0 || (int)intersect.getLast() != a1[i1]) {
					intersect.add(a1[i1]);
				}
				i1++;
				i2++;
			} else if(a1[i1] < a2[i2]) {
				if(union.size() == 0 || (int)union.getLast() != a1[i1]) {
					union.add(a1[i1]);
					}
				i1++;
			} else {
				if(union.size() == 0 || (int)union.getLast() != a2[i2]) {
					union.add(a2[i2]);
					}
				i2++;
			}
		}
		while(i1 < a1.length) {
			if(union.size() == 0 || (int)union.getLast() != a1[i1]) {
				union.add(a1[i1]);
				}
			i1++;
		}
		while(i2 < a2.length) {
			if(union.size() == 0 || (int)union.getLast() != a2[i2]) {
				union.add(a2[i2]);
				}
			i2++;
		}
		System.out.println("Union");
		System.out.println(union);
		System.out.println("Intersection");
		System.out.println(intersect);
		
	}

}

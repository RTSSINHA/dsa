package matrix;
import java.util.*;

public class SearchInSorted {
	
	public static void main(String args[]) {
		
		int n = 3;
		int m = 4;
		int target = 16;
		int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 14, 16}};
		SearchInSorted obj = new SearchInSorted();
		System.out.println("n: "+n+" m: "+m+" target: "+target);
		obj.print(mat);
		double pow = Math.pow(2.000, 10);
		obj.search(n, m, target, mat);
	}
	
	void search(int n, int m, int t, int[][] mat) {
		
		int row = 0;
		while(row < n && mat[row][m-1] < t) {
			row++;
			
		}
		
		if(row == n) {
			System.out.println("Target is not found");
			return;
		}
		
		int col = binarySearch(mat[row], 0, m-1, t);
		if(col == -1) {
			System.out.println("Target is not found");
			return;
		}
		System.out.println(t+" found at row: "+(row + 1)+"  col: "+(col+1));
	}
	
	static int binarySearch(int[] arr, int l, int r, int t) {
		
		if(l > r) return -1;
		int mid = l + (r - l)/2;
		if(arr[mid] == t) return mid;
		else if(arr[mid] < t) return binarySearch(arr, mid + 1, r, t);
		else return binarySearch(arr, l, mid - 1, t);
		
	}
	
	void print(int[][] mat) {
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

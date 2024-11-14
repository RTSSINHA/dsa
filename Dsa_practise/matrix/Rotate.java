package matrix;
import java.util.*;

public class Rotate {
	
	
	public static void main(String args[]) {
		
		Rotate rotate = new Rotate();
		int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//		int[][] mat = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
		rotate.print(mat);
//		rotate.clock(mat);
		rotate.clockWise(mat);
//		rotate.print(mat);
	}
	
	void clockWise(int[][] mat) {
		
		Rotate rotate = new Rotate();
		mat = rotate.transpose(mat);
		rotate.print(mat);
		mat = rotate.reverseRow(mat);
		rotate.print(mat);
	}
	
	int[][] reverseRow(int[][] mat) {
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length/2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][mat[i].length-j-1];
				mat[i][mat[i].length - j - 1] = temp;
			}
		}
		return mat;
	}
	
	int[][] transpose(int[][] mat) {
		
		for(int i=0; i<mat.length; i++) {
			for(int j = i; j<mat[i].length; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		return mat;
	}
	
	void clock(int[][] mat) {
	
		Rotate rotate = new Rotate();
		int[][] temp = new int[mat.length][mat[0].length];
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				temp[j][mat[i].length - i - 1] = mat[i][j];
			}
		}
		rotate.print(temp);
		mat = temp;
		rotate.print(mat);
	}
	
	void print(int[][] mat) {
		
		for(int i=0; i<mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println();
	}
}

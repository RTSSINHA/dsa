package bit;

public class Implementations {
	
	public static void main(String args[]) {
		
		int num1 = 5;
		int num2 = 6;
		System.out.println(num1 & 1);
		System.out.println(num2 & 1);
		System.out.println("Multiplication");
		System.out.println(num1 << 3);
		System.out.println(num2 << 3);
		System.out.println("Division");
		System.out.println(num1 >> 1);
		System.out.println(num2 >> 1);
		System.out.println("Xor");
		System.out.println(num1 ^ num2);
		swap(num1, num2);
//		..................................
		System.out.println(isPowerOf2(8));
		System.out.println(getMSB(17));
		
	}
	
	static int getMSB(int n) {
		
		return (int)(Math.log(n)/Math.log(2));
		
	}
	
	static boolean isPowerOf2(int num) {
		
		int power =  num&(num-1);
		return power == 0;
	}
	
	static void swap(int n1, int n2) {
		
		n1 = n1 ^ n2;
		n2 = n2 ^ n1;
		n1 = n1 ^ n2;
		System.out.println("num1: "+n1+"  num2: "+n2);
	}
}

package array;

public class Factors {

	public static void main(String args[]) {
		
//		int num = 10;
//		int num = 100;
		int num = 125;
		
		System.out.println("Number: "+num);
		
		factors(num);
	}
	static void factors(int num) {
		
		for(int i=1; i<=num/2; i++) {
			if(num % i == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.print(num+"\n");
	}
}

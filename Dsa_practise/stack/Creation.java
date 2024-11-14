package stack;

public class Creation {
	
	int top=-1;
	int[] arr;
	int capacity;
	int size = 0;
	
	Creation(int capacity) {
		this.arr = new int[capacity];
		this.capacity = capacity;
	}
	
	void push(int num) {
		
		if(size == capacity) {
			System.out.println("Stack is full");
			return;
		}
		arr[++top] = num;
		size++;
	}
	
	int peek() {
		
		if(size == 0) return -1;
		return arr[top];
	}
	
	int pop() {
		
		if(size == 0) {
			System.out.println("No element in stack");
			return -1;
		}
		int top_element = arr[top];
		top--;
		size--;
		return top_element;
	}
	
	void print() {
		
		int curr = top;
		while(curr >= 0) {
			System.out.print(arr[curr]+" ");
			curr--;
		}
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		Creation stk = new Creation(5);
		stk.print();
		System.out.println(stk.pop());
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.print();
		System.out.println(stk.pop());
		System.out.println(stk.peek());
		stk.push(6);
		stk.push(7);
		stk.print();
		
	}
}

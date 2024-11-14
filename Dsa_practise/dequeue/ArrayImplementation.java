package dequeue;
import java.util.*;

public class ArrayImplementation {
	
	int[] arr;
	int rear;
	int front;
	int size;
	
	ArrayImplementation(int capacity) {
		arr = new int[capacity];
		front = -1;
		rear = 0;
		size = 0;
	}
	
	boolean isFull() {
		return ((front == 0 && rear == arr.length-1) || front == rear + 1);
	}
	
	boolean isEmpty() {
		return front == -1;
	}
	
	void addFront(int num) {
		
		if(isFull()) {
			System.out.println("Dequeue is full");
			return;
		}
		if(front == -1) {
			front = rear = 0;
		} else if(front == 0) {
			front = arr.length - 1;
		} else front = front - 1;
		arr[front] = num;
	}
	
	void deleteFront() {
		
		if(isEmpty()) {
			return;
		}
		
		if(front == 0 && rear == 0) {
			front = rear = -1;
		} else if(front == arr.length - 1) {
			front = 0;
		} else front = front + 1;
	}
	
	void deleteRear() {
		
		if(isEmpty()) {
			return;
		}
		if(front == 0 && rear == 0) {
			front = rear = -1;
		} else if(rear == 0) rear = arr.length - 1;
		else rear = rear - 1;
	}
	
	void addRear(int num) {
		
		if(isFull()) {
			System.out.println("Dequeue is full");
			return;
		}
		
		if(front == -1) {
			front = rear = 0;
		} else if(rear == arr.length - 1) {
			rear = 0;
		} else rear = rear + 1;
		arr[rear] = num;
	}
	
	int getRear() {
		
		if(isEmpty()) return -1;
		return arr[rear];
	}
	
	int getFront() {
		
		if(isEmpty()) return -1;
		return arr[front];
	}
	
	void print() {
		
		int curr = rear;
		while(curr < front) {
			System.out.print(arr[curr] + " ");
			curr = curr + 1;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		ArrayImplementation dq = new ArrayImplementation(5);
		
		System.out.println("Insert element at rear end  : 5 ");
        dq.addRear(5);
        
        System.out.println("insert element at rear end : 10 ");
        dq.addRear(10);
        
        System.out.println("get rear element : "+ dq.getRear());
        
        dq.deleteRear();
        System.out.println("After delete rear element new rear become : " + 
                               dq.getRear());
        
        System.out.println("inserting element at front end");
        dq.addFront(15);
        
        System.out.println("get front element: " +dq.getFront());
        
        dq.deleteFront();
        
        System.out.println("After delete front element new front become : " +
                                   +  dq.getFront());
		
		
		
		
//		dequeue.addFront(1);
//		dequeue.addFront(2);
//		dequeue.addFront(3);
//		dequeue.addRear(4);
//		dequeue.addRear(5);
//		dequeue.print();
//		
		
	}
}

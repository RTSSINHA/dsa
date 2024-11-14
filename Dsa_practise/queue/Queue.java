package queue;
import java.util.*;

public class Queue {
	
	int front = 0;
	int rear = -1;
	int size = 0;
	int capacity;
	int[] arr;
	
	Queue(int num) {
		this.capacity = num;
		this.arr = new int[num];
	}
	
	void enqueue(int num) {
		
		if(size == capacity) {
			System.out.println("Queue overflow");
			return;
		}
		rear = (rear + 1) % capacity;
		this.arr[rear] = num;
		size++;
	}
	
	int dequeue() {
		
		if(size == 0) {
			System.out.println("Queue underflow");
			return -1;
		}
		
		int rem = arr[front];
		front = (front + 1) % capacity;
		size--;
		return rem;
	}
	
	void print() {
		
		int temp = 0;
		int i = front;
		while(temp < size) {
			System.out.print(arr[i] + " ");
			i = (i + 1) % capacity;
			temp++;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.print();
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.print();
		q.enqueue(10);
		q.enqueue(11);
		q.print();
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(12);
		q.enqueue(13);
		q.enqueue(14);
		q.enqueue(15);
		q.print();
	}
	
}

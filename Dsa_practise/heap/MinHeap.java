package heap;

public class MinHeap {
	
	int[] heap;
	int capacity;
	int size = 0;
	
	MinHeap(int capacity) {
		this.heap = new int[capacity];
		this.capacity = capacity;
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	int left(int i) {
		return (2 * i) + 1;
	}
	
	int right(int i) {
		return (2*i) + 2;
	}
	
	void swap(int[] arr, int source, int target) {
		int temp = arr[source];
		arr[source] = arr[target];
		arr[target] = temp;
	}
	
	void insert(int num) {
		
		if(size == capacity) {
			System.out.println("Heap is full!");
			return;
		}
		
		int i = size;
		heap[i] = num;
		while(i >=0 && heap[i] < heap[parent(i)]) {
			swap(heap, i, parent(i));
			i = parent(i);
		}
		
		size++;
		return;
	}
	
	int getMini() {
		return heap[0];
	}
	
	void print() {
		
		for(int i=0; i<=size; i++) {
			System.out.print(heap[i]+" ");
		}
	}
	
	int extractMin() {
		
		if(size == 0) {
			System.out.println("No elements in the heap.");
			return -1;
		}
		
		if(size == 1) {
			size--;
			return heap[0];
		}
		
		int min = heap[0];
		heap[0] = heap[size-1];
		minHeapify(0);
		size--;
		return min;
	}
	
	void minHeapify(int key) {
		
		int smallest = key;
		int left = left(key);
		int right = right(key);
		
		if(smallest < size && heap[left] < heap[smallest]) smallest = left;
		if(smallest < size && heap[right] < heap[smallest]) smallest = right;
		
		if(smallest != key) {
			swap(heap, key, smallest);
			minHeapify(smallest);
		}
	}
	
	public static void main(String args[]) {
		
		MinHeap heap = new MinHeap(11);
		heap.insert(3);
		heap.insert(2);
		heap.insert(10);
		heap.insert(7);
		System.out.println(heap.getMini());
		System.out.println(heap.extractMin());
		System.out.println(heap.getMini());
		System.out.println(heap.extractMin());
		System.out.println(heap.getMini());
		heap.print();
		
	}
}

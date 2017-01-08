package org.nik.queue.impl;

public class CircularArrayQueue {

	private static int CAPACITY = 16;

	private int size, front, end = 0;

	private int[] arr = null;

	public CircularArrayQueue() {
		this(CAPACITY);
	}

	public CircularArrayQueue(int capacity) {
		CAPACITY = capacity;
		arr = new int[CAPACITY];
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enQueue(int data) throws Exception {
		if (size == CAPACITY) {
			throw new Exception("Queue is full!");
		} else {
			arr[end] = data;
			end = ++end % CAPACITY;
			size++;
		}
	}

	public int deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is Empty!!");
		} else {
			int data = arr[front];
			arr[front] = Integer.MIN_VALUE;
			front = ++front % CAPACITY;
			size--;
			return data;
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < size-1; i++) {
			result += arr[front + i % CAPACITY ]+ ", ";
		}
		result += arr[(front + size-1) % CAPACITY ];
		return result;
	}

	public static void main(String[] args) throws Exception {
		CircularArrayQueue arrayQueue = new CircularArrayQueue(4);
		arrayQueue.enQueue(1);
		arrayQueue.enQueue(2);
		arrayQueue.enQueue(3);
		arrayQueue.enQueue(4);
		arrayQueue.toString();
		System.out.println();
	}
}

package org.nik.queue.impl;

public class DynamicCircularArrayQueue {

	private static int CAPACITY = 2;

	private int size, front, end = 0;

	private int[] queueRep = null;

	public DynamicCircularArrayQueue() {
		this(CAPACITY);
	}

	public DynamicCircularArrayQueue(int capacity) {
		CAPACITY = capacity;
		queueRep = new int[CAPACITY];
	}

	public void enQueue(int data) throws Exception {
		if (size == CAPACITY) {
			expand();
		}
		queueRep[end] = data;
		end = ++end % CAPACITY;
		size++;
	}

	private void expand() {
		int arr[] = new int[size << 1];
		for (int i = 0; i <= size - 1; i++) {
			arr[i] = queueRep[front + i % CAPACITY];
		}
		CAPACITY = size << 1;
		front = 0;
		end = size;
		queueRep = arr;
	}
}

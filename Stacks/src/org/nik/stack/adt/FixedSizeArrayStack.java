package org.nik.stack.adt;

public class FixedSizeArrayStack {

	private int[] stackArray;

	private int capacity;

	private static final int CAPACITY = 10;

	private int top = -1;

	public FixedSizeArrayStack() {
		this(CAPACITY);
	}

	public FixedSizeArrayStack(int cap) {
		this.capacity = cap;
		stackArray = new int[cap];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public void push(int data) throws Exception {
		if (capacity == size()) {
			throw new Exception("Stack is Full!!");
		}
		stackArray[top++] = data;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty!!");
		}
		int data = stackArray[top];
		stackArray[top--] = Integer.MIN_VALUE;
		return data;
	}

	public int top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty!!");
		}
		return stackArray[top];
	}
	
}

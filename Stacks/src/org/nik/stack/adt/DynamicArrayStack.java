package org.nik.stack.adt;

public class DynamicArrayStack {

	private static final int CAPACITY = 16;

	private int capacity;

	private int top = -1;

	private int[] stackRep;

	public DynamicArrayStack() {
		this(CAPACITY);
	}

	public DynamicArrayStack(int capacity) {
		this.capacity = capacity;
		stackRep = new int[capacity];
	}

	public int getSize() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public int top() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is Empty!");
		}
		return stackRep[top];
	}

	private void push(int data) {
		if (this.getSize() == capacity) {
			expand();
		}
		stackRep[++top] = data;
	}

	private int pop() throws Exception {
		if (top < 0) {
			throw new Exception("Stack is Empty!");
		}
		int data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		return data;
	}

	private void expand() {
		int length = this.getSize();
		this.capacity = length << 1;
		int[] newStack = new int[this.capacity];
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep = newStack;
	}

	public static void main(String[] args) throws Exception {
		DynamicArrayStack arrayStack = new DynamicArrayStack();
		for (int i = 1; i < 34; i++) {
			arrayStack.push(i);
		}
		System.out.println(arrayStack.pop());
	}

}

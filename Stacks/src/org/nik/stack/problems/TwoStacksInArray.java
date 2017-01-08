package org.nik.stack.problems;

import java.util.EmptyStackException;

public class TwoStacksInArray {

	private int[] stackArray;

	private int size, firstIndex, secondIndex;

	public TwoStacksInArray(int size) {
		if (size < 2) {
			throw new IllegalAccessError("size of TwoStacksInArray cannot be null!!!");
		}
		this.size = size;
		stackArray = new int[size];
		firstIndex = -1;
		secondIndex = size;
	}

	public void push(int stackIndex, int data) {
		if (secondIndex - firstIndex == 1) {
			throw new StackOverflowError("Stack if full");
		}
		if (stackIndex == 1) {
			stackArray[++firstIndex] = data;
		} else if (stackIndex == 2) {
			stackArray[--secondIndex] = data;
		}
	}

	public int pop(int stackIndex) {
		if (stackIndex == 1) {
			if (firstIndex == -1) {
				throw new EmptyStackException();
			} else {
				int returnValue = stackArray[firstIndex];
				stackArray[firstIndex] = Integer.MIN_VALUE;
				firstIndex--;
				return returnValue;
			}
		} else if (stackIndex == 2) {
			if (firstIndex == -1) {
				throw new EmptyStackException();
			} else {
				int returnValue = stackArray[secondIndex];
				stackArray[secondIndex] = Integer.MIN_VALUE;
				secondIndex++;
				return returnValue;
			}
		} else {
			return -1;
		}
	}

	public int top(int stackIndex) {
		if (stackIndex == 1) {
			if (firstIndex == -1) {
				throw new EmptyStackException();
			} else {
				return stackArray[firstIndex];
			}
		} else if (stackIndex == 2) {
			if (firstIndex == -1) {
				throw new EmptyStackException();
			} else {
				return stackArray[secondIndex];
			}
		} else {
			return -1;
		}
	}
	
	
	
	public boolean isEmpty(int stackIndex){
		if(stackIndex == 1){
			return firstIndex ==-1;
		}else if (stackIndex == 2){
			return secondIndex == size;
		}else{
			return true;
		}
	}
}
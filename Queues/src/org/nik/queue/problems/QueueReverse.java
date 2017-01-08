package org.nik.queue.problems;

import java.util.Stack;

import org.nik.queue.impl.CircularArrayQueue;

public class QueueReverse {

	
	public static void main(String[] args) throws Exception {
		CircularArrayQueue arrayQueue = new CircularArrayQueue();
		arrayQueue.enQueue(1);
		arrayQueue.enQueue(2);
		arrayQueue.enQueue(3);
		arrayQueue.enQueue(4);
		System.out.println(arrayQueue);
		reverUsingRecursion(arrayQueue);
		System.out.println(arrayQueue);
		reverseUsingStack(arrayQueue);
		System.out.println(arrayQueue);
	}

	private static void reverUsingRecursion(CircularArrayQueue arrayQueue) throws Exception {
		if(arrayQueue.getSize() ==1){
			int lastElement = arrayQueue.deQueue();
			arrayQueue.enQueue(lastElement);
			return;
		}
		int current = arrayQueue.deQueue();
		reverUsingRecursion(arrayQueue);
		arrayQueue.enQueue(current);		
	}
	
	private static void reverseUsingStack(CircularArrayQueue arrayQueue) throws Exception{
		Stack<Integer> stack = new Stack<>();
		while(!arrayQueue.isEmpty()){
			stack.push(arrayQueue.deQueue());
		}
		while(!stack.isEmpty()){
			arrayQueue.enQueue(stack.pop());
		}
	}	
}

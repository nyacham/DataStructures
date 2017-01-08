package org.nik.queue.problems;

import java.util.Stack;

public class QueueUsingStack<T> {

	private Stack<T> stack1 = new Stack<>();

	private Stack<T> stack2 = new Stack<>();

	public void enQueue(T data) {
		stack1.push(data);
	}

	public T deQueue() {
		if(!stack2.isEmpty()){
			return stack2.pop();
		}else if(!stack1.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}else{
			return null;
		}
	}
	
	public static void main(String[] args) {
		QueueUsingStack<Integer> queue = new QueueUsingStack<>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}

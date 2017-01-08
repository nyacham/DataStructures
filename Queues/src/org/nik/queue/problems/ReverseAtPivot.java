package org.nik.queue.problems;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class ReverseAtPivot {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedBlockingQueue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4); 
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		reverseAtPivot(queue, 4);
		System.out.println(queue);
	}

	/**
	 * @param queue
	 * @param k
	 * 
	 * 
	 */
	private static void reverseAtPivot(Queue<Integer> queue, int k) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			stack.push(queue.remove());
		}
		for (int i = 0; i < k; i++) {
			queue.add(stack.pop());
		}
		for (int i = 0; i < queue.size()-k; i++) {
			queue.add(queue.remove());
		}
	}
}

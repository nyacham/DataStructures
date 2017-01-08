package org.nik.queue.problems;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author NIKHILESH
 * 
 *         halves the queue and inserts alternatively, like the pattern below
 *
 *         1 2 3 4 5 6
 * 
 *         4 5 6 3 2 1
 * 
 *         3 2 1 4 5 6
 * 
 *         4 5 6
 * 
 *         1 4 2 5 3 6
 * 
 */
public class QueueShufflePattern {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedBlockingQueue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		shuffle(queue);
		System.out.println(queue);
	}

	private static void shuffle(Queue<Integer> queue) {
		int size = queue.size();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < size/ 2; i++) {
			stack.push(queue.remove());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		for (int i = 0; i < size/ 2; i++) {
			queue.add(queue.remove());
		}
		for (int i = 0; i < size/ 2; i++) {
			stack.push(queue.remove());
		}
		for (int i = 0; i < size/ 2; i++) {
			queue.add(stack.pop());
			queue.add(queue.remove());
		}
	}
}

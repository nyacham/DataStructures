package org.nik.queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SuccessivePairs {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(5);
		stack.push(2);
		stack.push(3);
		stack.push(11);
		stack.push(10);
		stack.push(6);
		boolean result = isAllStackElementsSuccessivePairs(stack);
		System.out.println(result);
	}

	private static boolean isAllStackElementsSuccessivePairs(Stack<Integer> stack) {
		boolean result = true;
		Queue<Integer> queue = new LinkedList<>();
		while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		while(!queue.isEmpty()){
			stack.add(queue.remove());
		}
		while(!stack.isEmpty()){
			int m = stack.pop();
			queue.add(m);
			if(!stack.isEmpty()){
				int n = stack.pop();
				queue.add(n);
				if(!isDiffOne(m, n)){
					result = false;
				}
			}
		}
		while(!queue.isEmpty()){
			stack.push(queue.remove());
		}
		return result;
	}

	private static boolean isDiffOne(int x, int y) {
		return x-y ==1||x-y==-1; 
	}

}

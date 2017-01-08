package org.nik.stack.problems;

import java.util.Stack;

/**
 * 
 * Reverse a stack using just push and pop operations
 * 
 * @author NIKHILESH
 *
 */
public class StackReversal {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		reverseStack(stack);
		System.out.println(stack);
	}

	private static void reverseStack(Stack<Integer> stack) {
		if(stack.size() ==1){
			return;
		}else{
			int data = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, data);
		}
	}

	private static void insertAtBottom(Stack<Integer> stack, int data) {
		if(stack.isEmpty()){
			stack.push(data);
			return;
		}
		else{
			int current = stack.pop();
			insertAtBottom(stack, data);
			stack.push(current);
		}
	}

}

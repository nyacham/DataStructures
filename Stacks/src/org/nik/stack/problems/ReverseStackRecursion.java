package org.nik.stack.problems;

import java.util.Stack;

public class ReverseStackRecursion {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		reverse(stack);
	}

	private static Integer reverse(Stack<Integer> stack) {
		if(stack.size()==1){
			return stack.pop();
		}
		int item = stack.pop();
		reverse(stack);
		stack.push(item);
		return item;
	}
}

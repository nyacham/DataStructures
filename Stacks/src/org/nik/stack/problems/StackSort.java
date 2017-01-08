package org.nik.stack.problems;

import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		sortStack(stack);
		sort(stack);
		System.out.println(stack);	
	}

	private static void sort(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return;
		}
		int curVal = stack.pop();
		sort(stack);
		sortIt(stack, curVal);
	}

	/**
	 * This is Similar to push to the base in stack reversal problem, except the element 
	 * will be pushed to the of the top is smaller than the inserted element.  
	 * @param stack
	 * @param curVal
	 */
	private static void sortIt(Stack<Integer> stack, int curVal) {
		if (stack.isEmpty() || stack.peek() <= curVal) {
			stack.push(curVal);
			return;
		}

		int data = stack.pop();
		sortIt(stack, curVal);
		stack.push(data);
		return;
	}
	
	/**
	 * 
	 *  1 2 3
	 * this method used to sort the stack by using an Extra Stack, space complexity is O(n) for the extra stack 
	 * @param stack
	 */
	private static Stack<Integer> sortStack(Stack<Integer> stk){
		Stack<Integer> rst = new Stack<>();
		while(!stk.isEmpty()){
			int tmp = stk.pop();
			while(!rst.isEmpty() && rst.peek()>tmp){
				stk.push(rst.pop());
			}
			rst.push(tmp);
		}
		return rst;
	}

}
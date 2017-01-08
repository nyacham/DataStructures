package org.nik.stack.problems;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int [] input = {11, 13, 21, 3};
		printNextGreater(input);
	}	

	private static void printNextGreater(int[] input) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			while(!stack.isEmpty() && stack.peek()<input[i]){
				System.out.println(stack.pop()+" ->"+input[i]);
			}
			stack.push(input[i]);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+" ->"+-1);
		}
		
	}
}

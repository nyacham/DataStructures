 package org.nik.stack.problems;

import java.util.Stack;

public class PrintNextGreateElement {

	public static void main(String[] args) {
		printNextGreateElement(new int[]{4,5,2,25});
	}

	private static void printNextGreateElement(int arr[]) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			while(!stack.isEmpty() && stack.peek()<current){
				System.out.println(stack.pop()+" -> "+current);
			}
			stack.push(current);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+" -> -1");
		}
	}
}

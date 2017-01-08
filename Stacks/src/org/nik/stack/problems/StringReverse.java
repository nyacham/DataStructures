package org.nik.stack.problems;

import java.util.Stack;

public class StringReverse {

	public static void main(String[] args) {
		String name = "Nikhilesh";
		printReverse(name);
	}
	
	private static void printReverse(String str){
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		String reverse = "";
		while(!stack.isEmpty()){
			reverse =reverse+stack.pop();
		}
		System.out.println(reverse);
	}
}

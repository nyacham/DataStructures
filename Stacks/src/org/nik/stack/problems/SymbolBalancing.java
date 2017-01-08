package org.nik.stack.problems;

import java.util.Scanner;
import java.util.Stack;

public class SymbolBalancing {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.next();
		scanner.close();
		System.out.println(testBalancing(expression));
				
	}

	private static boolean testBalancing(String expression) {
		Stack<Character> stack = new Stack<>();
		if(null != expression && !expression.trim().isEmpty()){
			for (int i = 0; i < expression.length(); i++) {
				if(expression.charAt(i) == ')'){
					if(!stack.isEmpty() && stack.peek() == '('){
						stack.pop();
					}else return false;
				}else if (expression.charAt(i) == ']'){
					if(!stack.isEmpty() && stack.peek() == '['){
						stack.pop();
					}else return false;
				}else if (expression.charAt(i) == '}'){
					if(!stack.isEmpty() && stack.peek() == '{'){
						stack.pop();
					}else return false;
				}else{
					if(expression.charAt(i) == '('||expression.charAt(i) =='{'||expression.charAt(i)  =='[')
					stack.push(expression.charAt(i));
				}
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		return false;
	}
}

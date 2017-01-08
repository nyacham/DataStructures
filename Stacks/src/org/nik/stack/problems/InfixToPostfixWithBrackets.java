package org.nik.stack.problems;

import java.util.Stack;

public class InfixToPostfixWithBrackets {

	public static void main(String[] args) {
		String infix = "((A*(B+C))/D)";// A B + C * D - E * // A B + C * D - E *
		printPostfixExpression(infix);
		System.out.println();	
		printPrefixExpression(infix);
	}

	private static void printPostfixExpression(String infix) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < infix.length(); i++) {
			char j = infix.charAt(i);
			if ((j >= 'a' && j <= 'z') || (j >= 'A' && j <= 'Z') || (j >= '0' && j <= '9')) {
				System.out.print(j);
			} else if (j =='('){
				stack.push(j);
			}else if (j == ')'){
				while(!stack.isEmpty() && isNotOpeningParanthesis(stack.peek())){
					System.out.print(stack.pop());
				}
				stack.pop();
			}else{
				while(!stack.isEmpty() && getPrec(j)<=getPrec(stack.peek()) && isNotOpeningParanthesis(stack.peek())){
					System.out.print(stack.pop());
				}
				stack.push(j);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	
	private static void printPrefixExpression(String infix) {
		String result = "";
		Stack<Character> stack = new Stack<Character>();
		for (int i = infix.length()-1; i >= 0 ; i--) {
			char j = infix.charAt(i);
			if ((j >= 'a' && j <= 'z') || (j >= 'A' && j <= 'Z') || (j >= '0' && j <= '9')) {
				result = j+ result;
			} else if (j ==')'){
				stack.push(j);
			}else if (j == '('){
				while(!stack.isEmpty() && isNotClosingParanthesis(stack.peek())){
					result = stack.pop()+result;
				}
				stack.pop();
			}else{
				while(!stack.isEmpty() && getPrec(j)<getPrec(stack.peek()) && isNotClosingParanthesis(stack.peek())){
					result = stack.pop()+result;
				}
				stack.push(j);
			}
		}
		while (!stack.isEmpty()) {
			result = stack.pop()+result;
		}
		System.out.println(result);
	}

	private static boolean isNotOpeningParanthesis(char j) {
		return j != '(';
	}

	private static boolean isNotClosingParanthesis(char j) {
		return j != ')';
	} 
	
	private static int getPrec(Character c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

}

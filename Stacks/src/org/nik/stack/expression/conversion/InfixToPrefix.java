package org.nik.stack.expression.conversion;

import java.util.Stack;

/**
 * 
 * Scan from right to left, push ) and start popping after (
 * 
 * @author NIKHILESH
 *
 */
public class InfixToPrefix {

	public static void main(String[] args) {
		String infix = "5 * ( 10 + 2 * 6 )";
		String prefix = convert(infix);
		System.out.println(prefix);
	}

	private static String convert(String infix) {
		String returnVal = "";
		Stack<Character> stack = new Stack<>();
		for (int i = infix.length()-1; i >=0; i--) {
			char j = infix.charAt(i);
			if (j == ' ') {
				continue;
			} else if (j == ')') {
				stack.push(j);
			} else if (isNumber(j)) {
				String num = j + "";
				while (i >1  && infix.charAt(i - 1) != ' ' && isNumber(infix.charAt(i - 1))) {
					num =  infix.charAt(--i)+num ;
				}
				returnVal = num+" "+returnVal;
			} else if (j == '(') {
				while (!stack.isEmpty() && isNotClosingParanthesis(stack.peek())) {
					returnVal = stack.pop()+" "+returnVal;
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && isNotClosingParanthesis(stack.peek()) && precedence(stack.peek()) >= precedence(j)) {
					returnVal = stack.pop()+" "+returnVal;
				}
				stack.push(j);
			}
		}
		while (!stack.isEmpty()) {
			returnVal = stack.pop()+" "+returnVal;
		}
		return returnVal;
	}
	
	private static int precedence(Character ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	private static boolean isNotClosingParanthesis(Character peek) {
		return peek != ')';
	}

	private static boolean isNumber(char j) {
		return j >= '0' && j <= '9' || j >= 'A' && j <= 'Z';
	}
}
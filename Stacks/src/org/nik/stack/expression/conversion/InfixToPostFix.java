package org.nik.stack.expression.conversion;

import java.util.Stack;


/**
 * 
 * Scan from left to right, push ( and start popping after )
 * 
 * @author NIKHILESH
 *
 */

public class InfixToPostFix {

	public static void main(String[] args) {

		String infix = "((A+B)*C-D)*E";// 5 3 + 12 * 13 /
		String postfix = convert(infix);
		System.out.println(postfix);

	}

	private static String convert(String infix) {
		String returnVal = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char j = infix.charAt(i);
			if (j == ' ') {
				continue;
			} else if (j == '(') {
				stack.push(j);
			} else if (isNumber(j)) {
				String num = j + "";
				while (i < infix.length() - 1 && infix.charAt(i + 1) != ' ' && isNumber(infix.charAt(i + 1))) {
					num = num + infix.charAt(++i);
				}
				returnVal = returnVal + " " + num;
			} else if (j == ')') {
				while (!stack.isEmpty() && isNotOpeningParanthesis(stack.peek())) {
					returnVal = returnVal + " " + stack.pop();// (2+3*4) 234*+
				}
				stack.pop();// popping out opening parathesis
			} else {
				while (!stack.isEmpty() && isNotOpeningParanthesis(stack.peek()) && precedence(stack.peek()) >= precedence(j)) {
					returnVal = returnVal + " " + stack.pop();
				}
				stack.push(j);
			}
		}
		while (!stack.isEmpty()) {
			returnVal = returnVal + " " + stack.pop();
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

	private static boolean isNotOpeningParanthesis(Character peek) {
		return peek != '(';
	}

	private static boolean isNumber(char j) {
		return j >= '0' && j <= '9' || j >= 'A' && j <= 'Z';
	}
}

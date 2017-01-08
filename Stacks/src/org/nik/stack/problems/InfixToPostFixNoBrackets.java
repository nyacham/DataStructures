package org.nik.stack.problems;

import java.util.Stack;

public class InfixToPostFixNoBrackets {

	public static void main(String[] args) {
		String infix = "A+B*C-D*E";
		printPostFix(infix);
		System.out.println();
		printPreFix(infix);
	}

	private static void printPostFix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < infix.length(); i++) {
			char j = infix.charAt(i);
			if((j>='a'&& j<='z')||(j>='A'&& j<='Z')||(j>='0'&& j<='9')){
				System.out.print(j);
			}else{
				while(!stack.isEmpty() && getPrec(stack.peek())>=getPrec(j)){
					System.out.print(stack.pop());
				}
				stack.push(j);
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	
	private static void printPreFix(String infix) {
		String prefix = "";
		Stack<Character> stack = new Stack<Character>();
		for (int i = infix.length()-1; i >=0 ; i--) {
			char j = infix.charAt(i);
			if((j>='a'&& j<='z')||(j>='A'&& j<='Z')||(j>='0'&& j<='9')){
				prefix = j+prefix;
			}else{
				while(!stack.isEmpty() && getPrec(stack.peek())>getPrec(j)){
					prefix = stack.pop()+prefix;
				}
				stack.push(j);
			}
		}
		while(!stack.isEmpty()){
			prefix = stack.pop()+prefix;
		}
		System.out.println(prefix);
	}

	private static int getPrec(Character c) {
		switch(c){
			case '+':
				return 1;
			case '-':
				return 1;
			case '*':
				return 2;
			case '^':
				return 3;
			default:
				return -1;
		}
	}
}
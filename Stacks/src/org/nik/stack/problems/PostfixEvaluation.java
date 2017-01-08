package org.nik.stack.problems;

import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) {
		String postFixExpression = "123*+5-";
		int value = evaulatePostFix(postFixExpression);
		System.out.println(value);
	}

	private static int evaulatePostFix(String postFixExpression) {
		Stack<Integer> stack = new Stack<>();
		if(null != postFixExpression && !postFixExpression.trim().isEmpty()){
			for (int i = 0; i < postFixExpression.length(); i++) {
				if(isOperand(postFixExpression.charAt(i))){
					stack.push(Integer.valueOf(postFixExpression.charAt(i)-'0'));
				}else{
					int second = stack.pop();
					int first = stack.pop();
					stack.push(performEvaluation(first, second,  postFixExpression.charAt(i)));
				}
			}
		}
		return !stack.isEmpty()?stack.pop():-1;
	}

	private static int performEvaluation(Integer first, Integer second, char operation) {
		switch(operation){
		case '+':
			return first+second;
		case '-':
			return first-second;
		case '*':
			return first*second;
		case '/':
			return first/second;
		}
		return 0;
	}

	private static boolean isOperand(char character) {		
		return (character>='a' && character<='z' || character>='A' && character<='Z' ||character>='0' && character<='9');
	}
}

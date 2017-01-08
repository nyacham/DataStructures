package org.nik.stack.expression.evaluation;

import java.util.Stack;

public class InfixEvaluation {

	public static void main(String[] args) {
		String infix = "5 * ( 10 + 2 * 6 )";
		Integer value = evaluate(infix);
		System.out.println(value);
	}

	private static Integer evaluate(String infix) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char j = infix.charAt(i);
			if(j ==' '){
				continue;
			}else if (isNumber(j)){
				String result = j+"";
				while(i<infix.length()-1 && isNumber(infix.charAt(i+1))){
					result = result+infix.charAt(++i);
				}
				operands.push(Integer.valueOf(result));
			}else if(j == '('){
				operators.push(j);
			}else if (j ==')'){
				while(!operands.isEmpty() && !operators.isEmpty() && isNotOpeningParanthesis(operators.peek())){
					int second = operands.pop();
					int first = operands.pop();
					char operation = operators.pop();
					operands.push(evaluate(second, first, operation));
				}
				operators.pop();
			}else {
				while(!operators.isEmpty() && precedence(j)<=precedence(operators.peek()) && isNotOpeningParanthesis(operators.peek())){
					int second = operands.pop();
					int first = operands.pop();
					char operation = operators.pop();
					operands.push(evaluate(second, first, operation));
				}
				operators.push(j);
			}
		}
		while(!operators.isEmpty()){
			int second = operands.pop();
			int first = operands.pop();
			char operation = operators.pop();
			operands.push(evaluate(second, first, operation));
		}
		return operands.pop();
	}
	
	private static int evaluate(int second, int first, char operation) {
		switch (operation) {
		case '+':
			return first+second;
		case '-':
			return first-second;
		case '*':
			return first*second;
		default:
			return -1;
		}
		
	}

	private static boolean isNotOpeningParanthesis(Character peek) {
		return peek != '(';
	}

	private static boolean isNumber(char j) {
		return j >= '0' && j <= '9';
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
}

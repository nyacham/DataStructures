package org.nik.stack.problems;

import java.util.Stack;

/**
 * 
 * Given a String formed with a's and b's with middle element 'X' find the
 * string is palindrome or not
 * 
 * @author NIKHILESH
 *
 */
public class PalindromeOrNotX {

	public static void main(String[] args) {
		String input = "aaabbbbabXbabbbbaaa";
		System.out.println(isPalindrome(input));
		System.out.println(isPalindromeStr(input));
	}

	private static boolean isPalindrome(String input) {
		if (input == null || input.length() % 2 == 0 || input.charAt(input.length() / 2) != 'X') {
			return false;
		} else {
			int i = 0;
			Stack<Character> stack = new Stack<>();
			while (input.charAt(i) != 'X') {
				stack.push(input.charAt(i++));
			}
			i++;
			while (!stack.isEmpty()) {
				if (stack.pop() != input.charAt(i++)) {
					return false;
				}
			}
			return true;
		}

	}

	/**
	 * Conventional method of testing a palindrome
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isPalindromeStr(String input) {
		int i = 0, j = input.length() - 1;
		while (input.charAt(i) == input.charAt(j) && i < j) {
			i++;
			j--;
		}
		if (i != j) {
			return false;
		}
		return true;
	}
}

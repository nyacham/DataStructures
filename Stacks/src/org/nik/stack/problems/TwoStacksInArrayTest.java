package org.nik.stack.problems;

public class TwoStacksInArrayTest {

	public static void main(String[] args) {
		TwoStacksInArray twoStacks = new TwoStacksInArray(10);
		System.out.println(twoStacks.isEmpty(1));
		System.out.println(twoStacks.isEmpty(2));
		for (int i = 0; i < 5; i++) {
			twoStacks.push(1, i+1);
			twoStacks.push(2, i+1);
		}
		twoStacks.pop(1);
		twoStacks.pop(2);
	}
}

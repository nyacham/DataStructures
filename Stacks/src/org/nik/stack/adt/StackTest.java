package org.nik.stack.adt;

public class StackTest {
	
	public static void main(String[] args) throws Exception {
		FixedSizeArrayStack stack = new FixedSizeArrayStack();
		stack.push(1);
		stack.push(1);
		System.out.println(stack.size());
		stack.pop();
		System.out.println(stack.size());
	}

}

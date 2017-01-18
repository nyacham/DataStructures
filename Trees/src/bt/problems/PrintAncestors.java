package bt.problems;

import java.util.Stack;

import bt.ds.BSTNode;

public class PrintAncestors {

	public static void main(String[] args) {
		printAncestors(BSTNode.getDefaultTree(), 9);
	}

	private static void printAncestors(BSTNode root, int child) {
		Stack<BSTNode> stack = new Stack<>();
		BSTNode temp = root;
		BSTNode prevPopped = null;
		if (null != root) {
			stack.push(root);
			if (root.getData() == child) {
				return;
			}
		}
		while (!stack.isEmpty()) {
			if (null != temp.getLeft()) {
				if (temp.getLeft().getData() == child) {
					while (!stack.isEmpty()) {
						System.out.println(stack.pop().getData());
					}
				}
				temp = temp.getLeft();
				stack.push(temp);
			} else {
				BSTNode current = stack.peek();
				if (null != current.getRight() && current.getRight() != prevPopped) {
					if (current.getRight().getData() == child) {
						while (!stack.isEmpty()) {
							System.out.println(stack.pop().getData());
						}
					}
					temp = current.getRight();
					stack.push(temp);
				} else {
					prevPopped = stack.pop();
				}
			}
		}
	}
}

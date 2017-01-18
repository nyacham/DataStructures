package bt.problems;

import bt.ds.BSTNode;

public class LeastCommonAncestors {

	private static BSTNode first = null;

	private static BSTNode second = null;

	public static void main(String[] args) {
		BSTNode lca = leastCommonAncestor(getDefautTree(), first, second);
		System.out.println(lca.getData());
	}

	private static BSTNode leastCommonAncestor(BSTNode currentRoot, BSTNode first, BSTNode second) {

		if (null == currentRoot) {
			return null;
		} else if (currentRoot == first || currentRoot == second) {
			return currentRoot;
		} else {
			BSTNode left = leastCommonAncestor(currentRoot.getLeft(), first, second);
			BSTNode right = leastCommonAncestor(currentRoot.getRight(), first, second);
			if (null != left && null != right) {
				return currentRoot;
			} else {
				return left != null ? left : right;
			}
		}
	}

	private static BSTNode getDefautTree() {
		BSTNode one = new BSTNode();
		one.setData(1);
		BSTNode two = new BSTNode();
		two.setData(2);
		one.setLeft(two);
		BSTNode three = new BSTNode();
		three.setData(3);
		one.setRight(three);
		BSTNode four = new BSTNode();
		four.setData(4);
		first = four;
		two.setLeft(four);
		BSTNode five = new BSTNode();
		five.setData(5);
		two.setRight(five);
		second = five;
		BSTNode six = new BSTNode();
		six.setData(6);
		three.setLeft(six);
		BSTNode seven = new BSTNode();
		seven.setData(7);
		three.setRight(seven);
		return one;
	}
}

package bt.trversal;

import bt.ds.BSTNode;

public class PrintAncestorsUnConventional {

	private static BSTNode child = null;

	public static void main(String[] args) {
		BSTNode bTree = getDefaultTree();
		printAncestors(bTree, child);
	}

	private static boolean printAncestors(BSTNode bTree, BSTNode child) {
		if (null != bTree) {
			if (bTree == child) {
				return true;
			}
			if (printAncestors(bTree.getLeft(), child) || printAncestors(bTree.getRight(), child)) {
				System.out.println(bTree.getData());
				return true;
			}
		}
		return false;
	}

	private static BSTNode getDefaultTree() {
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
		two.setLeft(four);
		BSTNode five = new BSTNode();
		five.setData(5);
		two.setRight(five);
		BSTNode six = new BSTNode();
		six.setData(6);
		three.setLeft(six);
		BSTNode seven = new BSTNode();
		seven.setData(7);
		three.setRight(seven);
		BSTNode eight = new BSTNode();
		seven.setRight(eight);
		BSTNode nine = new BSTNode();
		eight.setLeft(nine);
		eight.setData(8);
		BSTNode ten = new BSTNode();
		ten.setData(10);
		nine.setRight(ten);
		nine.setData(9);
		child = ten;
		return one;
	}

}

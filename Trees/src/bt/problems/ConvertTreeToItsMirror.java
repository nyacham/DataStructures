package bt.problems;

import bt.ds.BSTNode;

public class ConvertTreeToItsMirror {
	
	public static void main(String[] args) {
		BSTNode one = new BSTNode(1);
		BSTNode two = new BSTNode(2);
		one.setLeft(two);
		BSTNode three = new BSTNode(3);
		one.setRight(three);
		BSTNode four = new BSTNode(4);
		two.setLeft(four);
		BSTNode five = new BSTNode(5);
		two.setRight(five);
		
		
		BSTNode tree = one;
		convertToMirror(tree);
		System.out.println(tree);
	}

	private static void convertToMirror(BSTNode tree) {
		if(tree == null || (tree.getLeft() ==  null && tree.getRight() == null)){
			return;
		}
		BSTNode tmp = tree.getLeft();
		tree.setLeft(tree.getRight());
		tree.setRight(tmp);
		convertToMirror(tree.getLeft());
		convertToMirror(tree.getRight());
	}

}

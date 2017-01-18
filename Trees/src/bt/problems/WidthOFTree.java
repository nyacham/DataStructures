package bt.problems;

import bt.ds.BSTNode;

public class WidthOFTree {

	private static int height(BSTNode tree) {
		if (null != tree) {
			int left = height(tree.getLeft());
			int right = height(tree.getRight());
			return 1 + ((left > right) ? left : right);
		}
		return 0;
	}

	private static int maxWidth(BSTNode tree) {
		int height = height(BSTNode.getDefaultTree());
		if (height > 0) {
			int max = 0;
			for (int i = 0; i < height; i++) {
				int width = width(tree, i);
				if (max < width) {
					max = width;
				}
			}
			return max;
		}
		return 0;
	}

	private static int width(BSTNode tree, int level) {
		if (null == tree)
			return 0;
		if (0 == level)
			return 1;
		return width(tree.getLeft(), level - 1) + width(tree.getRight(), level - 1);
	}

	public static void main(String[] args) {
		System.out.println(maxWidth(BSTNode.getDefaultTree()));
	}
}
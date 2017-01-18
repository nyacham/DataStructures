package bt.construction;

import bt.ds.BSTNode;

/**
 * 1 2 3 4 5 6 7 Inorder: 4, 2, 5, 1, 6, 3, 7 Postorder: 4, 5, 2, 6, 7, 3, 1
 * Preorder: 1, 2, 4, 5, 3, 6, 7
 *
 */
public class FromInorderPostorder {

	private static int postIndex = 0;

	public static void main(String args[]) {
		int inorder[] = { 4, 2, 5, 1, 6, 3, 7 };
		int postorder[] = { 4, 5, 2, 6, 7, 3, 1 };
		postIndex = postorder.length - 1;
		BSTNode bstNode = fromInorderPostorder(inorder, postorder, 0, postorder.length - 1);
		System.out.println(bstNode);
	}

	private static BSTNode fromInorderPostorder(int[] inorder, int[] postorder, int start, int end) {
		BSTNode root = new BSTNode(postorder[postIndex--]);
		if (start < end) {
			int rootIndex = 0;
			for (int i = 0; i < inorder.length; i++) {
				if (root.getData() == inorder[i]) {
					rootIndex = i;
					break;
				}
			}
			root.setRight(fromInorderPostorder(inorder, postorder, rootIndex + 1, end));
			root.setLeft(fromInorderPostorder(inorder, postorder, start, rootIndex - 1));
		}
		return root;
	}

}

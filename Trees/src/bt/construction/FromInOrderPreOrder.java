package bt.construction;

import bt.ds.BSTNode;

/**
 * Result: 1 2 3 4 5 6 7
 * 
 * Input: Inorder : 4, 2, 5, 1, 6, 3, 7 Preorder: 1, 2, 4, 5, 3, 6, 7
 * 
 * @author NIKHILESH
 *
 */
public class FromInOrderPreOrder {

	private static int preIndex = 0;

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
		BSTNode constructedNode = fromInOrderPreOrder(inorder, preorder, 0, inorder.length - 1);
		System.out.println(constructedNode);
	}

	private static BSTNode fromInOrderPreOrder(int[] inorder, int[] preorder, int inStart, int inEnd) {
		BSTNode currentRoot = new BSTNode(preorder[preIndex++]);
		if (inStart < inEnd) {
			int rootIndex = 0;
			for (int i = 0; i < inorder.length; i++) {
				if (currentRoot.getData() == inorder[i]) {
					rootIndex = i;
					break;
				}
			}
			currentRoot.setLeft(fromInOrderPreOrder(inorder, preorder, inStart, rootIndex - 1));
			currentRoot.setRight(fromInOrderPreOrder(inorder, preorder, rootIndex + 1, inEnd));
		}
		return currentRoot;
	}

}

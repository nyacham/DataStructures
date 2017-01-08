package bt.trversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import bt.ds.BSTNode;

/**
 * @author NIKHILESH
 * 
 * Traversing the binary tree in the following sequence:
 *	
 *	left node,right node and center node, 
 *			which is recursively true for each node
 *	
 *			1
 *		2		3
 *	  4   5	  6   7
 *	Traversal Sequence :4 5 2 6 7 3 1
 *
 */
public class PostOrderTraversal {

	public static void main(String[] args) {
		List<Integer> list = postorderTraversal(BSTNode.getDefaultTree());
		list.forEach(System.out::println);
	}

	private static List<Integer> postorderTraversal(BSTNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<BSTNode> stack = new Stack<>();
		BSTNode temp = root;
		BSTNode prevPopped = null;
		if(null != root){
			stack.push(root);
		}
		while(!stack.isEmpty()){
			if(null != temp.getLeft()){
				temp = temp.getLeft();
				stack.push(temp);
			}else{
				BSTNode current = stack.peek();
				if(null != current.getRight() && current.getRight() != prevPopped){
					temp =current.getRight();
					stack.push(temp);
				}else{
					prevPopped = stack.pop();
					result.add(prevPopped.getData());
				}
			}
		}
		return result;
		
	}
}

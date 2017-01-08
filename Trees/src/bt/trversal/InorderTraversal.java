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
 *	left node,center node and right node, 
 *			which is recursively true for each node
 *	
 *			1
 *		2		3
 *	  4   5	  6   7
 *	Traversal Sequence :4 2 5 1 6 3 7
 *
 */
public class InorderTraversal {

	public static void main(String[] args) {
		List<Integer> list = inorderTraversal(BSTNode.getDefaultTree());
		list.forEach(System.out::println);
	}

	private static List<Integer> inorderTraversal(BSTNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<BSTNode> stack = new Stack<>();
		BSTNode temp = root;
		if(null != root){
			stack.push(root);
		}
		while(!stack.isEmpty()){
			if(null != temp.getLeft()){
				temp = temp.getLeft();
				stack.push(temp);
			}else{
				BSTNode current = stack.pop();
				result.add(current.getData());
				if(null != current.getRight()){
					temp =current.getRight();
					stack.push(temp);
				}
			}
		}
		return result;
		
	}
}

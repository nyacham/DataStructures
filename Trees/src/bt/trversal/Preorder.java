package bt.trversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import bt.ds.BSTNode;

public class Preorder {
	
	public static void main(String[] args) {
		List<Integer> list  =   preOrder(BSTNode.getDefaultTree());
		list.forEach(System.out::println);
	}

	private static List<Integer> preOrder(BSTNode root) {
		Stack<BSTNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		if(null != root){
			stack.push(root);
		}
		while(!stack.isEmpty()){
			BSTNode popped = stack.pop();
			result.add(popped.getData());
			if(null != popped.getRight()){
				stack.push(popped.getRight());
			}
			if(null != popped.getLeft()){
				stack.push(popped.getLeft());
			}
		}
		
		return result;
	}
}

package bt.trversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import bt.ds.BSTNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		List<Integer> traversed = levelOrderTraversal(BSTNode.getDefaultTree());
		traversed.forEach(System.out::println);
	}

	private static List<Integer> levelOrderTraversal(BSTNode root) {
		Queue<BSTNode> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		if (null != root) {
			queue.add(root);
			queue.add(null);
		}
		while (!queue.isEmpty()) {
			BSTNode node = queue.remove();
			if (node != null) {
				result.add(node.getData());
				if (null != node.getLeft()) {
					queue.add(node.getLeft());
				}
				if (null != node.getRight()) {
					queue.add(node.getRight());
				}
			} else {
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			}
		}
		return result;
	}
}

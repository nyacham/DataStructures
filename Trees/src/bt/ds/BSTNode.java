package bt.ds;

public class BSTNode {

	private int data;

	private BSTNode left;

	private BSTNode right;

	public BSTNode(int data) {
		this.data = data;
	}

	public BSTNode() {

	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public static BSTNode getDefaultTree() {
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
		return one;
	}
}
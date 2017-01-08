package com.nik.doublell;

public class Node {

	private Integer value;

	private Node previous;

	private Node next;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(Integer value, Node previous, Node next) {
		super();
		this.value = value;
		this.previous = previous;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", previous=" + previous + ", next=" + next + "]";
	}

}

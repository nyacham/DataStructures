package com.nik.circularll;

public class Node {

	private int data;

	private Node next;

	public Node(int data) {
		this.data = data;
	}   

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	
	public static void main(String[] args) {
		
	}

}

package com.nik.circularll;


public class LinkedListReverse {

	private Node head;

	private int length;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public static void main(String[] args) {
		LinkedListReverse linkedList = new LinkedListReverse();
		Node head = new Node(1);
		linkedList.setHead(head);
		Node node2 = new Node(2);
		linkedList.getHead().setNext(node2);
		Node node3 = new Node(3);
		node2.setNext(node3);
		Node node4 = new Node(4);
		node3.setNext(node4);
		Node node5 = new Node(5);
		node4.setNext(node5);
		linkedList.reverse();
	}
	
	private void reverse(){
		if(this == null ||this.head == null || this.head.getNext()==null){
			return;
		}
		Node reversed = null;
		Node current = head;
		while (current!=null) {
			Node next =  current.getNext();
			current.setNext(reversed);
			reversed = current;
			current = next;
		}
		this.head=reversed;
	}	

}

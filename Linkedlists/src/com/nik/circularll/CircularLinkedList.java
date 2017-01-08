package com.nik.circularll;


public class CircularLinkedList {

	private Node tail;

	private int length;

	private void addToHead(int data) {
		Node node = new Node(data);
		if (null == tail) {
			node.setNext(node);
			tail = node;
		} else {
			node.setNext(tail.getNext());
			tail.setNext(node);
		}
		length++;
	}

	private void addToTail(int data) {
		addToHead(data);
		tail = tail.getNext();
		length++;
	}

	private int peek() {
		if (null == tail) {
			return Integer.MIN_VALUE;
		} else {
			return tail.getNext().getData();
		}
	}

	private int tailPeek() {
		if (null == tail) {
			return Integer.MIN_VALUE;
		}
		return tail.getData();
	}

	private int removeAndGetFromHead() {

		if (null == tail) {
			return Integer.MIN_VALUE;
		}
		Node head = tail.getNext();
		if (head == tail) {
			tail = null;
			length--;
			return head.getData();
		} else {
			tail.setNext(head.getNext());
			length--;
			return head.getData();
		}

	}

	private int removeFromTailAndGet() {
		if (null == tail) {
			return Integer.MIN_VALUE;
		}
		Node temp = tail;
		if(temp == tail){
			tail = null;
			return temp.getData();
		}
		while(temp.getNext() != tail){
			temp = temp.getNext();
		}
		int data = tail.getData();
		temp.setNext(tail.getNext());
		tail= temp;
		length--;
		return data;
	}
	
	private boolean contains(int data){
		if(null == tail){
			return false;
		}
		Node head = tail.getNext();
		while(head != tail && head.getData()!=data){
			head = head.getNext();
		}
		return head.getData() == data;	
	}

	
	public int remove(int data){
		if(tail == null){
			return Integer.MIN_VALUE;
		}
		Node finger = tail.getNext();
		Node previous = tail;
		while(finger!=tail && finger.getData()!= data){
			previous = finger;
			finger = finger.getNext();
		}
		if(finger.getData() == data){
			if(tail == tail.getNext()){
				tail = null;
			}else{
				if(finger == tail){
					tail= previous;
				}
				previous.setNext(previous.getNext().getNext());	
			}
			length--;
			finger.setNext(null);
			return finger.getData();
		}
		return  Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		circularLinkedList.addToHead(202);
		circularLinkedList.addToHead(101);
		System.out.println("Element Removed "+circularLinkedList.remove(101));
		System.out.println(circularLinkedList.tailPeek());
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}

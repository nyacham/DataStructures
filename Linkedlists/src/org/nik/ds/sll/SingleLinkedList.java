package org.nik.ds.sll;

public class SingleLinkedList<T> {

	private Node<T> head;

	private int size;

	public T getHead(){
		return (null != head?this.head.getData():null);
	}
	
	public void insertAtBegin(Node<T> data){
		if(null == head) this.head = data;
		else{
			 data.setNext(this.head);
			 this.head = data;
		}
		size++;
	}
	
	
	public void insertAtLast(Node<T> data){
		if(null == head) head = data;
		else{
			Node<T> tmp = head;
			while(tmp.getNext() != null){
				tmp = tmp.getNext();
			}
			tmp.setNext(data);
		}
		size++;
	}
	
	
	public void insertAtPosition(int position, Node<T> data){
		if(position == 0 && null == this.head){
			head = data;
		}
		Node<T> tmp = head;
		for (int i = 1; i<position; i++) {
			tmp = tmp.getNext();
		}
		data.setNext(tmp.getNext());
		tmp.setNext(data);
		size++;
	}
	
	
	public void reverse(){
		Node<T> result = null;
		Node<T> tmp = head;
		while(tmp != null){
			Node<T> current = tmp.getNext();
			tmp.setNext(result);
			result = tmp;
			tmp = current;
		}
		this.head = result;
	}

	
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
		linkedList.insertAtBegin(new Node<Integer>(5200));
		linkedList.insertAtBegin(new Node<Integer>(5300));
		linkedList.insertAtLast(new Node<Integer>(5500));
		linkedList.insertAtPosition(2,new Node<Integer>(9999));
		linkedList.reverse();
		System.out.println();
	}
	public void setHead(Node<T> head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private static class Node<T> {

		private T data;

		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}
}

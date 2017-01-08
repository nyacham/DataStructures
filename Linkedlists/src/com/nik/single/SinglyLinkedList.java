package com.nik.single;


public class SinglyLinkedList<T> {

	private int length;

	private Node<T> head;

	public SinglyLinkedList() {
		this.length = 0;
	}

	public synchronized void insertFirst(T value) {
		if (head != null) {
			this.head = new Node<T>(value, head);
		} else {
			this.head = new Node<T>(value, null);
		}
		length++;
	}

	public synchronized void removeFirstMatched(Node<T> node) {
		if (head == null) {
			return;
		}
		if (head.equals(node)) {
			head = head.next;
			length--;
		}
		Node<T> current = head;
		while (current.getNext() != null) {
			if (current.getNext().equals(node)) {
				current.next = current.getNext().getNext();
			}
			current = current.getNext();
		}

	}

	public synchronized void insertLast(T value) {
		if (head == null) {
			insertFirst(value);
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(value, null);
		}
		length++;
	}

	protected synchronized void insert(int position, T data) {
		Node<T> nodeToBeInserted = null;
		if (position == 0) {
			nodeToBeInserted = new Node<T>(data, this.head);
			this.head = nodeToBeInserted;
		} else {
			Node<T> temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.next;
			}
			nodeToBeInserted = new Node<T>(data, temp.next);
			temp.next = nodeToBeInserted;

		}
		length++;
	}

	protected Node<T> removeFromBegin() {
		Node<T> temp = head;
		if (null != temp) {
			head = head.getNext();
			temp.next = null;
			length--;
		}
		return temp;
	}

	protected Node<T> removeFromEnd() {
		if (head == null) {
			return null;
		}
		Node<T> p = head, q = null, next = head.getNext();
		if (next == null) {
			head = null;
			length--;
			return p;
		} else {
			while ((next = p.getNext()) != null) {
				q = p;
				p = next;
				length--;
			}
			q.next = null;
			return p;
		}
	}

	public int getLength() {
		return length;
	}

	public Node<T> getHead() {
		return head;
	}

	public static class Node<T> {

		private T value;

		private Node<T> next;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node() {
		}

		public T getValue() {
			return value;
		}

		public Node<T> getNext() {
			return next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node<T> other = (Node<T>) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
	}

	public void remove(int position) {
		if (position < 0 || position >= length) {
			throw new IndexOutOfBoundsException();
		}
		if (head == null) {
			return;
		}
		if (position == 0) {
			head = head.getNext();
		} else {
			Node<T> p = head;
			for (int i = 0; i < position - 1; i++) {
				p = p.getNext();
			}
			p.next = p.getNext().getNext();
			length--;
		}
	}

	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + this.getHead().value;
		Node<T> nextNode = head.getNext();
		while (nextNode != null) {
			result = result + ", " + nextNode.value;
			nextNode = nextNode.next;
		}
		return result + "]";

	}

	public int getPosition(T data) {
		Node<T> temp = head;
		for (int i = 0; i < length; i++) {
			if (temp.value.equals(data)) {
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}

	private SinglyLinkedList<T> reverse() {
		if (this == null || this.head == null) {
			return null;
		}
		if (this.getHead().getNext() == null) {
			return this;
		}
		Node<T> reversed = null;
		Node<T> current = head;
		while (current != null) {
			Node<T> next = current.getNext();
			current.setNext(reversed);
			reversed = current;
			current = next;
		}
		this.head = reversed;
		return this;
	}

	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.insertFirst("Nikhilesh4");
		list.insertFirst("Nikhilesh5");
		list.insertFirst("Nikhilesh6");
		System.out.println(list.reverse());
	}

}

package com.nik.doublell;


public class DoubleLinkedList {

	private Node head;
	
	private Node tail;
	
	private int length;
	
	public DoubleLinkedList(){
		this.head = new Node(Integer.MIN_VALUE, null, null);
		this.tail = new Node(Integer.MIN_VALUE, head, null);
		head.setNext(tail);
		length = 0;
	}
	
	public int getPosition(int data){
		int position = 0;
		Node temp = this.head;
		while(temp.getNext() != null){
			if(temp.getValue() == data){
				return position;						
			}
			position++;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}
	
	public int getLength(){
		return this.length;
	}
		
	/**
	 * @param position
	 */
	private void remove(int position){
		if(position == 0){
			head = head.getNext();
			if(head == null){
				tail = null;
			}
			else{
				Node temp = head;
				for (int i = 0; i < position; i++) {
					temp= temp.getNext();
				}
				temp.getNext().setPrevious(temp.getPrevious());
				temp.getPrevious().setNext(temp.getNext());
			}
			length--;
		}
	}
	
	public synchronized void removeMatched(Node node){
		if(head == null){
			return;
		}
		else if(head.equals(node)){
			head = head .getNext();
			if(head == null){
				tail = null;
			}
		}else{
			Node temp = head;
			while(temp != null){
				if(temp.equals(node)){
					temp.getNext().setPrevious(temp.getPrevious());
					temp.getPrevious().setNext(temp.getNext());
					length--;
					return;
				}
			}
		}
		
	}
		
}

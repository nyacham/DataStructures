package org.nik.queue.problems;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue <T>{

	Queue<T> queue1 = new LinkedList<>();
	
	Queue<T> queue2 = new LinkedList<>();
	
	public T pop() throws Exception{
		if(!queue1.isEmpty()){
			while(queue1.size() != 1){
				queue2.add(queue1.remove());
			}
			return queue1.remove();
		}else if(!queue2.isEmpty()){
			while(queue2.size() != 1){
				queue1.add(queue2.remove()); 
			}
			return queue2.remove();
		}else{
			throw new Exception("Stack is Empty");
		}
	}
	
	public void push(T data) throws Exception{
		if(!queue1.isEmpty()){
			queue1.add(data);
		}else{
			queue2.add(data);
		}
	}
	
	public static void main(String[] args) throws Exception {
		StackUsingQueue<Integer> stack =  new StackUsingQueue<>();
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println(stack.pop());
		}
	}
	
}

package com.pcq.linearlist.stack;

import com.pcq.linearlist.Node;

public class LinkStack {
	private Node head;//’ª∂•÷∏’Î
	//private Node tail;//’ªŒ≤÷∏’Î
	public LinkStack() {
		head = new Node();
		
	}
	
	public boolean push(int item) {
		Node next = new Node(item);
		if(head.getNext() == null) {
			head.setNext(next);
			return true;
		}
		Node temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(next);
		return true;
	}
	
	
	
	public Integer pop() {
		if(head.getNext() == null)
			return null;
		Node temp = head;
		int data;
		while(temp.getNext().getNext() != null) {
			temp = temp.getNext();
			
		}
		data = temp.getNext().getData();
		temp.setNext(null);
		return data;
	}

	public void travese() {
		if(this.head.getNext() == null)
			System.out.println("null");
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.getNext().getData() + " ");
			temp = temp.getNext();	
		}
	}
	
	public static void main(String[] args) {
		LinkStack ls = new LinkStack();
		ls.push(1);
		ls.push(2);
		ls.travese();
		int a = ls.pop();
		System.out.println(a);
		ls.travese();
		
	}
}

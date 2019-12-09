package com.pcq.linearlist;

/**
 * 链表节点类
 * @author Administrator
 *
 */
public class Node {

	/**
	 * 数据域
	 */
	private int data;
	
	/**
	 * 指针域
	 */
	private Node next;
	
	public Node() {
		
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(int data) {
		this.data = data;
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
	
}

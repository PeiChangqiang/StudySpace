package com.pcq.linearlist.practice;

public class QueuePrac {

	public QueuePrac() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue(5);
		aq.enqueue("1");
		aq.enqueue("2");
		aq.enqueue("3");
		aq.enqueue("4");
		aq.enqueue("5");
		Object obj = aq.dequeue();
		System.out.println(obj.toString());
		aq.enqueue("6");
		System.out.println(aq.dequeue().toString());
	}

}


/**
 * ��������ʵ�ֵĶ���
 * @author pcq
 *
 */
class ArrayQueue {
	private Object[] arrayQueue;
	private int head;
	private int tail;
	
	
	public ArrayQueue(int n) {
		this.arrayQueue = new Object[n];
		this.head = 0;
		this.tail = 0;
	}
	
	/**
	 * ��ջ
	 * @param obj
	 * @return
	 */
	public boolean enqueue(Object obj) {
		if(tail == this.arrayQueue.length) {
			if(head == 0)//��������Ѿ�����
				return false;
			int n = tail - head;
			for(int i = 0; i < n; i++) {//û����Ҫ��Ԫ��Ǩ�ƣ���ʱ���Ӷ�O(n)
				this.arrayQueue[i] = this.arrayQueue[head++];
			}
			head = 0;
			tail = n;
		}
		this.arrayQueue[tail++] = obj;
		return true;
	}
	
	
	/**
	 * ��ջ
	 * @return
	 */
	public Object dequeue() {
		if(head == tail) {
			return null;
		}
		return this.arrayQueue[head++];
	}
	
}


class NodeQueue {
private Node head;//��ͷ
private Node tail;//��β
private int size;
public NodeQueue() {
	this.size = 0;
}

public boolean isEmpty() {
	return this.size == 0 ? true : false;
}
public boolean enqueue(Object obj) {
	Node node = new Node(obj);
	size ++;
	if(this.size == 0) {//�������û��Ԫ��
		this.head = node;
		this.tail = node;
		return true;
	}
	tail.setNext(node);
	tail = node;
	return true;
}


public Object dequeue() {
	if(isEmpty()) {
		return null;
	}
	Node node = head;
	head = head.getNext();
	size--;
	return node;
	
}
	
	class Node {
		private Object obj;
		private Node next;
		
		public Node(Object obj) {
			this.obj = obj;
		}
		public Object getObj() {
			return obj;
		}
		public void setObj(Object obj) {
			this.obj = obj;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
}


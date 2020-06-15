package com.pcq.linearlist.practice;

public class QueuePrac {

	public QueuePrac() {
		// TODO 自动生成的构造函数存根
	}

}


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
	 * 入栈
	 * @param obj
	 * @return
	 */
	public boolean enqueue(Object obj) {
		if(tail == this.arrayQueue.length) {
			return false;
		}
		this.arrayQueue[tail++] = obj;
		return true;
	}
	
	
	/**
	 * 出栈
	 * @return
	 */
	public Object dequeue() {
		if(head == tail) {
			return null;
		}
		return this.arrayQueue[head++];
	}
	
}

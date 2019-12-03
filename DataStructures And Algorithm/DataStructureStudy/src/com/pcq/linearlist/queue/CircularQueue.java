package com.pcq.linearlist.queue;

/**
 * 基于数组实现的循环队列
 * @author pcq
 *
 */
public class CircularQueue {

	private int count;//记录当前队列中有多少元素
	private String[] array;
	private int head = 0;//删除元素的标志位
	private int tail = 0;//插入元素的标志位
	
	public CircularQueue(int n) {
		array = new String[n];
		count = 0;
	}
	
	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		if(count == array.length) //队列已满
			return false;
		if(tail == array.length)//队列未满但是已经到了数组最后，需要重置到数组第一个位置
			tail = 0;
		array[tail++] = item;
		count++;
		return true;
	}
	
	/**
	 * 出队
	 * @return
	 */
	public String dequeue() {
		if(count == 0)//队列为空
			return null;
		String item = array[head++];
		if(head == array.length)
			head = 0;
		count--;
		return item;
	}

	
	public void printQueue() {
		if(head < tail) {
			for(int i = head; i < tail; i++) {
				System.out.println(array[i]);
			}
		} else {
			for(int i = head; i < array.length; i++) {
				System.out.println(array[i]);
			}
			for(int i = 0; i < tail; i++) {
				System.out.println(array[i]);
			}
		}
		System.out.println("head : " + head + ",tail : " + tail + ",count : " + count);
		System.out.println("----------------");
	}
	
	
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(4);
		cq.enqueue("a");
		cq.enqueue("b");
		cq.enqueue("c");
		cq.enqueue("d");
		cq.printQueue();
		cq.dequeue();
		cq.enqueue("e");
		cq.printQueue();
		cq.dequeue();
		cq.dequeue();
		cq.printQueue();
		cq.enqueue("f");
		cq.printQueue();
	}
}

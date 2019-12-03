package com.pcq.linearlist.queue;

/**
 * 基于数组的队列
 * @author pcq
 *
 */
public class ArrayQueue {

	private String[] array;
	private int head = 0;//队头指针，标明当前队头处于数组哪个位置，用于出队
	private int tail = 0;//队尾指针，标明当前队尾处于数组哪个位置，用于入队
	public ArrayQueue(int n) {
		array = new String[n];//创建大小为n的队列
	}
	
	
	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		if(tail == array.length) {
			//队列已经满了，无法入队
			if(head == 0) return false;
			//tail到了数组最后一个位置但队列没满则需要搬移位置
			int n = tail - head;//记录当前多少元素
			for(int i = 0; i < n; i++) {
				array[i] = array[head++];
			}
			//搬移后需要重新赋值队头队尾的位置
			tail = n;
			head = 0;
		}	
		array[tail++] = item;
		return true;
	}
	
	/**
	 * 出队
	 * @return
	 */
	public String dequeue() {
		if(head == tail) //说明队列中没有元素 
			return null;
		String item = array[head++];
		return item;
	}
	
	public void printQueue() {
		for(int i = head; i < tail; i++) {
			System.out.println(array[i]);
		}
		System.out.println("----------------");
	}
	
	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue(5);
		aq.enqueue("a");
		aq.enqueue("b");
		aq.enqueue("c");
		aq.enqueue("d");
		aq.enqueue("e");
		aq.enqueue("f");
		aq.printQueue();
		aq.dequeue();
		aq.printQueue();
		aq.dequeue();
		aq.printQueue();
		aq.enqueue("f");
		aq.printQueue();
	}
}

package com.pcq.linearlist.queue;

/**
 * ��������ʵ�ֵ�ѭ������
 * @author pcq
 *
 */
public class CircularQueue {

	private int count;//��¼��ǰ�������ж���Ԫ��
	private String[] array;
	private int head = 0;//ɾ��Ԫ�صı�־λ
	private int tail = 0;//����Ԫ�صı�־λ
	
	public CircularQueue(int n) {
		array = new String[n];
		count = 0;
	}
	
	/**
	 * ���
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		if(count == array.length) //��������
			return false;
		if(tail == array.length)//����δ�������Ѿ��������������Ҫ���õ������һ��λ��
			tail = 0;
		array[tail++] = item;
		count++;
		return true;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String dequeue() {
		if(count == 0)//����Ϊ��
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

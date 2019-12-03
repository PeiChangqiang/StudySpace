package com.pcq.linearlist.queue;

/**
 * ��������Ķ���
 * @author pcq
 *
 */
public class ArrayQueue {

	private String[] array;
	private int head = 0;//��ͷָ�룬������ǰ��ͷ���������ĸ�λ�ã����ڳ���
	private int tail = 0;//��βָ�룬������ǰ��β���������ĸ�λ�ã��������
	public ArrayQueue(int n) {
		array = new String[n];//������СΪn�Ķ���
	}
	
	
	/**
	 * ���
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		if(tail == array.length) {
			//�����Ѿ����ˣ��޷����
			if(head == 0) return false;
			//tail�����������һ��λ�õ�����û������Ҫ����λ��
			int n = tail - head;//��¼��ǰ����Ԫ��
			for(int i = 0; i < n; i++) {
				array[i] = array[head++];
			}
			//���ƺ���Ҫ���¸�ֵ��ͷ��β��λ��
			tail = n;
			head = 0;
		}	
		array[tail++] = item;
		return true;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String dequeue() {
		if(head == tail) //˵��������û��Ԫ�� 
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

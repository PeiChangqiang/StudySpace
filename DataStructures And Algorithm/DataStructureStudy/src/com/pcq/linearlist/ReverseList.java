package com.pcq.linearlist;
/**
 * ����ת
 * @author Administrator
 *
 */
public class ReverseList {
 
	/**
	 * ������ת
	 * @param head
	 * @return
	 */
	public static Node reverse(Node head) {
		Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
	}
	
	
	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(1);
		//Node node2 = new Node(2);
		//Node node3 = new Node(3);
 
		head.setNext(node1);
		//node1.setNext(node2);
		//node2.setNext(node3);
 
		// ��ӡ��תǰ������
		Node h = head; 
		while (null != h) {
			System.out.print(h.getData() + " ");
			h = h.getNext();
		}
		// ���÷�ת����
		// head = reverse1(head);
		head = reverse(head);
 
		System.out.println("\n**************************");
		// ��ӡ��ת��Ľ��
		while (null != head) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}
	
}

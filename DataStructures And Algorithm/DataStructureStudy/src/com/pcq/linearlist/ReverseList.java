package com.pcq.linearlist;
/**
 * 链表反转
 * @author Administrator
 *
 */
public class ReverseList {
 
	/**
	 * 遍历反转
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
 
		// 打印反转前的链表
		Node h = head; 
		while (null != h) {
			System.out.print(h.getData() + " ");
			h = h.getNext();
		}
		// 调用反转方法
		// head = reverse1(head);
		head = reverse(head);
 
		System.out.println("\n**************************");
		// 打印反转后的结果
		while (null != head) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}
	
}

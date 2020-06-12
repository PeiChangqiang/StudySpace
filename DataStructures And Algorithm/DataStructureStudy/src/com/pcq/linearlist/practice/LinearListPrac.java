package com.pcq.linearlist.practice;

public class LinearListPrac {

	public LinearListPrac() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		
		
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		printLinear(head);
		
		System.out.println("------------------------------------------");
		head = reverse(head);
		Node middle = getMiddleNode(head);
	    System.out.println("�м�ڵ㣺" + middle.getData());
		printLinear(head);
		
		int k = 6;
		Node node = findKNode(head,k);
		System.out.println("������" + k +"���ڵ㣺" + node.getData());
	}

	
	/**
	 * ��ӡ����
	 * @param head
	 */
	public static void printLinear(Node head) {
		while(null != head) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}
	
	
	/**
	 * ����ת
	 * @param head
	 * @return
	 */
	public static Node reverse(Node head) {
		Node pre = null;
		Node next = null;
		while(head != null) {
			next = head.getNext();
			head.setNext(pre);
			pre = head;
			head = next;
		}
		return pre;
	}


	/**
	 * �ϲ�������������
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node mergeNode(Node head1, Node head2) {
		if(head1 == null && head2 == null)
			return null;
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		Node head = null;
		if(head1.getData() > head2.getData()) {
			head = head2;
			head.setNext(mergeNode(head1,head.getNext()));
		} else {
			head = head1;
			head.setNext(mergeNode(head1.getNext(),head2));
		}
		return head;
	}
	
	/**
	 * ����������м�ڵ�
	 * @param head
	 * @return
	 *����ָ��ķ�ʽ
	 */
	public static Node getMiddleNode(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}
	
	
	/**
	 * ���ص�����k�� �ڵ�
	 * @param head
	 * @return
	 */
	public static Node findKNode(Node head, int k) {
		if(head == null) 
			throw new RuntimeException("����Ϊ��");
		if(k <= 0) 
			throw new RuntimeException("k��Ϊ������");
		Node node1 = head;
		Node node2 = head;
		int count = 0;
		while(node1.getNext() != null) {
			if(count == k - 1) {
				node2 = node2.getNext();
				k = k + 1;
			}
			
			node1 = node1.getNext();
			count ++;
		}
		if(k > count + 1) {
			throw new RuntimeException("�����ȣ�" + (count + 1) + ",kֵ���������ȣ�");
		}
		System.out.println(k);
		return node2;
	}
}



/**
 * ����ڵ�
 * @author pcq
 *
 */
class Node {
	int data;
	Node next;
	
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node() {
		
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
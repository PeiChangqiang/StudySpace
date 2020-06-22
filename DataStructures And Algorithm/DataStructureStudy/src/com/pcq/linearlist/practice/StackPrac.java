package com.pcq.linearlist.practice;

public class StackPrac {

	public StackPrac() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(20);
		stack.printStack();
		stack.push(new String("a"));
		stack.push(new String("b"));
		stack.push(new String("c"));
		stack.printStack();
		Object obj = stack.pop();
		stack.printStack();
		Object obj2 = stack.pop();
		stack.printStack();
		stack.push("x");
		stack.printStack();
		
		
		NodeStack st = new NodeStack();
		st.push("1");
		st.printStack();
	}

}




/**
 * ���������ջʵ��
 * @author pcq
 *
 */
class ArrayStack {
	Object[] array;
	int count;//��¼ջ�е�Ԫ�ظ���
	
	public ArrayStack(int n) {
		array = new Object[n];//�����ջ��Ҫ��ʼ����ʱ��֪����С
		count = 0;//��ʼֵû��Ԫ��
	}
	
	
	/**
	 * ��ջ
	 * @param obj
	 * @return
	 */
	public boolean push(Object obj) {
		if(count == array.length)//ջ�Ѿ����ˣ��޷���ջ 
			return false;
		array[count++] = obj;
		return true;
	}
	
	/**
	 * ��ջ
	 * @return
	 */
	public Object pop() {
		if(count == 0) //û��Ԫ��
			return null;
		return array[--count];
	}
	
	
	public void printStack() {
		String str = "[";
		for(int i = 0; i < count; i++) {
			str += array[i].toString() + ",";
			//System.out.println(array[i].toString());
		}
		str += "]";
		System.out.println(str);
	}
}


/**
 * ��������ʵ��ջ
 * @author pcq
 *
 */
class NodeStack {
	Nodex node;
	
	public NodeStack() {
		node = new Nodex();
	}
	
	
	public boolean push(Object obj) {
		Nodex newNode = new Nodex(obj,null);
		Nodex curr = node;//����һ��ָ��
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(newNode);
		return true;
	}
	
	public Nodex pop() {
		//���ջ��û��Ԫ��
		if(node.getObj() == null)
			return null;
		//���ջ��ֻ��һ��Ԫ��
		if(node.getNext() == null) {
			Nodex n = node;
			node.setObj(null);//������Ҫ�ÿ�
			return n;
		}
		Nodex curr = node.getNext();//�ӵڶ�����ʼ����
		Nodex pre = node;
		while(curr.getNext() != null) {
			curr = curr.getNext();
			pre = pre.getNext();
		}
		pre.setNext(null);
		return curr;
	}
	
	public void printStack() {
		Nodex n = node;
		String str = "[" + n.getObj().toString();
		while(n.getNext() != null) {
			n = n.getNext();
			str += n.getObj().toString();
		}
		str += "]";
		System.out.println(str);
	}
}

class Nodex {
	Object obj;//������
	Nodex node;//ָ����
	
	public Nodex(Object obj, Nodex node) {
		this.obj = obj;
		this.node = node;
	}
	public Nodex() {
		
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Nodex getNext() {
		return node;
	}

	public void setNext(Nodex node) {
		this.node = node;
	}
	
	
}

package com.pcq.linearlist.practice;

public class StackPrac {

	public StackPrac() {
		// TODO 自动生成的构造函数存根
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
 * 基于数组的栈实现
 * @author pcq
 *
 */
class ArrayStack {
	Object[] array;
	int count;//记录栈中的元素个数
	
	public ArrayStack(int n) {
		array = new Object[n];//数组的栈需要初始化的时候知道大小
		count = 0;//初始值没有元素
	}
	
	
	/**
	 * 入栈
	 * @param obj
	 * @return
	 */
	public boolean push(Object obj) {
		if(count == array.length)//栈已经满了，无法入栈 
			return false;
		array[count++] = obj;
		return true;
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public Object pop() {
		if(count == 0) //没有元素
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
 * 基于链表实现栈
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
		Nodex curr = node;//定义一个指针
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(newNode);
		return true;
	}
	
	public Nodex pop() {
		//如果栈中没有元素
		if(node.getObj() == null)
			return null;
		//如果栈中只有一个元素
		if(node.getNext() == null) {
			Nodex n = node;
			node.setObj(null);//弹出需要置空
			return n;
		}
		Nodex curr = node.getNext();//从第二个开始遍历
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
	Object obj;//数据域
	Nodex node;//指针域
	
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

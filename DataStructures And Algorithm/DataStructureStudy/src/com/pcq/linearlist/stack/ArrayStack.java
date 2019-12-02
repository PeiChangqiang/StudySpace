package com.pcq.linearlist.stack;
/**
 * 基于数组创建一个顺序栈
 * @author pcq
 *
 */
public class ArrayStack {

	private String[] array;
	private int count;//栈中的元素个数
	public ArrayStack(int n) {
		 this.array = new String[n];
		 count = 0;
	}
	
	/**
	 * 当栈已经满的时候，动态扩容
	 */
	private void expand() {
		String[] newArray = new String[array.length * 2];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	/**
	 * 入栈
	 * @param item
	 * @return
	 */
	public boolean push(String item) {
		if(array.length == 0) {
			return false;
		}
		if(array.length == count) //栈已经满了
			expand();
		array[count] = item;
		count++;
		return true;
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public String pop() {
		if(count == 0) //栈中没有元素
			return null;
		String item = array[count - 1];
		count--;
		return item;
	}
	
	public int getLength() {
		return array.length;
	}
	
	public static void main(String[] args) {
		ArrayStack as = new ArrayStack(0);
		//ArrayStack as = new ArrayStack(3);
		as.push("a");
		as.push("b");
		as.push("c");
		System.out.println(as.getLength());
		as.push("x");
		System.out.println(as.getLength());
	}

}

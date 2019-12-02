package com.pcq.linearlist.stack;
/**
 * �������鴴��һ��˳��ջ
 * @author pcq
 *
 */
public class ArrayStack {

	private String[] array;
	private int count;//ջ�е�Ԫ�ظ���
	public ArrayStack(int n) {
		 this.array = new String[n];
		 count = 0;
	}
	
	/**
	 * ��ջ�Ѿ�����ʱ�򣬶�̬����
	 */
	private void expand() {
		String[] newArray = new String[array.length * 2];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	/**
	 * ��ջ
	 * @param item
	 * @return
	 */
	public boolean push(String item) {
		if(array.length == 0) {
			return false;
		}
		if(array.length == count) //ջ�Ѿ�����
			expand();
		array[count] = item;
		count++;
		return true;
	}
	
	/**
	 * ��ջ
	 * @return
	 */
	public String pop() {
		if(count == 0) //ջ��û��Ԫ��
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

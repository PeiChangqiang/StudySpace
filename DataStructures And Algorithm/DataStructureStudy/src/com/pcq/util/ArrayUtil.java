package com.pcq.util;

import java.util.Random;

public class ArrayUtil {

	private static int scope = 100;
	
	/**
	 * 打印int类型的数组
	 * @param array
	 */
	public static void printArray(int[] array) {
		if(array == null) {
			System.out.println("null");
			return;
		}	
		String arrStr = "[";
		for(int i = 0; i < array.length;i++) {
			if(i == array.length -1) {
				arrStr += array[i] + "]";
			} else {
				arrStr += array[i] + ",";
			}
		}
		System.out.println(arrStr);
	}
	

	/**
	 * 获取大小为n的随机数组
	 * @param n
	 * @return
	 */
	public static int[] getArray(int n) {
		Random rd = new Random();
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = rd.nextInt(scope);//随机生成一个元素值scope以内的数组
		}
		return array;
	}
}

package com.pcq.sort;

import com.pcq.util.ArrayUtil;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = ArrayUtil.getArray(10);
		ArrayUtil.printArray(array);
		insertionSort2 (array);
		ArrayUtil.printArray(array);

	}

	/**
	 * 插入排序 复杂度O(n^2)
	 * @param array
	 */
	public static void insertionSort(int[] array) {
		if(array == null) 
			return;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < i; j++) {//遍历有序部分
				if(array[i] <= array[j]) {//如果大于有序部分的某个数，需要进行数据插入和搬移操作
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				} 
			}
		}
	}
	
	
	/**
	 * 优化后的插入排序，加入了break。平均时间复杂度为O(n^2)	
	 * @param array
	 */
	public static void insertionSort2(int[] array) {
		if(array == null || array.length == 0) 
			return;
		for(int i = 1; i < array.length; ++i) {//默认从1开始，因为最开始默认第一个元素是有序区间
			//提取出来声明为了后面的插入数据
			int value = array[i];
			int j = i - 1;//从有序区间的最右处开始比，因为如果第一个元素比较就不符合条件，则说明无需移动位置直接break
			for(; j >= 0; --j) {
				if(value < array[j]) {
					array[j+1] = array[j];
				} else {
					break;
				}
			}
			array[j+1] = value;//插入数据
		}		
	}
	
	
}

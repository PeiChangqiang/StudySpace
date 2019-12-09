package com.pcq.sort;

import com.pcq.util.ArrayUtil;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = ArrayUtil.getArray(10);
		ArrayUtil.printArray(array);
		selectionSort(array);
		ArrayUtil.printArray(array);

	}

	/**
	 * 选择排序
	 * @param array
	 */
	public static void selectionSort(int[] array) {
		if(array == null || array.length == 0) 
			return;
		for(int i = 0; i < array.length; i++) {
			int index = i;
			for(int j = i; j < array.length; j++) {
				if(array[index] > array[j]) {
					index = j;//记录最小值的位置
				}
			}
			int value = array[index];//将最小值放在已排序区间的末尾
			array[index] = array[i];
			array[i] = value;
		}
	}	
}

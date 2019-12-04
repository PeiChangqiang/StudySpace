package com.pcq.sort;

import com.pcq.util.ArrayUtil;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = ArrayUtil.getArray(10);
		ArrayUtil.printArray(array);
		insertionSort (array);
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
}

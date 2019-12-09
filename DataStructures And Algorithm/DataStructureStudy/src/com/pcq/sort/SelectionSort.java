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
	 * ѡ������
	 * @param array
	 */
	public static void selectionSort(int[] array) {
		if(array == null || array.length == 0) 
			return;
		for(int i = 0; i < array.length; i++) {
			int index = i;
			for(int j = i; j < array.length; j++) {
				if(array[index] > array[j]) {
					index = j;//��¼��Сֵ��λ��
				}
			}
			int value = array[index];//����Сֵ���������������ĩβ
			array[index] = array[i];
			array[i] = value;
		}
	}	
}

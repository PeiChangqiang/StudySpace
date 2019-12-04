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
	 * �������� ���Ӷ�O(n^2)
	 * @param array
	 */
	public static void insertionSort(int[] array) {
		if(array == null) 
			return;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < i; j++) {//�������򲿷�
				if(array[i] <= array[j]) {//����������򲿷ֵ�ĳ��������Ҫ�������ݲ���Ͱ��Ʋ���
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				} 
			}
		}
	}
}

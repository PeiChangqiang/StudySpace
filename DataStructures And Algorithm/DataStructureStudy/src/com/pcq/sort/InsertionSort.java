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
	
	
	/**
	 * �Ż���Ĳ������򣬼�����break��ƽ��ʱ�临�Ӷ�ΪO(n^2)	
	 * @param array
	 */
	public static void insertionSort2(int[] array) {
		if(array == null || array.length == 0) 
			return;
		for(int i = 1; i < array.length; ++i) {//Ĭ�ϴ�1��ʼ����Ϊ�ʼĬ�ϵ�һ��Ԫ������������
			//��ȡ��������Ϊ�˺���Ĳ�������
			int value = array[i];
			int j = i - 1;//��������������Ҵ���ʼ�ȣ���Ϊ�����һ��Ԫ�رȽϾͲ�������������˵�������ƶ�λ��ֱ��break
			for(; j >= 0; --j) {
				if(value < array[j]) {
					array[j+1] = array[j];
				} else {
					break;
				}
			}
			array[j+1] = value;//��������
		}		
	}
	
	
}

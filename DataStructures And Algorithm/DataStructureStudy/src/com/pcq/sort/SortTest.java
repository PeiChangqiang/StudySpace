package com.pcq.sort;

import com.pcq.util.ArrayUtil;

/**
 * ���� �������10000�����飬ÿ������200��Ԫ�أ�
 * �ֱ�ʹ��ð�ݺͲ����ѡ�����򣬿�ִ��ʱ��Ա�
 * @author pcq
 *
 */
public class SortTest {



	public static void main(String[] args) {
		long start = System.currentTimeMillis(); 
		for(int i = 0; i < 10000; i++) {
			int[] array = ArrayUtil.getArray(200);
			//BubbleSort.bubbleSort(array);
			//InsertionSort.insertionSort2(array);
			SelectionSort.selectionSort(array);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}

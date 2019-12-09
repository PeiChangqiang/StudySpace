package com.pcq.sort;

import com.pcq.util.ArrayUtil;

/**
 * 这里 随机生成10000个数组，每个数组200个元素，
 * 分别使用冒泡和插入和选择排序，看执行时间对比
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

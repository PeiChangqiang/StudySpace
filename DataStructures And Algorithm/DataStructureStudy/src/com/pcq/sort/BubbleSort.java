package com.pcq.sort;


import com.pcq.util.ArrayUtil;

/**
 * 冒泡排序
 * @author pcq
 *
 */
public class BubbleSort {


	public static void main(String[] args) {
		int[] array = ArrayUtil.getArray(10);
		ArrayUtil.printArray(array);
		bubbleSort(array);
		ArrayUtil.printArray(array);
	}
	
	/**
	 * 冒泡排序，复杂度O(n^2)
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if(array == null)
			return;
		for(int i = 0; i < array.length; i++) {
			boolean flag = true;//标志位判断是否有交换的数据
			//这里减去i是因为每次循环到了i次意味有i个数已经排好序，无需再进行比较。
			for(int j = 0; j < array.length - i - 1; j++) {//每次循环都比较相邻两个数，如果第一个比第二个大那就调换位置
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1]=temp;
					flag = false;
				}
			}
			if(flag)//flag没有变成false说明没有数据交换了
				break;
		}
	}

		
}

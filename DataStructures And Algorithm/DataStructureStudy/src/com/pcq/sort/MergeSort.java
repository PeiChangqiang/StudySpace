package com.pcq.sort;

import com.pcq.util.ArrayUtil;

/**
 * 归并排序
 * @author pcq
 *
 */
public class MergeSort {

	
	public static void main(String[] args) {
		int[] a = ArrayUtil.getArray(8);
		ArrayUtil.printArray(a);
		mergeSort(a, 0, a.length - 1);
		ArrayUtil.printArray(a);
	}
	
	
	public static void mergeSort(int[] array, int start, int end) {
		if(start < end) {//递归终止条件,当start和end相等时，也就是只有一个元素，就是终止条件
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	
	
	
	
	/**
	 * 
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void merge(int[] array,int left, int mid, int right)  {
		int[] temp = new int[array.length];//临时数组
		int k = left;//存放指针
		int p = left;
		int q = mid + 1;
		while(p <= mid && q <= right) {
			if(array[p] <= array[q]) {
				temp[k++] = array[p++];
			} else {
				temp[k++] = array[q++];
			}
		}
		//看哪个子数组没有放完，则补充到临时数组之中
		while(p <= mid)
			temp[k++] = array[p++];
		while(q <= right)
			temp[k++] = array[q++];
		for(int i = left; i <= right; i++) {
			array[i] = temp[i];
		}
		//ArrayUtil.printArray(array);
	}
	
}

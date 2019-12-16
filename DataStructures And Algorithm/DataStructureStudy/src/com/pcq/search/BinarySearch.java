package com.pcq.search;

import com.pcq.sort.InsertionSort;
import com.pcq.util.ArrayUtil;

/**
 * 二分查找
 * @author pcq
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = ArrayUtil.getArray(100);
		ArrayUtil.printArray(arr);
		InsertionSort.insertionSort2(arr);
		ArrayUtil.printArray(arr);
		//int index = BinarySearch.binarySearch(arr, 90);
		int index1 = BinarySearch.binarySearchRecurve(arr, 90, 0, arr.length - 1);
		//System.out.println(index);
		System.out.println(index1);

	}
	

	/**
	 * 查找数字是否存在于有序数组中
	 * @param arr 有序数组
	 * @return
	 */
	public static int binarySearch(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] == value) {
				return mid;
			} else if(arr[mid] > value){
				right = mid - 1;
			} else {
				left = mid + 1;
			}	
		}
		return -1;
	}
	
	/**
	 * 递归实现二分查找
	 * @param arr
	 * @param value
	 * @param left
	 * @param right
	 * @return
	 */
	public static int binarySearchRecurve(int[] arr, int value, int left, int right) {
		if(left > right) 
			return -1;
		int mid = left + (right - left) / 2;
		if(arr[mid] == value) {
			return mid;
		} else if(arr[mid] > value){
			return binarySearchRecurve(arr, value, left, mid - 1);
		} else {
			return binarySearchRecurve(arr, value, mid + 1, right);
		}
	}
}

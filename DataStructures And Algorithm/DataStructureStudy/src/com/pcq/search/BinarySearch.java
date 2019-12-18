package com.pcq.search;

import com.pcq.sort.InsertionSort;
import com.pcq.util.ArrayUtil;

/**
 * ���ֲ���
 * @author pcq
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		/*int[] arr = ArrayUtil.getArray(100);
		ArrayUtil.printArray(arr);
		InsertionSort.insertionSort2(arr);
		ArrayUtil.printArray(arr);
		//int index = BinarySearch.binarySearch(arr, 90);
		int index1 = BinarySearch.binarySearchRecurve(arr, 90, 0, arr.length - 1);
		//System.out.println(index);
		System.out.println(index1);*/

		int[] arr = {1,5,6,12,43,52,78,78,78};
		int index = binarySearchFirstMini(arr,78);
		System.out.println(index);
	}
	

	/**
	 * ���������Ƿ����������������
	 * @param arr ��������
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
	 * �ݹ�ʵ�ֶ��ֲ���
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
	
	
	/**
	 * ���ҵ�һ�����ֵĺ͸���ֵ��ȵ�Ԫ��
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearchFirst(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 11);
			if(arr[mid] > value) {
				right = mid - 1;
			} else if(arr[mid] < value) {
				left = mid + 1;
			} else {
				//����ǵ�һ��Ԫ�ػ���ǰһ��Ԫ�ز����ڸ���ֵ���򷵻ص�ǰ�±�
				if(mid == 0 || arr[mid - 1] != value) return mid;
				else	right = mid - 1;
			}
		}
		
		return -1;
	}
	
	
	
	
	/**
	 * �������һ�����ֵĺ͸���ֵ��ȵ�Ԫ��
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearchLast(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if(arr[mid] > value) {
				right = mid - 1;
			} else if(arr[mid] < value) {
				left = mid + 1;
			} else {
				//��������һ��Ԫ�ػ��ߺ�һ��Ԫ�ز����ڸ���ֵ���򷵻ص�ǰ�±�
				if(mid == arr.length - 1 || arr[mid + 1] != value) return mid;
				else	left = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * ���ҵ�һ�����ڵ��ڸ���ֵ��Ԫ��
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearchFirstMax(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if(arr[mid] < value) {
				left = mid + 1;
			}  else {
				//����ǵ�һ��Ԫ�ػ���ǰһ��Ԫ�ز����ڸ���ֵ���򷵻ص�ǰ�±�
				if(mid == 0 || arr[mid - 1] < value) return mid;
				else	right = mid - 1;
			}
		}
		return -1;
	}
	
	
	
	/**
	 * �������һ��С�ڵ��ڸ���ֵ��Ԫ��
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearchFirstMini(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if(arr[mid] <= value) {
				if(mid == arr.length - 1 || arr[mid + 1] > value) return mid;
				else	left = mid + 1;
			}  else {
				right = mid - 1;
			}
		}
		return -1;
	}
}

package com.pcq.sort;

import com.pcq.util.ArrayUtil;

/**
 * �鲢����
 * @author pcq
 *
 */
public class MergeSort {

	
	public static void main(String[] args) {
		int[] a = {2,4,9,12,4,5,8,12};
		merge(a,0,3,7);
		ArrayUtil.printArray(a);
	}
	
	
	public static void mergeSort(int[] array) {
		
	}
	
	
	
	
	/**
	 * 
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void merge(int[] array,int left, int mid, int right)  {
		int[] temp = new int[array.length];//��ʱ����
		int k = left;//���ָ��
		while(left <= mid && mid + 1 <= right) {
			if(array[left] < array[mid + 1]) {
				temp[k++] = array[left++];
			} else {
				temp[k++] = array[++mid];
			}
		}
		//���ĸ�������û�з��꣬�򲹳䵽��ʱ����֮��
		while(left < mid)
			temp[k++] = array[left++];
		while(mid < right)
			temp[k++] = array[mid++];
		
		for(int i = left; i < array.length; i++) {
			array[i] = temp[i];
		}
	}
	
}

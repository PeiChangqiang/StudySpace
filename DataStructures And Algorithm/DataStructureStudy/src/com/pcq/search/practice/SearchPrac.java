package com.pcq.search.practice;


//二分查找练习
public class SearchPrac {

	public SearchPrac() {
		// TODO 自动生成的构造函数存根
	}
	
	public static void main(String[] args) {
		int[] arr = {3,8,12,45,1,24,48,96,34,58};
		int index = binarySear(arr, -1);
		System.out.println(index);
		int x = binaryRecurve(arr, 24, 0, arr.length - 1);
		System.out.println(x);
		
	}
	
	//普通循环算法
	public static int binarySear(int[] arr, int val) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == val) {
				return mid;
			} else if(arr[mid] > val) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	//普通循环算法查找第一个相同的元素
	public static int binarySearFirst(int[] arr, int val) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] > val) {
				right = mid - 1;
			} else if(arr[mid] < val) {
				left = mid + 1;
			} else {
				if(arr[mid] == val && arr[mid - 1] != val)
				return mid;
				else right = mid -1;
			}
		}
		return -1;
	}
	
	//递归算法
	public static int binaryRecurve(int[] arr, int val, int left, int right) {
		if(left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if(arr[mid] == val) {
			return mid;
		} else if(arr[mid] > val){
			return binaryRecurve(arr, val, left, mid - 1);
		} else {
			return binaryRecurve(arr, val, mid + 1, right);
		}
	}

}

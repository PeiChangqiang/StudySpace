package com.pcq.search.practice;


//���ֲ�����ϰ
public class SearchPrac {

	public SearchPrac() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public static void main(String[] args) {
		int[] arr = {3,8,12,45,1,24,48,96,34,58};
		int index = binarySear(arr, -1);
		System.out.println(index);
		int x = binaryRecurve(arr, 24, 0, arr.length - 1);
		System.out.println(x);
		
	}
	
	//��ͨѭ���㷨
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
	
	//��ͨѭ���㷨���ҵ�һ����ͬ��Ԫ��
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
	
	//�ݹ��㷨
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

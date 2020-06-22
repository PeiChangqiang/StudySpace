package com.pcq.sort.practice;

import java.util.ArrayList;
import java.util.List;

public class BubblePrac {

	public BubblePrac() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		System.out.println("-----------------ѡ������----------------------");
		int[] arr = makeArr(10);
		printArr(arr);
		
		insertionSort(arr);
		printArr(arr);
		System.out.println("-----------------ð������----------------------");
		arr = makeArr(10);
		printArr(arr);
		bubbleSort(arr);
		printArr(arr);
	
	}
	
	
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
	
	/**
	 * ��ӡ����
	 * @param arr
	 */
	public static void printArr(int[] arr) {
		String str = "[";
		for(int i = 0; i < arr.length; i++) {
			String s = arr[i] + ",";
			str += s;
		}
		str += "]";
		System.out.println(str);
	}
	
	
	public static int[] makeArr(int n) {
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++) {
			int a = (int)(Math.random() * 100);
			arr[i] = a;
		}
		return arr;
		
	}

}

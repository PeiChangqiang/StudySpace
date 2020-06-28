package com.pcq.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

	private static int scope = 100;
	
	
	public static void main(String[] args) {
		int[] arr = getArray(8);
		printArray(arr);
		Arrays.sort(arr);
		printArray(arr);
		reverseArray(arr);
		printArray(arr);
		int min = getMiniValue(arr);
		int max = getMaxValue(arr);
		int avg = getAvgValue(arr);
		System.out.println("�������ֵ�ǣ�" + max + ",��Сֵ�ǣ�" + min + ",ƽ��ֵ�ǣ�" + avg);
		sort(arr);
		printArray(arr);
		System.out.println(getSum(1,2,3,4,5,6));
	}

	
	/**
	 * �ɱ������Ӧ�ã�ʵ�����Ǳ��ֵ�����
	 * @param value
	 * @return
	 */
	public static int getSum(int ... value) {
		int sum = 0;
		for(int val : value) {
			sum += val;
		}
		return sum;
	}
	
	
	/**
	 * ��ӡint���͵�����
	 * @param array
	 */
	public static void printArray(int[] array) {
		if(array == null) {
			System.out.println("null");
			return;
		}	
		String arrStr = "[";
		for(int i = 0; i < array.length;i++) {
			if(i == array.length -1) {
				arrStr += array[i] + "]";
			} else {
				arrStr += array[i] + ",";
			}
		}
		System.out.println(arrStr);
	}
	

	/**
	 * ��ȡ��СΪn���������
	 * @param n
	 * @return
	 */
	public static int[] getArray(int n) {
		Random rd = new Random();
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = rd.nextInt(scope);//�������һ��Ԫ��ֵscope���ڵ�����
		}
		return array;
	}
	
	
	public static int getMaxValue(int[] arr) {
		if(arr == null || arr.length == 0)
			throw new RuntimeException("���鲻��Ϊnull���߲���Ϊ��");
		int maxValue = arr[0];
		for(int val : arr) {
			if(val > maxValue) {
				maxValue = val;
			}
		}
		return maxValue;
	}
	
	
	public static int getMiniValue(int[] arr) {
		if(arr == null || arr.length == 0)
			throw new RuntimeException("���鲻��Ϊnull���߲���Ϊ��");
		int miniValue = arr[0];
		for(int val : arr) {
			if(val < miniValue) {
				miniValue = val;
			}
		}
		return miniValue;
	}
	
	
	public static int getAvgValue(int[] arr) {
		return getSumValue(arr) / arr.length;
	}
	
	public static int getSumValue(int[] arr) {
		if(arr == null || arr.length == 0)
			throw new RuntimeException("���鲻��Ϊnull���߲���Ϊ��");
		int sum = 0;
		for(int val : arr) {
			sum += val;
		}
		return sum;
	}
	
	
	//���鷴ת
	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag) {//û�н���Ԫ�ص�ʱ��break
				break;
			}
		}
	}
	
	/**
	 * ���鷴ת
	 */
	public static void reverseArray(int[] array) {
		for(int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = temp;
		}
	}
}

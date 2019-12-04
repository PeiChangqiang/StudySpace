package com.pcq.sort;


import com.pcq.util.ArrayUtil;

/**
 * ð������
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
	 * ð�����򣬸��Ӷ�O(n^2)
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if(array == null)
			return;
		for(int i = 0; i < array.length; i++) {
			boolean flag = true;//��־λ�ж��Ƿ��н���������
			//�����ȥi����Ϊÿ��ѭ������i����ζ��i�����Ѿ��ź��������ٽ��бȽϡ�
			for(int j = 0; j < array.length - i - 1; j++) {//ÿ��ѭ�����Ƚ������������������һ���ȵڶ������Ǿ͵���λ��
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1]=temp;
					flag = false;
				}
			}
			if(flag)//flagû�б��false˵��û�����ݽ�����
				break;
		}
	}

		
}

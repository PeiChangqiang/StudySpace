package com.pcq.basic_class;

/**
 * һ��jvmֻ��һ��Runtime�࣬������ǵ���ģʽ
 * ������Է��ʲ���ϵͳ �Ĳ�����Ϣ�������ĸ���Ҫ������
 * 1����ȡ�������ڴ�ռ�
 * 2����ȡ�����ڴ�ռ�
 * 3����ȡ�����ڴ�ռ�
 * 4���ֹ�����GC���� 
 * �����gc���ڴ�����кܴ����á�
 * @author Administrator
 *
 */
public class RuntimeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		int preNum = runtime.availableProcessors();//��ȡcpu���ں���
		System.out.println(preNum);
		long maxMemo = runtime.maxMemory();
		long totalMemo = runtime.totalMemory();
		long freeMemo = runtime.freeMemory();
		System.out.println("�������ڴ�ռ䣺" + maxMemo/1224/1024/1024);
		System.out.println("���ÿռ䣺" + (double)totalMemo/1224/1024/1024);
		System.out.println("�����ڴ�ռ䣺" + (double)freeMemo/1224/1024/1024);
		runtime.gc();
	}

}

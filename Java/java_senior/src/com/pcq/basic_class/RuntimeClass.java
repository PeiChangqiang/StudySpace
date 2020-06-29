package com.pcq.basic_class;

/**
 * 一个jvm只有一个Runtime类，因此它是单例模式
 * 该类可以访问操作系统 的操作信息，它有四个重要方法：
 * 1）获取最大可用内存空间
 * 2）获取可用内存空间
 * 3）获取空闲内存空间
 * 4）手工进行GC处理 
 * 该类对gc的内存调优有很大作用。
 * @author Administrator
 *
 */
public class RuntimeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		int preNum = runtime.availableProcessors();//获取cpu的内核数
		System.out.println(preNum);
		long maxMemo = runtime.maxMemory();
		long totalMemo = runtime.totalMemory();
		long freeMemo = runtime.freeMemory();
		System.out.println("最大可用内存空间：" + maxMemo/1224/1024/1024);
		System.out.println("可用空间：" + (double)totalMemo/1224/1024/1024);
		System.out.println("空闲内存空间：" + (double)freeMemo/1224/1024/1024);
		runtime.gc();
	}

}

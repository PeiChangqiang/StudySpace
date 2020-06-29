package com.pcq.basic_class;

/**
 * 在jdk 1.9中 ，对象回收前的准备工作 finalize方法被废弃使用了，取而代之的是 autocloseable和cleaner
 * 并且要求 使用runnable 接口去调用。这意味着 回收前准备工作 更关注于线程安全。
 * @author Administrator
 *
 */
public class CleanerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

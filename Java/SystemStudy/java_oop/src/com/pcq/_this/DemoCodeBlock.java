package com.pcq._this;
/**
 * 先执行静态代码块，再构造块，最后执行构造方法
 * 但静态代码块只执行一次，主要是为了类之中的静态属性初始化
 * @author Administrator
 *
 */
public class DemoCodeBlock {

	static {
		System.out.println("优先于主方法执行，用于主方法执行前做一些准备工作");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("主方法执行");
		new A();
		new A();
	}

}


class A {
	public A() {
		System.out.println("构造方法执行");
	}
	{
		System.out.println("构造块代码执行");
	}
	
	static {
		System.out.println("静态代码块执行");
	}
}
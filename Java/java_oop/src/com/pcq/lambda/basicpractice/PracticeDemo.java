package com.pcq.lambda.basicpractice;

import java.util.function.*;
/**
 * 此类练习java内建的函数式接口使用方式
 * 
 * 
 * 内建的有四个常用的：
 * 1.功能型函数式接口 ——有参数有返回值
 * 2.消费型函数式接口 —— 有参数无返回值
 * 3.供给型函数式接口 —— 无参数有返回值
 * 4.断言型函数式接口 —— 主要进行判断处理
 * @author pcq
 *
 */
public class PracticeDemo {

	public PracticeDemo() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {

		//功能型
		Function<String,String> f1 = String :: toLowerCase;
		System.out.println(f1.apply("Hello World"));
		
		//消费型
		Consumer<String> con = System.out :: println;
		con.accept("Hello World");
		
		//供给型
		Supplier<String> sup = "hello world" :: toUpperCase; 
		System.out.println(sup.get());
	}

}



class TestLambda {
	public static void main(String[] args) {
		Consumer<String> c1 = (s) -> System.out.println(s);
		c1.accept("x");
		//只访问方法而不需要实例化对象，并且参数都可以省略
		Consumer<String> c2 = System.out :: println;
		c2.accept("x");
	}
}



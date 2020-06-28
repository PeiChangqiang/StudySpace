package com.pcq._string;

/**
 * 字符串实际上是数组，1.8以及之前是字符数组，1.9变成了字节数组。
 * 字符串对象实例化有两种方式:1.直接赋值  2.构造方法
 * 1）直接赋值只会产生一个对象，并且字段保存在静态常量池之中。可以重用
 * 2）构造方法会产生两个对象，匿名的字符串常量对象和new关键字开辟出来的内存空间。它会使用new关键字的内存空间对象。并且字符串常量对象不可重用，将成为垃圾。
 * new出来的字符串对象如果想要手工入池，则需要调用native方法 intern。
 * 3）通过"+" 号连接字符串常量 ，得到的结果将在编译时确定它的值，并且在静态常量池中寻找。没有则入池。如果"+"号连接的有变量，则结果是运行时常量，编译期无法确定它的值,除非加上了final修饰将其声明为常量，则其实编译器常量。
 * 4）字符串常量不可修改性，当创建好一个字符串常量时，它就不可改变。当你试图改变时，实际上创建了新的字符串常量，改变的是String引用地址。例如str = "a"; str += "b";
 * 两行代码实际上创建了3个对象 "a", "b","ab",最后str指向的是"ab"， "a","b"将成为垃圾。这意味着频繁修改字符串常量将产生大量垃圾。
 * @author Administrator
 *
 */
public class StringDemo {

	
	
	public static void main(String[] args) {
		String e = "a" + "a" + "a";
		String c = new String("aaa");
		String a = "aaa";
		String b = "aaa";
		
		
		String d= new String("aaa").intern();//手工入池，是一个本地方法
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a == d);
		
		
		String str = "a";
		String f = "a" + str + "a";
		System.out.println(a == e);
		System.out.println(a == f);
		
	}
}

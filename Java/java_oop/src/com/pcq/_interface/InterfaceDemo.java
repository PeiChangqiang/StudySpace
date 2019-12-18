package com.pcq._interface;


/**
 * 抽象类实现接口，没有强制重写抽象方法。但是普通类需要.
 * 接口可以继承多个接口
 * 接口定义的是公共标准，因此封装的都是常量和抽象方法（jdk1.8之前），1.8之后可以有普通方法和静态方法。
 * 接口的使用往往有三种形式：
 * 	1）进行标准设置
 *  2）表示一种操作的能力
 *  3）暴露远程方法视图，这个一般都在RPC分布式开发中使用
 *  
 * 一般子类最好不要直接实现接口，因为接口如果需要增加新的标准之后，所有的子类需要实现该方法。因此最好有一个抽象类作为过渡中作用去实现这个接口。 1.8之后接口可以有普通方法和静态方法。可以解决这个设计缺陷。
 * @author Administrator
 *
 */
public class InterfaceDemo {

	
}

interface ISendMessage extends IMessage, IConnect {
	public default void getName() {
		
	}
	
	public static void getAge() {
		
	}
}

interface IConnect {
	
}

interface IMessage {
	
	public static final String PI = "3.1415926";
	public abstract void getInfo();
	String getInfo(String name, Integer age);
	
}

/**
 * 
 * @author Administrator
 *
 */
abstract class P implements IMessage {
	
}

class X implements IMessage {

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInfo(String name, Integer age) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


class Z extends P {

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInfo(String name, Integer age) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


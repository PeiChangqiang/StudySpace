package com.pcq._interface;


/**
 * 抽象类实现接口，没有强制重写抽象方法。但是普通类需要.
 * 接口可以继承多个接口
 * 接口定义的是公共标准，因此封装的都是常量和抽象方法（jdk1.8之前），1.8之后可以有普通方法和静态方法。
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


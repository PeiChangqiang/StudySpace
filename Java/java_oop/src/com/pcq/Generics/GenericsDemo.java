package com.pcq.Generics;

/**
 * 泛型的出现主要是为了解决 ClassCastException，把运行时可能出现的错误 提到编译期来，所以它其实是一种检查机制。
 * 一个类型可以定义多个泛型 class Point <T,A,B...>
 * 泛型通配符 ? 可以在方法引用传递的时候，使得数据无法修改但是可以获得，并且泛型通配符提供了两种设置：
 * 1) ? extends ClassType ： 设置上限，是ClassType或者ClassType的子类
 * 2) ? super ClassType ： 设置下限，是ClassType或者ClassType的父类
 * @author Administrator
 *
 */
public class GenericsDemo {

	public static void main(String[] args) {
		Point<Integer> p = new Point<Integer>();
		p.setX(10);
		Msg<Double> msg = new Msg<Double>(1.0);
		changeInfo(msg);
	}
	
	public static void changeInfo(Msg<? extends Number> msg) {
		//msg.setInfo("呵呵");//编译报错，加了通配符之后，数据无法修改
		msg.getInfo();//但是可以获得
	}
}

class Point <T> {
	private T x;
	private T y;
	
	public void setX(T x) {
		this.x = x;
	}
	
	public void setY(T y) {
		this.y = y;
	}
	
	
	public T getX() {
		return this.x;
	}
	
	public T getY() {
		return this.y;
	}
}

class Msg <T> {
	private T info;
	
	public Msg(T info) {
		this.info = info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return this.info;
	}
}
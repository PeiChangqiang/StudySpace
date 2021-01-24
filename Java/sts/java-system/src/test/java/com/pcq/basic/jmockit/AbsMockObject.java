package com.pcq.basic.jmockit;

/**
 * ≥ÈœÛMock¿‡
 * @author Administrator
 *
 */
public abstract class AbsMockObject {
	public void sayHello() {
		System.out.println("hello, " + getName());
	}
	
	public static String getUpperName(String name) {
		return name.toUpperCase();
	}
	public abstract String getName();
	
	public Component getComponentObject() {
		return new Component();
	}
}
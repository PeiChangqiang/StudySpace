package com.pcq.basic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class KeyWord implements Externalizable{

	/**
	 * transient，该关键字可以使得成员属性不被序列化，即该属性生命周期只存在于内存中而不会存在磁盘中。ArrayList使用了该关键字。
	 * 使用该关键字的成员属性未必一定不能被实例化，当类实现了Externalizable接口时，该接口允许我们手动指定哪些属性可以被实例化，即使该属性被transient修饰过。
	 * 静态变量是类级别的，不管加不加transient，都无法序列化，和transient没关系。
	 * 
	 */
	private transient Object[] arrData ;

	
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
		
	}
	
	/**
	 * instanceof,用来判断左边是否是右边的实例
	 * @return
	 */
	public boolean instanceofExp() {
		B b = new B();
		return b instanceof A;
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
}

class A {
	
}

class B extends A {
	
}
package com.pcq.basic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class KeyWord implements Externalizable{

	/**
	 * transient���ùؼ��ֿ���ʹ�ó�Ա���Բ������л�������������������ֻ�������ڴ��ж�������ڴ����С�ArrayListʹ���˸ùؼ��֡�
	 * ʹ�øùؼ��ֵĳ�Ա����δ��һ�����ܱ�ʵ����������ʵ����Externalizable�ӿ�ʱ���ýӿ����������ֶ�ָ����Щ���Կ��Ա�ʵ��������ʹ�����Ա�transient���ι���
	 * ��̬�������༶��ģ����ܼӲ���transient�����޷����л�����transientû��ϵ��
	 * 
	 */
	private transient Object[] arrData ;

	
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
		
	}
	
	/**
	 * instanceof,�����ж�����Ƿ����ұߵ�ʵ��
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
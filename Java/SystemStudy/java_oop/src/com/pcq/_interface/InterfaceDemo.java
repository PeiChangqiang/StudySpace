package com.pcq._interface;


/**
 * ������ʵ�ֽӿڣ�û��ǿ����д���󷽷���������ͨ����Ҫ.
 * �ӿڿ��Լ̳ж���ӿ�
 * �ӿڶ�����ǹ�����׼����˷�װ�Ķ��ǳ����ͳ��󷽷���jdk1.8֮ǰ����1.8֮���������ͨ�����;�̬������
 * �ӿڵ�ʹ��������������ʽ��
 * 	1�����б�׼����
 *  2����ʾһ�ֲ���������
 *  3����¶Զ�̷�����ͼ�����һ�㶼��RPC�ֲ�ʽ������ʹ��
 *  
 * һ��������ò�Ҫֱ��ʵ�ֽӿڣ���Ϊ�ӿ������Ҫ�����µı�׼֮�����е�������Ҫʵ�ָ÷�������������һ����������Ϊ����������ȥʵ������ӿڡ� 1.8֮��ӿڿ�������ͨ�����;�̬���������Խ��������ȱ�ݡ�
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


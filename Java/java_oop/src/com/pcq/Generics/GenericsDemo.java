package com.pcq.Generics;

/**
 * ���͵ĳ�����Ҫ��Ϊ�˽�� ClassCastException��������ʱ���ܳ��ֵĴ��� �ᵽ������������������ʵ��һ�ּ����ơ�
 * һ�����Ϳ��Զ��������� class Point <T,A,B...>
 * ����ͨ��� ? �����ڷ������ô��ݵ�ʱ��ʹ�������޷��޸ĵ��ǿ��Ի�ã����ҷ���ͨ����ṩ���������ã�
 * 1) ? extends ClassType �� �������ޣ���ClassType����ClassType������
 * 2) ? super ClassType �� �������ޣ���ClassType����ClassType�ĸ���
 * ���ͽӿ��Լ�����ʵ�ַ�ʽ��
 * 1������ʵ��ʱ��Ȼʹ�÷���
 * 2������ʵ��ʱȷ����������
 * @author Administrator
 *
 */
public class GenericsDemo {

	public static void main(String[] args) {
		Point<Integer> p = new Point<Integer>();
		p.setX(10);
		Msg<Double> msg = new Msg<Double>(1.0);
		changeInfo(msg);
		
		genericsFun gf = new genericsFun();
		int t = gf.getT(2);
		System.out.println(t);
	}
	
	public static void changeInfo(Msg<? extends Number> msg) {
		//msg.setInfo("�Ǻ�");//���뱨������ͨ���֮�������޷��޸�
		msg.getInfo();//���ǿ��Ի��
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


interface A <T> {
	String echo(T t);
}



class B<T> implements A<T> {

	@Override
	public String echo(T t) {
		// TODO Auto-generated method stub
		return t.toString();
	}
	
}



class C implements A<String> {

	@Override
	public String echo(String t) {
		// TODO Auto-generated method stub
		return t;
	}
	
}


//���ͷ���
class genericsFun {
	public <T> T getT(T t) {
		return t;
	}
}
package com.pcq.polymorphic;

/**
 * ��̬��Ϊ���֣�
 * 1�������Ķ�̬����д������
 * 2�������̬������ת�ͺ�����ת�͡��󲿷ֶ�������ת�ͣ�ֻ����Ҫ�����ض��������ܵ�ʱ�������ת�͡���������ת��Ϊ�˰�ȫ�����Ҫinstanceof�ж�
 * 		����ת��ʹ�ô�������θߣ�����������Ϊ���õ��Ƿ���ĳһ���׼�Ķ��󷽷��������������ض�ĳ����������˴���Ŀ�ά���ԡ�
 * @author Administrator
 *
 */
public class PolymorphicDemo {

	public static void main(String[] args) {
		Animal c = new Chicken();//����ת��
		Animal d = new Duck();
		Animal a = new Animal();
		
		c.eat();
		d.eat();
		a.eat();
		System.out.println(c instanceof Animal);
		System.out.println(c instanceof Chicken);
		System.out.println(a instanceof Chicken);
	}
}

class Animal {
	public void eat() {
		System.out.println("�����ڳԡ�����");
	}
}


class Chicken extends Animal {
	public void eat() {
		System.out.println("���ڳԡ�����");
	}
}

class Duck extends Animal {
	public void eat() {
		System.out.println("Ѽ�ڳԡ�����");
	}
}
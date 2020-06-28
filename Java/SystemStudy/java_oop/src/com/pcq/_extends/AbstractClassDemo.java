package com.pcq._extends;

/**
 *ӵ�г��󷽷�������������ࡣ
 *�����಻���Ա�ֱ��ʵ����������������ǿ�����ิд���󷽷���ר�����ڱ��̳С�
 *������Ҫ��д���������еĳ��󷽷���
 *
 *������������� ͳһ�˶�������Ϊ�Ĺ淶�������Ҷ������ͨ����Ҳ���Ե��ó��󷽷���
 * @author Administrator
 *
 */
public class AbstractClassDemo {

	public static void main(String[] args) {
		//Father ins = Father.getInstance();//��̬������Զֻ�����й�ϵ���Ͷ���ʵ����û���κι�ϵ
		Animal a = new Monkey();
		Animal b = new Pig();
		a.action(Animal.EAT);
		b.action(Animal.EAT + Animal.DRINK + Animal.SLEEP);
		Integer i = 5;
		i++;
		Object obj = 7;
		Integer x = (Integer)obj;
		x++;
	}

}


abstract class Father {
	private String name;
	private Integer age;

	public Father() {}
	public static Father getInstance() {
		return new Son();
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getAge() {
		return this.age;
	}

	public Father(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	abstract void getInfo();
}

class Son extends Father {


	public Son() {}
	public Son(String name, Integer age) {
		super(name, age);
	}
	
	@Override
	void getInfo() {
		
	}
	
}


abstract class Animal {
	
	public static final int EAT = 1;
	public static final int SLEEP = 2;
	public static final int DRINK = 4;
	public void action(int command) {
		switch(command) {
			case EAT : eat();break;
			case SLEEP : sleep();break;
			case DRINK : drink();
			case EAT + SLEEP + DRINK : eat();sleep();drink();break;
		}
	
	}
	public abstract void eat();
	public abstract void sleep();
	public abstract void drink();
	
}



class Monkey extends Animal {

	@Override
	public void eat() {
		System.out.println("���ӳ����ӡ�����");
		
	}

	@Override
	public void sleep() {
		System.out.println("����������˯��������");
		
	}

	@Override
	public void drink() {
		System.out.println("���Ӻ�ˮ������");
		
	}
	
}


class Pig extends Animal {

	@Override
	public void eat() {
		System.out.println("���ڳ�ʣ��������");
		
	}

	@Override
	public void sleep() {
		System.out.println("���ں���˯������");
		
	}

	@Override
	public void drink() {
		System.out.println("���ں���ˮ������");
		
	}
	
}
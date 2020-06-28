package com.pcq._interface;

public class InterfacePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SimpleFactory.getRobortInstance(args[0]).executeTask();
		IEat eat = new EatProxyImpl(new People());
		eat.eat();
	}

}

/**
 * �򵥹���ģʽ
 * ����Ķ����й���������������
 * @author Administrator
 *
 */
class SimpleFactory {
	public static Robort getRobortInstance(String name) {
		if("clean".equals(name)) {
			return new CleanRobort();
		}
		if("fix".equals(name)) {
			return new FixRobort();
		}
		return null;
	}
}

interface Robort {
	/**
	 * ִ������
	 */
	public void executeTask();
}

class CleanRobort implements Robort {

	@Override
	public void executeTask() {
		System.out.println("��������ִ��������񡣡���");
		
	}
	
}

class FixRobort implements Robort {

	@Override
	public void executeTask() {
		System.out.println("ά�޻�����ִ��ά�����񡣡���");
		
	}
	
}



interface IEat {
	public void eat();
}

/**
 * �򵥴���ģʽ�����԰Ѻ���ҵ��������������ҵ������ֻ������δ������ҵ�񣬹����Ĳ����ɴ�������ʵ��
 * @author Administrator
 *
 */
class EatProxyImpl implements IEat {

	private IEat eat;
	
	public EatProxyImpl(IEat eat) {
		this.eat = eat;
	}
	
	public void makeFood() {
		System.out.println("׼��ʳ�ģ�����ʳ���");
	}
	
	
	public void cleanFood() {
		System.out.println("��������ʳ�����");
	}
	@Override
	public void eat() {	
		makeFood();
		this.eat.eat();
		cleanFood();
	}
	
}


class People implements IEat {

	@Override
	public void eat() {
		System.out.println("���ڳԶ���...");
		
	}
	
}

class Dog implements IEat {

	@Override
	public void eat() {
		System.out.println("���ڳԶ���...");
		
	}
	
}

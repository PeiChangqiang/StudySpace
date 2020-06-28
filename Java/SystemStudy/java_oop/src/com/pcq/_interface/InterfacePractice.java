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
 * 简单工厂模式
 * 具体的对象有工厂根据需求生产
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
	 * 执行任务
	 */
	public void executeTask();
}

class CleanRobort implements Robort {

	@Override
	public void executeTask() {
		System.out.println("清洁机器人执行清洁任务。。。");
		
	}
	
}

class FixRobort implements Robort {

	@Override
	public void executeTask() {
		System.out.println("维修机器人执行维修任务。。。");
		
	}
	
}



interface IEat {
	public void eat();
}

/**
 * 简单代理模式，可以把核心业务抽离出来。核心业务处理类只关心如何处理核心业务，公共的部分由代理类来实现
 * @author Administrator
 *
 */
class EatProxyImpl implements IEat {

	private IEat eat;
	
	public EatProxyImpl(IEat eat) {
		this.eat = eat;
	}
	
	public void makeFood() {
		System.out.println("准备食材，制造食物。。");
	}
	
	
	public void cleanFood() {
		System.out.println("吃完清理食物。。。");
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
		System.out.println("人在吃东西...");
		
	}
	
}

class Dog implements IEat {

	@Override
	public void eat() {
		System.out.println("狗在吃东西...");
		
	}
	
}

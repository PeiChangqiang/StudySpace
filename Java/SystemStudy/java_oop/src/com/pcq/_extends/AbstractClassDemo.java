package com.pcq._extends;

/**
 *拥有抽象方法的类叫做抽象类。
 *抽象类不可以被直接实例化，它的作用是强制子类复写抽象方法。专门用于被继承。
 *子类需要重写父类中所有的抽象方法。
 *
 *抽象类的作用是 统一了对子类行为的规范管理，并且定义的普通方法也可以调用抽象方法。
 * @author Administrator
 *
 */
public class AbstractClassDemo {

	public static void main(String[] args) {
		//Father ins = Father.getInstance();//静态方法永远只和类有关系，和对象实例化没有任何关系
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
		System.out.println("猴子吃桃子。。。");
		
	}

	@Override
	public void sleep() {
		System.out.println("猴子在树上睡觉。。。");
		
	}

	@Override
	public void drink() {
		System.out.println("猴子喝水。。。");
		
	}
	
}


class Pig extends Animal {

	@Override
	public void eat() {
		System.out.println("猪在吃剩饭。。。");
		
	}

	@Override
	public void sleep() {
		System.out.println("猪在呼噜睡。。。");
		
	}

	@Override
	public void drink() {
		System.out.println("猪在喝雨水。。。");
		
	}
	
}
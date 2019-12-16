package com.pcq.polymorphic;

/**
 * 多态分为两种：
 * 1）方法的多态：重写和重载
 * 2）对象多态：向上转型和向下转型。大部分都是向上转型，只有需要子类特定方法功能的时候才向下转型。但是向下转型为了安全起见需要instanceof判断
 * 		向上转型使得代码抽象层次高，代码更解耦。因为调用的是符合某一类标准的对象方法，而不具体于特定某个对象。提高了代码的可维护性。
 * @author Administrator
 *
 */
public class PolymorphicDemo {

	public static void main(String[] args) {
		Animal c = new Chicken();//向上转型
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
		System.out.println("动物在吃。。。");
	}
}


class Chicken extends Animal {
	public void eat() {
		System.out.println("鸡在吃。。。");
	}
}

class Duck extends Animal {
	public void eat() {
		System.out.println("鸭在吃。。。");
	}
}
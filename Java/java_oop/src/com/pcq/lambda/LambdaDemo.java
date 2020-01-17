package com.pcq.lambda;

public class LambdaDemo {
	public static void main(String[] args) {
		new Thread(() -> {
			
		}).start();
	}
	
}

//使用String类的静态方法ValueOf
@FunctionalInterface
interface IFunc<T,P> {
	public static void main(String[] args) {
		IFunc<String, Integer> fun = String :: valueOf;
		String str = fun.change(10);
		System.out.println(str.length());
	};
	T change(P p);
}


//使用对象的方法引用
@FunctionalInterface
interface IFunc2<T> {

	T upper();
	
	public static void main(String[] args) {
		IFunc2<String> fun = "hello world" :: toUpperCase;
		fun.upper();
	}
}


//类的普通方法引用
@FunctionalInterface
interface IFunc3 {
	String lower(String s);
	
	public static void main(String[] args) {
		IFunc3 fun = String :: toLowerCase;
		String str = fun.lower("HELLO WORLD");
		System.out.println(str);
	}
}

@FunctionalInterface
interface LambdaInterface {
	void print(String str);
	
	public static void main(String[] args) {
		LambdaInterface li = (str) -> {
			System.out.println(str);
		};
		li.print("函数式编程");
	}
}


//构造方法引用
interface IFunc4<T> {
	T create(String name, Integer age);
}


class Person {
	private String name;
	private Integer age;
	
	public static void main(String[] args) {
		IFunc4<Person> func = Person :: new;
		Person p = func.create("张三", 20);
		System.out.println(p);
	}
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "姓名：" + this.name + "、年龄：" + this.age;
	}
}



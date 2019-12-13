package com.pcq.class_relative;

/**
 * 类之间的关联处理
 * @author Administrator
 *
 */
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("张三", 20);
		Car c = new Car("奔驰","沪E158");
		p.setCar(c);
		c.setPerson(p);
		System.out.println("驾驶员信息：" + p + ",车辆信息：" + p.getCar());
		System.out.println("车辆信息：" + c + ",驾驶员信息：" + c.getPerson());
	}
	

}

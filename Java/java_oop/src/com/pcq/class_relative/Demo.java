package com.pcq.class_relative;

/**
 * ��֮��Ĺ�������
 * @author Administrator
 *
 */
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("����", 20);
		Car c = new Car("����","��E158");
		p.setCar(c);
		c.setPerson(p);
		System.out.println("��ʻԱ��Ϣ��" + p + ",������Ϣ��" + p.getCar());
		System.out.println("������Ϣ��" + c + ",��ʻԱ��Ϣ��" + c.getPerson());
	}
	

}

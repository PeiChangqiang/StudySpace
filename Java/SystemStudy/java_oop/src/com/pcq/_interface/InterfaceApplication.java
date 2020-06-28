package com.pcq._interface;

public class InterfaceApplication {
	
	
	public static void main(String[] args) {
		AbstractShape shape = new Circle(5);
		System.out.println("Բ�ε������" + shape.area());	}
}



//����һ��ClassName�ӿڣ��ӿ���ֻ��һ�����󷽷�getClassName��
//���һ����company��ʵ�ֽӿ�ClassName,��ȡ���������


 interface IClassName {
	 public String getClassName();
 }
 
 class Company implements IClassName {

	@Override
	public String getClassName() {
		
		return "Company";
	}
	 
 }
 
 
 //ͼ�����
 
 abstract class AbstractShape {
	 public abstract double area();//ͼ�����
	 public abstract double premeter();//ͼ���ܳ�
 }
 
 class Circle extends AbstractShape {

	 public static final double PI = 3.1415956;
	 private double radio;
	 
	 public Circle(double radio) {
		 this.radio = radio;
	 }
	 
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.radio * this.radio * PI;
	}

	@Override
	public double premeter() {
		// TODO Auto-generated method stub
		return 2 * PI * this.radio;
	}
	 
 }
 
 
 class Rectangle extends AbstractShape {

	 private double length;
	 private double width;
	 
	 public Rectangle(double length, double width) {
		 this.length = length;
		 this.width = width;
	 }
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.length * this.width;
	}

	@Override
	public double premeter() {
		// TODO Auto-generated method stub
		return 2 * (this.length + this.width);
	}
	 
 }
 
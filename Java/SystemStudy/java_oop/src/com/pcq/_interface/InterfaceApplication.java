package com.pcq._interface;

public class InterfaceApplication {
	
	
	public static void main(String[] args) {
		AbstractShape shape = new Circle(5);
		System.out.println("圆形的面积：" + shape.area());	}
}



//定义一个ClassName接口，接口中只有一个抽象方法getClassName；
//设计一个类company，实现接口ClassName,获取该类的名称


 interface IClassName {
	 public String getClassName();
 }
 
 class Company implements IClassName {

	@Override
	public String getClassName() {
		
		return "Company";
	}
	 
 }
 
 
 //图形设计
 
 abstract class AbstractShape {
	 public abstract double area();//图形面积
	 public abstract double premeter();//图形周长
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
 
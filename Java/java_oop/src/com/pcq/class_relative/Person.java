package com.pcq.class_relative;

public class Person {

	
	private String name;
	private Integer age;
	private Car car;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public Car getCar() {
		return this.car;
	}
	
	public String toString() {
		return "ÈËÃû£º" + this.name + ",ÄêÁä£º" + this.age;
	}
}

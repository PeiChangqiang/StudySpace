package com.pcq.class_relative;

public class Car {

	private String name;
	private String carNumber;
	private Person person;//车主

	
	public Car(String name, String carNumber) {
		this.name = name;
		this.carNumber = carNumber;
	}
	
	public Car(String name) {
		this(name,"no-carnum");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getCarNumber() {
		return this.carNumber;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public String toString() {
		return "车名：" + this.name + ",车牌：" + this.carNumber;
	}
}

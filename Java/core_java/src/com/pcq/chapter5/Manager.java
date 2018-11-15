package com.pcq.chapter5;

public class Manager extends Employee {

    private Double bonus;

    public Manager() {

    }
    public Manager(Double baseSalary) {
       super(baseSalary);
       bonus = 0.0;
    }

    public double getSalary() {
       return this.bonus = super.getBaseSalary();
    }

    public void setBonus(double bonus) {
       this.bonus = bonus;
    }
}

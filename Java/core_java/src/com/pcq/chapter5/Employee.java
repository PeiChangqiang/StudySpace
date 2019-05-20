package com.pcq.chapter5;

public class Employee {
    private Double baseSalary;
    private double bonus;
    public Employee() {

    }
    public Employee(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

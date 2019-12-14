package com.pcq.entity_sql;

public class Demo {

	public static void main(String[] args) {
		
		Dept dept = new Dept("����","10001");
		Employee e1 = new Employee("����", dept.getDeptNo(), "�����쵼");
		dept.setLeader(e1);
		System.out.println(dept);
		System.out.println("�����쵼��" + dept.getLeader());
		Employee e2 = new Employee("����", dept.getDeptNo());
		Employee e3 = new Employee("����", dept.getDeptNo());
		Employee[] emps = {e1, e2, e3};
		dept.setEmployees(emps);
		dept.setLeader(e1);
		for(Employee e : dept.getEmployees()) {
			System.out.println(e);
		}
	}

}

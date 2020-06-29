package com.pcq.entity_sql;

public class Employee {
	private String name;
	private String deptNo;
	private String job;
	
	
	public Employee(String name) {
		this(name, "���Ŵ���", "����");
	}
	
	public Employee(String name, String deptNo) {
		this(name, deptNo,"����");
	}
	
	public Employee(String name, String deptNo,String job) {
		this.name = name;
		this.deptNo = deptNo;
		this.job = job;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDeptNo() {
		return this.deptNo;
	}
	
	public String getLeader() {
		return this.job;
	}
	
	public String toString() {
		return "Ա��������" + this.name + ",�������ű�ţ�" + this.deptNo + ",ְλ��" + this.job;
	}
}

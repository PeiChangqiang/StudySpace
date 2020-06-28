package com.pcq.entity_sql;

/**
 * 部门
 * @author Administrator
 *
 */
public class Dept {
	private String dName;
	private String deptNo;
	private Employee leader;
	private Employee[] employees;
	public Dept() {
		
	}
	
	public Dept(String dName,String deptNo) {
		this.dName = dName;
		this.deptNo = deptNo;
	}
	
	
	public Dept(String dName, String deptNo, Employee leader) {
		this.dName = dName;
		this.deptNo = deptNo;
		this.leader = leader;
	}
	
	public void setLeader(Employee leader) {
		this.leader = leader;
	}
	
	public Employee getLeader() {
		return this.leader;
	}
	
	public void setDName(String dName) {
		this.dName = dName;
	}
	
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	
	public String getDName() {
		return this.dName;
	}
	
	public String getDeptNo() {
		return this.deptNo;
	}
	

	
	public Employee[] getEmployees() {
		return this.employees;
	}
	
	public String toString() {
		return "部门名称：" + this.dName + ",部门编号：" + this.deptNo;
	}
}

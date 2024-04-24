package com.jdbcproject;

public class Employee {
   private int eid;
   private String ename;
   private int eexp;
   private int esalary;
public Employee(int eid, String ename, int eexp, int esalary) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.eexp = eexp;
	this.esalary = esalary;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getEexp() {
	return eexp;
}
public void setEexp(int eexp) {
	this.eexp = eexp;
}
public int getEsalary() {
	return esalary;
}
public void setEsalary(int esalary) {
	this.esalary = esalary;
}
   
}

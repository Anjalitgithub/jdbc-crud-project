package com.jdbcproject;

import java.util.ArrayList;

public class Sample1 {

	public static void main(String[] args) {
		//BusinessLogic.createTable();
	
	
		ArrayList<Employee> al=BusinessLogic.selectAll();
		for(Employee e:al) {
			System.out.println(e.getEid()+" "+e.getEname()+" "+e.getEexp()+" "+e.getEexp());
		}
	}

}


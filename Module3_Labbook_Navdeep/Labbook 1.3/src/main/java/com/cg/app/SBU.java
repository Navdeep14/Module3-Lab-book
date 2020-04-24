package com.cg.app;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SBU {
  private List<Employee> employeeList;
	
	@Value("${sbuId}")
	private int sbuId;
	
	@Value("${sbuName}")
	private String sbuName;
	@Value("${sbuHead}")
	private String sbuHead;

	public int getSbuId() {
		return sbuId;
	}
	public void setSbuid(int sbuId) {
		this.sbuId = sbuId;
	}
	public String getSbuName() {
		return sbuName;
	}
	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}
	public String getSbuHead() {
		return sbuHead;
	}
	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}
	
	
	
	
	//@Autowired
	public void setEmployeeList(List<Employee> employeeList)
	{
		this.employeeList = employeeList;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	
	 public void display()
	 {
		 System.out.println("SBU ID:"+this.getSbuId()+" "+"SBU NAME:"+this.getSbuName()+" "+ " SBU HEAD:"+this.getSbuHead());
		 System.out.println("..........Employeee Details........");

	for(Employee emp:employeeList)
	{    
		System.out.print("Employee ID: "+emp.getEmployeeId()+" "+"Employee Name: "+emp.getEmployeeName()+" "+"Employee Salary: "+emp.getEmployeeSalary()+""
				+ " "+"Employee Age: "+emp.getEmployeeAge());
	}
	
}
}




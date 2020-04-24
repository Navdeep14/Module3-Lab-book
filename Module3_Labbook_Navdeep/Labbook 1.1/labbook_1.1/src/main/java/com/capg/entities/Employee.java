package com.capg.entities;

public class Employee {
    private Integer employeeID;
    private String employeeName;
    private Integer salary;
    private String SBU;
    

    public Employee(){

    }


	public Employee(Integer employeeID, String employeeName, Integer salary, String sBU) {
		
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.salary = salary;
		this.SBU = sBU;
	}


	public Integer getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public String getSBU() {
		return SBU;
	}


	public void setSBU(String sBU) {
		SBU = sBU;
	}

	

    
   
}

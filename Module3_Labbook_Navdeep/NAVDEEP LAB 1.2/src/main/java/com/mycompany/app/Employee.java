package com.mycompany.app;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;


@Component
public class Employee {
	@Value("${id}")
	private int employeeId;
	
	@Value("${name}")
	private String employeeName;
	
	@Value("${salary}")
	private double salary;
	
	@Value("${bu}")
	private String unit;
	
	@Value("${age}")
	private int age;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	private SBU businessUnit;
	
	public SBU getSbu() {
		return businessUnit;
	}
	
	@Autowired
	public void setSbu(SBU businessUnit) {
		this.businessUnit = businessUnit;
	}
	
	public Employee() {
		
	}
	public Employee(SBU businessUnit) {
		this.businessUnit=businessUnit;
	}
	
	public void display() {
		System.out.println("Id :"+employeeId+" "+"Name:"+employeeName+" "+"Salary:"+salary+" "+"B Unit:"+unit+" "+"Age:"+age);
	}
	
	public SBU getSbuDetails() {
		SBU sbu = new SBU();
		sbu.setSbuId("PES-BU");
		sbu.setSbuName("Product Engineering Services");
		sbu.setSbuHead("Laddo Singh");
		
		return sbu;
	}
	
}



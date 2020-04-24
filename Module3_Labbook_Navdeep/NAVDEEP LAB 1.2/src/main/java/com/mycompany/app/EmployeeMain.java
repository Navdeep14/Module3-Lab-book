
package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class EmployeeMain {
	public static void main(String[] args) {
	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	 Class configurationClass=JavaConfig.class;
     context.register(configurationClass);
     context.refresh();

     Employee employee = context.getBean(Employee.class);
     System.out.println("Details are:");
     employee.display();
     
     EmployeeMain em = new EmployeeMain();
     SBU sbu1=employee.getSbuDetails();
     em.printSBUDetails(sbu1);
	}
	
	void printSBUDetails(SBU sbu) {
		System.out.println("SBU Details= SBU"+"["+"sbuCode:"+sbu.getSbuId()+" "+"sbuHead:"+sbu.getSbuHead()+" "+"sbuName:"+sbu.getSbuName()+"]");
	}

}
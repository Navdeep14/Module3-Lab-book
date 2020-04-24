package com.cg.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.cg.app")
@PropertySource("classpath:employee.properties")
public class JavaConfig {
@Bean
public SBU sbu()
{
	Employee employee1=new Employee(1,"Ashku",30000,21);
	Employee employee2=new Employee(2,"Anushka",50000,21);
	
	List<Employee> empList=new ArrayList<>();
	empList.add(employee1);
	empList.add(employee2);
	
	SBU sbu=new SBU();
	sbu.setEmployeeList(empList); 
	
	return sbu;
 

}
}

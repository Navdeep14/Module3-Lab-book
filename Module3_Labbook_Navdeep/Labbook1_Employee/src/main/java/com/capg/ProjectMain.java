package com.capg;

import com.capg.config.JavaConfig;
import com.capg.entities.Employee;
import com.capg.service.IEmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class ProjectMain {

    public static void main(String[] args) {
        //
        //ApplicationContext is the specification
        // implementation we are using is AnnotationConfigApplicationContext
        //
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //
        //registering configuration class in which configurations are kept
        //
        Class configurationClass= JavaConfig.class;
        context.register(configurationClass);
        context.refresh();
        context.registerShutdownHook();
        //
        //fetching bean by name
        //
        IEmployeeService service = context.getBean(IEmployeeService.class);
        List<Employee>employees= service.fetchAllEmployees();
        for (Employee e:employees){
            System.out.println(e.getId()+"- "+e.getName());
        }
    }


}
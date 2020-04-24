package com.capg.dao;

import com.capg.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @Repository is recommended instead of @Component on EmployeeDaoImpl to show intention
 * Both @Repository and @Component does same job
 */
@Component
public class EmployeeDaoImpl implements IEmployeeDao{

    private Map<Integer,Employee>store=new HashMap<>();

    public EmployeeDaoImpl(){
        store.put(1,new Employee(1,"Navdeep",30000,"PES-BU",21));
        store.put(2,new Employee(2,"Laddoo",40000,"PAS-BU",21));
    }


    @Override
    public List<Employee> fetchAllEmployees() {
        Collection<Employee>employees=store.values();
        List<Employee>list=new ArrayList<>(employees);
        return list;
    }
}

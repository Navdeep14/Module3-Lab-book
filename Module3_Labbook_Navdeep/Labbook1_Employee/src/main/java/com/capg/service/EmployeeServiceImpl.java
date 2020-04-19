package com.capg.service;

import com.capg.dao.IEmployeeDao;
import com.capg.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Service is recommended instead of @Component on Service Classes
 * Both @Service and @Component does same job
 */
@Service
public class EmployeeServiceImpl  implements IEmployeeService {

    private IEmployeeDao dao;

    public IEmployeeDao getDao(){
        return dao;
    }

    @Autowired
    public void setDao(IEmployeeDao dao){
        this.dao=dao;
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return dao.fetchAllEmployees();
    }
}

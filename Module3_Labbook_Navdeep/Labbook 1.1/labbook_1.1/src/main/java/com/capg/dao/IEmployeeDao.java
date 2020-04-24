package com.capg.dao;

import com.capg.entities.Employee;

import java.util.List;

public interface IEmployeeDao {

    List<Employee>fetchAllEmployees();
}

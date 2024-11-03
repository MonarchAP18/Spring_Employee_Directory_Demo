package com.SpringBootCourse.EmployeeDirectory.service;

import com.SpringBootCourse.EmployeeDirectory.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}

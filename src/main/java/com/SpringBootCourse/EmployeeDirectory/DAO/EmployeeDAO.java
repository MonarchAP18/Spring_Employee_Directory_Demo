package com.SpringBootCourse.EmployeeDirectory.DAO;

import com.SpringBootCourse.EmployeeDirectory.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}

package com.SpringBootCourse.EmployeeDirectory.rest;


import com.SpringBootCourse.EmployeeDirectory.DAO.EmployeeDAO;
import com.SpringBootCourse.EmployeeDirectory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    //inject Employee DAO (Use Constructor Injection
    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    //expose "/employee" endpoint and return the list of employees
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return  employeeDAO.findAll();
    }

}

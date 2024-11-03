package com.SpringBootCourse.EmployeeDirectory.rest;


import com.SpringBootCourse.EmployeeDirectory.DAO.EmployeeDAO;
import com.SpringBootCourse.EmployeeDirectory.entity.Employee;
import com.SpringBootCourse.EmployeeDirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //private EmployeeDAO employeeDAO;

    //Implementing Employee Service which implements the Employee DAO
    private EmployeeService employeeService;


    //inject Employee DAO (Use Constructor Injection
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //expose "/employee" endpoint and return the list of employees
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }

}

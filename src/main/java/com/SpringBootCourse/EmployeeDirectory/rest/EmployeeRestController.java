package com.SpringBootCourse.EmployeeDirectory.rest;


import com.SpringBootCourse.EmployeeDirectory.entity.Employee;
import com.SpringBootCourse.EmployeeDirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }


    //adding mapping for the GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee  = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return  theEmployee;
    }

    //Adding Mapping for POST /employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // in case Id is passed in JSON..... set it to 0
        //this will force save the new Item... Instead of updating a new one


        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }


    //add PUT mapping - update the existing employee
    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

}


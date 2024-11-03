package com.SpringBootCourse.EmployeeDirectory.DAO;

import com.SpringBootCourse.EmployeeDirectory.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //Define a field for entity manager
    private EntityManager entityManager;


    //Setup a Constructor Injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute a query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the result list
        return employees;
    }
}

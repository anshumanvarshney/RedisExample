package com.example.redisExample.repository;

import com.example.redisExample.entity.Employee;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmployeeRepository{

    Employee findByFirstName(String firstName);

    Employee findOne(String employeeId);

    Employee save(Employee employee);

    boolean exists(String employeeId);

    List<Employee> findAll();

    long count();

    void delete(String employeeId);

    void deleteAll();
}

package com.example.redisExample.services;

import com.example.redisExample.entity.Employee;
import java.util.List;


public interface EmployeeService {

	List<Employee> findAll();

	Employee findOne(String id);

	Employee save(Employee employee);

	long count();

	Boolean exists(String id);

	void delete(String id);

	void deleteAll();
}

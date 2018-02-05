package com.example.redisExample.repository;

import com.example.redisExample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Created by ppatchava on 1/3/18.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String KEY = "Employee";
    private RedisTemplate<String, Employee> redisTemplate;
    private HashOperations hashOps;
    @Autowired
    public EmployeeRepositoryImpl(RedisTemplate<String, Employee> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init(){
        this.hashOps = this.redisTemplate.opsForHash();
    }
    public List<Employee> findAll(){
        Map<String,Employee> allElements = hashOps.entries(KEY);
        return allElements.values().stream().collect(Collectors.toList());
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return null;
    }

    public Employee findOne(String employeeId){
        return (Employee) hashOps.get(KEY,employeeId);
    }
    public Employee save(Employee employee){
        hashOps.put(KEY,employee.getEmployeeId(),employee);
        return employee;
    };
    public Employee insert(Employee employee){
        hashOps.put(KEY,employee.getEmployeeId(),employee);
        return employee;
    }
    public void delete(String employeeId){
        hashOps.delete(KEY,employeeId);
    }
    public void deleteAll(){
        Set<String> keys= hashOps.keys(KEY);
        for(String key:keys){
            hashOps.delete(KEY,key);
        }
    }

    public boolean exists(String employeeId){
        return hashOps.hasKey(KEY,employeeId);
    }
    public long count(){
        return hashOps.size(KEY);
    }
}

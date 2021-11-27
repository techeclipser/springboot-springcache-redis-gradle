package com.tech.eclipser.springboot.springcache.redis.jedis.service;

import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee insertEmployee(Employee employee);
    void clearEmployeeFromCache(Employee employee);
    Employee insertEmployeeCache(Employee employee);
    void updateEmployee(Integer employeeId,Employee employee);
    Employee getEmployee(final Integer employeeId);
    List<Employee> getAllEmployee();
}

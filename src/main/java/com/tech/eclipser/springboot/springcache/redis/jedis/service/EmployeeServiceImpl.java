package com.tech.eclipser.springboot.springcache.redis.jedis.service;

import com.tech.eclipser.springboot.springcache.redis.jedis.mapper.EmployeeMapper;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheManager = "jedisRedisCacheManager", cacheNames = { "employee"})
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(value = "employee")
    public Employee getEmployee(final Integer employeeId) {
        return  employeeMapper.getEmployeeById(employeeId).get(0);
    }

    @CachePut(cacheNames = "employee",keyGenerator="customKeyGenerator")
    public Employee insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
        return employee;
    }

    @CachePut(cacheNames = "employee",keyGenerator="customKeyGenerator")
    public Employee insertEmployeeCache(Employee employee) {
        return employee;
    }

    @Override
    @CacheEvict(cacheNames = "employee", keyGenerator = "customKeyGenerator")
    public void clearEmployeeFromCache(Employee employee) {
        System.out.println("clear Employee from Cache");
    }

    @Override
    public void updateEmployee(Integer employeeId, Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    public List<Employee> getAllEmployee() {
        return  employeeMapper.getAllEmployee();
    }

}

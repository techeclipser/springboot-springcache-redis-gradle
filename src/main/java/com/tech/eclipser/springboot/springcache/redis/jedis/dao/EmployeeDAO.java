package com.tech.eclipser.springboot.springcache.redis.jedis.dao;

import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;

public interface EmployeeDAO {
    void insert(Employee employee);
}

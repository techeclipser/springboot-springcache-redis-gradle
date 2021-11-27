package com.tech.eclipser.springboot.springcache.redis.jedis.service;

import com.tech.eclipser.springboot.springcache.redis.jedis.model.Department;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;

import java.util.List;

public interface DepartmentService {
    Department insertDepartment(Department department);
    void updateDepartment(Integer departmentId,Department department);
    Department getDepartment(final Integer departmentId);
    List<Department> getAllDepartment();
}

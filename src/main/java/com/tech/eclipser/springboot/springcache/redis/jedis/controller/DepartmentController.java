package com.tech.eclipser.springboot.springcache.redis.jedis.controller;

import com.tech.eclipser.springboot.springcache.redis.jedis.mapper.DepartmentMapper;
import com.tech.eclipser.springboot.springcache.redis.jedis.mapper.EmployeeMapper;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Department;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;


    @GetMapping("/department")
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }

}

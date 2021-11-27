package com.tech.eclipser.springboot.springcache.redis.jedis.service;

import com.tech.eclipser.springboot.springcache.redis.jedis.mapper.DepartmentMapper;
import com.tech.eclipser.springboot.springcache.redis.jedis.mapper.EmployeeMapper;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Department;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheManager = "jedisRedisCacheManager", cacheNames = { "department"})
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    @CachePut(cacheNames = "department")
    public Department insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }

    @Override
    public void updateDepartment(Integer departmentId, Department department) {
        Department departmentPresent = getDepartment(departmentId);
        if(departmentPresent!=null){
            departmentMapper.updateDepartment(department);
        }
    }

    @Override
    @Cacheable(cacheNames = "department")
    public Department getDepartment(Integer departmentId) {
        return departmentMapper.getDepartmentById(departmentId).get(0);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }
}

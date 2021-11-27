package com.tech.eclipser.springboot.springcache.redis.jedis.dao;

import com.tech.eclipser.springboot.springcache.redis.jedis.mapper.EmployeeMapper;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void insert(Employee employee) {
        EmployeeMapper employeeMapper= sqlSession.getMapper(EmployeeMapper.class);
    }
}

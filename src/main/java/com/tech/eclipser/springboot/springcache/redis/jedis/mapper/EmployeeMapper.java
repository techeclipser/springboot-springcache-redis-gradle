package com.tech.eclipser.springboot.springcache.redis.jedis.mapper;

import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {
    @Results(id = "employeeResult", value = {
            @Result(property = "employeeId", column = "EMPLOYEE_ID", id = true),
            @Result(property = "firstName", column = "FIRST_NAME"),
            @Result(property = "lastName", column = "LAST_NAME"),
            @Result(property = "lastUpdatedBy", column = "LAST_UPDATED_BY"),
            @Result(property = "lastUpdatedTs", column = "LAST_UPDATED_TS")
    })
    @Select({"SELECT * FROM EMPLOYEE"})
    List<Employee> getAllEmployee();

    @Select("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = #{employeeId}")
    @Results(value = {
            @Result(property = "employeeId", column = "EMPLOYEE_ID"),
            @Result(property = "firstName", column = "FIRST_NAME"),
            @Result(property = "lastName", column = "LAST_NAME"),
            @Result(property = "lastUpdatedBy", column = "LAST_UPDATED_BY"),
            @Result(property = "lastUpdatedTs", column = "LAST_UPDATED_TS")
    })
    List<Employee> getEmployeeById(Integer employeeId);

    @Insert("INSERT INTO EMPLOYEE(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,LAST_UPDATED_BY,LAST_UPDATED_TS) VALUES(#{employeeId},#{firstName},#{lastName},#{lastUpdatedBy},#{lastUpdatedTs})")
    @Options(useGeneratedKeys=true, keyProperty="employeeId")
    int insertEmployee(Employee employee);

    @Update("UPDATE EMPLOYEE SET FIRST_NAME=#{firstName},LAST_NAME=#{lastName},LAST_UPDATED_BY=#{lastUpdatedBy},LAST_UPDATED_TS=#{lastUpdatedTs} WHERE  EMPLOYEE_ID=#{employeeId}")
    int updateEmployee(Employee employee);
}

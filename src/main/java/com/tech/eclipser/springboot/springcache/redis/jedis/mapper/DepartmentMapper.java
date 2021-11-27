package com.tech.eclipser.springboot.springcache.redis.jedis.mapper;

import com.tech.eclipser.springboot.springcache.redis.jedis.model.Department;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {
    @Results(id = "departmentResult", value = {
            @Result(property = "departmentId", column = "DEPARTMENT_ID", id = true),
            @Result(property = "departmentName", column = "DEPARTMENT_NAME"),
            @Result(property = "lastUpdatedBy", column = "LAST_UPDATED_BY"),
            @Result(property = "lastUpdatedTs", column = "LAST_UPDATED_TS")
    })
    @Select({"SELECT * FROM DEPARTMENT"})
    List<Department> getAllDepartment();

    @Select("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = #{departmentId}")
    @Results(value = {
            @Result(property = "departmentId", column = "DEPARTMENT_ID"),
            @Result(property = "departmentName", column = "DEPARTMENT_NAME"),
            @Result(property = "lastUpdatedBy", column = "LAST_UPDATED_BY"),
            @Result(property = "lastUpdatedTs", column = "LAST_UPDATED_TS")
    })
    List<Department> getDepartmentById(Integer departmentId);

    @Insert("INSERT INTO DEPARTMENT(DEPARTMENT_ID,DEPARTMENT_NAME,LAST_UPDATED_BY,LAST_UPDATED_TS) VALUES(#{departmentId},#{departmentName},#{lastUpdatedBy},#{lastUpdatedTs})")
    @Options(useGeneratedKeys=true, keyProperty="departmentId")
    int insertDepartment(Department department);

    @Update("UPDATE DEPARTMENT SET DEPARTMENT_NAME=#{departmentName},LAST_UPDATED_BY=#{lastUpdatedBy},LAST_UPDATED_TS=#{lastUpdatedTs} WHERE  DEPARTMENT_ID=#{departmentId}")
    int updateDepartment(Department department);
}

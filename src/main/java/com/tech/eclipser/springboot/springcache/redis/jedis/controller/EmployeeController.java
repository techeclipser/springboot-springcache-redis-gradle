package com.tech.eclipser.springboot.springcache.redis.jedis.controller;

import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import com.tech.eclipser.springboot.springcache.redis.jedis.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        for(Employee employee : employeeList){
            employeeService.insertEmployeeCache(employee);
        }
        return employeeList;
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable(value = "employeeId") Integer employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employee")
    public void insert(@Valid @RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @PutMapping("/employee/{employeeId}")
    public void update(@PathVariable(value = "employeeId") Integer employeeId, @Valid @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId,employee);
        employeeService.clearEmployeeFromCache(employee);
        employeeService.insertEmployeeCache(employee);
    }

    @PostMapping("/clearEmployee")
    public void clear(@Valid @RequestBody Employee employee) {
        employeeService.clearEmployeeFromCache(employee);
    }
    @PatchMapping("/employee/{employeeId}")
    public void updatePatch(@PathVariable(value = "employeeId") Integer employeeId, @Valid @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId,employee);
    }
}

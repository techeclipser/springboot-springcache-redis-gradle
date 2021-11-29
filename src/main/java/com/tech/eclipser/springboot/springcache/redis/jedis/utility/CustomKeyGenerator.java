package com.tech.eclipser.springboot.springcache.redis.jedis.utility;

import com.tech.eclipser.springboot.springcache.redis.jedis.model.Department;
import com.tech.eclipser.springboot.springcache.redis.jedis.model.Employee;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component("customKeyGenerator")
public class CustomKeyGenerator implements KeyGenerator {

    public Object generate(Object target, Method method, Object... params) {
        return generateKey(params);
    }

    public static Object generateKey(Object... params) {
        StringBuilder sb = new StringBuilder();
        if (params.length == 0) {
            return SimpleKey.EMPTY;
        }
        if (params.length > 0) {
            List<Integer> integers = new ArrayList<>();
            for (Object o : params) {
                if (Integer.class.equals(o.getClass())) {
                    integers.add((Integer) o);
                    sb.append(integers.get(0));
                    sb.append(":");
                }
                if (o instanceof Employee) {
                    Employee employee = (Employee) o;
                    sb.append(employee.getEmployeeId());
                    sb.append(":");
                    sb.append(employee.getFirstName());
                    return sb.toString();
                }
                if (o instanceof Department) {
                    Department department = (Department) o;
                    sb.append(department.getDepartmentId())
                            .append(":")
                            .append(department.getDepartmentName());
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}

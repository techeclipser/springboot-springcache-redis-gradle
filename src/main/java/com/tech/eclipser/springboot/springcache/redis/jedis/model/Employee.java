package com.tech.eclipser.springboot.springcache.redis.jedis.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    Integer employeeId;
    String firstName;
    String lastName;
    String lastUpdatedBy;
    Date lastUpdatedTs;
}

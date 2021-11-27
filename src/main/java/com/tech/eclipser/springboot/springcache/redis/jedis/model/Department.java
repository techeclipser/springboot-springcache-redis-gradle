package com.tech.eclipser.springboot.springcache.redis.jedis.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    Integer departmentId;
    String departmentName;
    String lastUpdatedBy;
    Date lastUpdatedTs;
}

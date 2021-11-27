package com.tech.eclipser.springboot.springcache.redis.jedis.utility;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CacheKey {
    private Integer intValue;
    private String stringValue;
}

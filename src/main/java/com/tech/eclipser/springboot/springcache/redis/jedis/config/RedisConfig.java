package com.tech.eclipser.springboot.springcache.redis.jedis.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

import static org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig;

@Configuration
@EnableCaching
@ComponentScan("com.tech.eclipser.springboot.springcache.redis.jedis")
@PropertySource("classpath:redis.properties")
@Getter
@Setter
public class RedisConfig {
    private @Value("${redis.host}") String redisHost;
    private @Value("${redis.port}") int redisPort;
    private @Value("${redis.username}") String userName;
    private @Value("${redis.password}") String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration(redisHost,6379);
        redisConfig.setUsername(userName);
        redisConfig.setPassword(password);
        JedisClientConfiguration jedisClientConfig = JedisClientConfiguration.builder()
                .readTimeout(Duration.ofSeconds(120))
                .connectTimeout(Duration.ofSeconds(30))
                .usePooling()
                .build();
        return new JedisConnectionFactory(redisConfig, jedisClientConfig);
    }

    @Bean
    @Primary
    public CacheManager jedisRedisCacheManager() {
        RedisCacheConfiguration genericJacksonCacheConfiguration = defaultCacheConfig().disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
        RedisCacheConfiguration defaultCacheConfiguration = defaultCacheConfig().disableCachingNullValues();
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(jedisConnectionFactory())
                // .cacheDefaults(defaultCacheConfiguration)
                .withCacheConfiguration("employee", defaultCacheConfiguration)
                .withCacheConfiguration("address", genericJacksonCacheConfiguration)
                .enableStatistics()
                .build();
        return redisCacheManager;
    }
}

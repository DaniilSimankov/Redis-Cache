package ru.cache;

import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@EnableCaching
@SpringBootApplication
public class RedisCacheApplication {

    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) {
        JsonJacksonCodec codec = new JsonJacksonCodec();
        Map<String, CacheConfig> config = new HashMap<>();
        config.put("cache", new CacheConfig(24 * 60 * 1000, 12 * 60 * 1000));
        return new RedissonSpringCacheManager(redissonClient, config, codec);
    }


    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

}

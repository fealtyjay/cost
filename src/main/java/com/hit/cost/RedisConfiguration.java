package com.hit.cost;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/12/20 10:32
 * <p>
 * Created By IDEA
 * ==========================
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    @Bean
    public CacheManager cachemanager(RedisConnectionFactory redisConnectionFactory){
//        return new RedisCacheManager(redistemplate, RedisCacheConfiguration.defaultCacheConfig());
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10));//失效时间10分钟
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(target.getClass().getName());
                stringBuilder.append(method.getName());
                Arrays.stream(params).forEach( stringBuilder::append);
//                for (Object para : params
//                ) {
//                    stringBuilder.append(para.toString());
//                }
                System.out.println("调用redis缓存" + stringBuilder.toString());
                return stringBuilder.toString();
            }
        };
    }
}

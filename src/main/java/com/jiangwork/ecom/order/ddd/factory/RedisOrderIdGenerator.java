package com.jiangwork.ecom.order.ddd.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jiangzhao on 2020-10-25 12:03.
 */
@Service
public class RedisOrderIdGenerator {
    private static final String ORDER_REDIS_KEY = "order.id";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public long get() {
        return Long.valueOf(redisTemplate.opsForValue().increment(ORDER_REDIS_KEY));
    }
}

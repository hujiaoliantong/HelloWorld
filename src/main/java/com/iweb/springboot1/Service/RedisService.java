package com.iweb.springboot1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author wanglu
 * @create 2019-07-17 16:27:02
 */
//@Service
@Component   //component跟server注解本质没区别
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 该方法能够支持多种数据类型存放
    public void set(String key, Object object, Long time) {
        // 存放String 类型
        if (object instanceof String) {
            setString(key, object);
        }
        // 存放 set类型
        if (object instanceof Set) {
            setSet(key, object);
        }
        // 设置有效期 以秒为单位
        if(time != null) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    public void setString(String key, Object object) {
        // 如果是String 类型
        String value = (String) object;
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setSet(String key, Object object) {
        Set<String> value = (Set<String>) object;
        for (String oj : value) {
            stringRedisTemplate.opsForSet().add(key, oj);
        }
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}

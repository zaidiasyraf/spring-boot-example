package com.zaidi.springdataredisexample.redis_template;

import java.util.List;
import java.util.Map;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTemplateServiceImpl implements RedisTemplateService {

    private final RedisTemplate<String, String> stringRedisTemplate;

    public RedisTemplateServiceImpl(final RedisTemplate<String, String> stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void createOrUpdateString(final String key, final String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void createOrUpdateList(final String key, final List<String> value) {
        stringRedisTemplate.opsForList().rightPushAll(key, value);
    }

    @Override
    public void createOrUpdateSet(final String key, final String... values) {
        stringRedisTemplate.opsForSet().add(key, values);
    }

    @Override
    public void createOrUpdateHash(final String key, final Map<String, String> hash) {
        stringRedisTemplate.opsForHash().putAll(key, hash);
    }

}

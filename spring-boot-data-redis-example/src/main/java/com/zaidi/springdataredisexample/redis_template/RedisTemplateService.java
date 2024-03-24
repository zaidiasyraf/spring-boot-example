package com.zaidi.springdataredisexample.redis_template;

import java.util.List;
import java.util.Map;

public interface RedisTemplateService {

    void createOrUpdateString(String key, String value);

    void createOrUpdateList(String key, List<String> value);

    void createOrUpdateSet(String key, String... values);

    void createOrUpdateHash(String key, Map<String, String> value);

}

package com.zaidi.springdataredisexample.redis_template;

import java.util.Map;
import lombok.Data;

@Data
public class HashRedisDto extends BaseRedisDto{

    private Map<String, String> values;

}

package com.zaidi.springdataredisexample.redis_template;

import java.util.List;
import lombok.Data;

@Data
public class ListRedisDto extends BaseRedisDto{

    private List<String> values;
}

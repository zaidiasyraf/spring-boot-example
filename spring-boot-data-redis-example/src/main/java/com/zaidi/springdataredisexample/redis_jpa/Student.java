package com.zaidi.springdataredisexample.redis_jpa;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RedisHash("student")
public class Student {

    @Id
    private Long id;
    @Indexed
    private String name;
    private Integer age;

}

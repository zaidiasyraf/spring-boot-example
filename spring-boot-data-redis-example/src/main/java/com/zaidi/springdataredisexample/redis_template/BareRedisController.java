package com.zaidi.springdataredisexample.redis_template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bare")
public class BareRedisController {

    private final RedisTemplateService redisTemplateService;

    public BareRedisController(final RedisTemplateService redisTemplateService) {
        this.redisTemplateService = redisTemplateService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody StringRedisDto dto) {
        redisTemplateService.createOrUpdateString(dto.getKey(), dto.getValue());
    }

    @PostMapping("/list")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createList(@RequestBody ListRedisDto listRedisDto) {
        redisTemplateService.createOrUpdateList(listRedisDto.getKey(), listRedisDto.getValues());
    }

    @PostMapping("/set")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createSet(@RequestBody ListRedisDto listRedisDto) {
        redisTemplateService.createOrUpdateSet(listRedisDto.getKey(), listRedisDto.getValues().toArray(new String[0]));
    }

    @PostMapping("/hash")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createHash(@RequestBody HashRedisDto hashRedisDto) {
        redisTemplateService.createOrUpdateHash(hashRedisDto.getKey(), hashRedisDto.getValues());
    }


}

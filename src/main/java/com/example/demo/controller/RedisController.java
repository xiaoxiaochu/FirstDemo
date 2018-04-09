package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by go on 2018/2/27.
 */


@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/redis/string", method = RequestMethod.GET)
    public void insertString() {
        stringRedisTemplate.opsForValue().set("stringKey", "stringValue");
    }
}

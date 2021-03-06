package com.example.demo.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by go on 2018/2/27.
 */
public class RedisReceiver {


    private  static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);


    private CountDownLatch latch;


    @Autowired
    public RedisReceiver (CountDownLatch latch){
        this.latch = latch;
    }


    public void receiveMessage(String message){
        LOGGER.info("Received < " + message + ">");
        latch.countDown();
    }



}

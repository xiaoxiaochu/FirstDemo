package com.example.demo.service;

import com.example.demo.myinterface.IUserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by go on 2017/7/17.
 */

@Service
public class UserServiceImpl implements IUserSerivce {



    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) VALUES(?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM USER WHERE NAME = ?",name);

    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER",Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM USER ");
    }
}

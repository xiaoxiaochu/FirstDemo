package com.example.demo.myinterface;

/**
 * Created by go on 2017/7/14.
 */
public interface IUserSerivce {





    /**
     *
     * @param name
     * @param age
     */
        void create(String name,Integer age);


    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);
    /**
     * 获取用户总量
     */
    Integer getAllUsers();
    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}

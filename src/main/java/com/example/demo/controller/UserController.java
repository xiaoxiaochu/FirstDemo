package com.example.demo.controller;

import com.example.demo.domain.UpdateEntity;
import com.example.demo.domain.User;
import com.example.demo.myinterface.IUserSerivce;
import com.example.demo.service.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by go on 2017/7/13.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {


    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());


    @Autowired
    IUserSerivce service;

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){

        List<User> r = new ArrayList<User>(users.values());

        return r;
    }


    @ApiOperation(value = "创建用户", notes = "根据user对象创建对象")
    @ApiImplicitParam(value = "user",name = "用户详细实体user",required = true,dataType = "User")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute  User user){

        users.put(user.getId(),user);

        return "success";
    }



    @ApiOperation(value = "根据iD查询",notes = "根据id获取对象")
    @ApiImplicitParam(value = "id",name = "根据用户id获取user",required = true,dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }




    @ApiOperation(value = "根据iD查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "用户id",required = true,dataType = "Long"),
            @ApiImplicitParam(value = "user",name = "用户实体user",required = true,dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }



    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }



    @RequestMapping(value = "/version" ,method = RequestMethod.GET)
    public UpdateEntity getUpdateEntity(){
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setApkDescription("得发商城app新版本更新");
        updateEntity.setVersionCode(3);
        updateEntity.setUrl("http://192.168.0.128:8080/zhihu.apk");
        updateEntity.setVersionName("得发商城");
        updateEntity.setCode(200);
        return updateEntity;

        }



    @RequestMapping(value = "/users" ,method = RequestMethod.GET)
    public int getUsers(){





        service.create("jack",18);
        service.create("rose",20);

       return service.getAllUsers();
    }



}

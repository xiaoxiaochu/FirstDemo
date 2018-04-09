package com.example.demo;

import com.example.demo.myinterface.IUserSerivce;
import com.example.demo.util.ObjectUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

/**
 * Created by go on 2017/7/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserServiceTest {

    @Autowired
    private IUserSerivce userSerivce;



    @Autowired
    private StringRedisTemplate template;
//    @Before
//    public void setUp(){
//        userSerivce.deleteAllUsers();
//    }


    @Test
    public void test()throws Exception{
        userSerivce.create("a",1);
        userSerivce.create("b", 2);
        userSerivce.create("c", 3);
        userSerivce.create("d", 4);
        userSerivce.create("e", 5);


        Assert.assertEquals(5,userSerivce.getAllUsers().intValue());

        // 删除两个用户
        userSerivce.deleteByName("a");
        userSerivce.deleteByName("e");
        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());
    }

    /**
     * 根据表名称创建一张表
     * @param tableName
     */
    public static int createTable(JdbcTemplate jt, String tableName, Object obj){
        StringBuffer sb = new StringBuffer("");
        sb.append("CREATE TABLE `" + tableName + "` (");
        sb.append(" `id` int(11) NOT NULL AUTO_INCREMENT,");
        Map<String,String> map = ObjectUtil.getProperty(obj);
        Set<String> set = map.keySet();
        for(String key : set){
            sb.append("`" + key + "` varchar(255) DEFAULT '',");
        }
        sb.append(" `tableName` varchar(255) DEFAULT '',");
        sb.append(" PRIMARY KEY (`id`)");
        sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
        try {
            jt.update(sb.toString());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Test
    public void testRedis(){
        template.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", template.opsForValue().get("aaa"));
    }


}

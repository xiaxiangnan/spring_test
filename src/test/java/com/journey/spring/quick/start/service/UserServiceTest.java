package com.journey.spring.quick.start.service;

import com.journey.spring.quick.start.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Test
 * Created by zhangyuan on 15/12/20.
 */
@RunWith(SpringJUnit4ClassRunner.class) //基于Junit4的Spring测试框架
@ContextConfiguration(locations = {"/applicationContext.xml"}) //启动Spring容器
public class UserServiceTest {

    @Autowired //注入Spring容器中的bean
    private UserService userService;


    @Test //标注测试方法
    public void testHasMatchUser() throws Exception {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertFalse(b2);
    }

    @Test
    public void testFindUserByUserName() throws Exception {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }

//    @Test
//    public void testLoginSuccess() throws Exception {
//
//    }
}
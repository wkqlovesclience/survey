package com.sclience.survey.common.base.service.impl;

import com.sclience.survey.common.base.entity.Role;
import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2020-01-02 15:09:30
 */
@RunWith(SpringJUnit4ClassRunner.class)//junit整合spring的测试//立马开启了spring的注解
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {

    @Resource
    private UserService userService;
    @Resource
    private Session session;

    @Test
    public void testSelectUserByName(){
        User user = userService.selectUserByName("wkq");
        System.out.println(user);
    }

    @Test
    public void testSaveUser(){
        Set<Role> roles = new HashSet<Role>();
        //创建对象
        User user = new User("wkqaaa1dxx", "123456", "wkqaaa1dxx",
                "18395683112@163.com", new Date(), 1, 1, 1, 1,
                new Date(), "zk", new Date(), "12345724111", "cd21zz",
                "12312", new Date(), "111211",roles);
        Boolean result = userService.saveUser(user);
        System.out.println(result);
    }

}
package com.sclience.survey.common.base.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

///**
// * TODO
// *
// * @author 王克强
// * @version 1.0
// * @since 2019-12-05 00:04:37
// */
@RunWith(SpringJUnit4ClassRunner.class)//junit整合spring的测试//立马开启了spring的注解
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {


    @Resource
    private Session session;

    @Test
    public void testUser(){
        Set<Role> roles = new HashSet<Role>();
        //创建对象
        User user = new User("wkqadxx", "123456", "wkqadxx",
                "18395683781@163.com", new Date(), 1, 1, 1, 1,
                new Date(), "zk", new Date(), "12345725921", "cd21zz",
                "12312", new Date(), "111211",roles);
        //获取加载配置管理类

        /*Configuration configuration = new Configuration();

        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();

        //创建Session工厂对象
        SessionFactory factory = configuration.buildSessionFactory();

        //得到Session对象
        Session session = factory.openSession();*/

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();

        //开启事务
        transaction.begin();

        //把对象添加到数据库中
        session.save(user);

        //提交事务
        transaction.commit();

        //关闭Session
        session.close();
    }

}
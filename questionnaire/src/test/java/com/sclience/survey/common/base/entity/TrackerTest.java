package com.sclience.survey.common.base.entity;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-05 23:17:54
 */
@RunWith(SpringJUnit4ClassRunner.class)//junit整合spring的测试//立马开启了spring的注解
@ContextConfiguration("classpath:applicationContext.xml")
public class TrackerTest {
    @Autowired
    private Session session;

    /**
     * 添加
     */
    @Test
    public void testAdd(){
        //获取session
        //Session session = HibernateUtil.createSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        //核心代码
        Tracker tracker = new Tracker("yyyy-MM-dd", "123", "tracker", new Date(), "zw");
        session.save(tracker);
        //提交事务
        tx.commit();
        //关闭相关资源
        session.close();
    }

}
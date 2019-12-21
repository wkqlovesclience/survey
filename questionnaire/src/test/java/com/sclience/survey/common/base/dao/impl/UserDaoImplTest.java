package com.sclience.survey.common.base.dao.impl;

import com.sclience.survey.common.base.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-18 17:56:17
 */
@RunWith(SpringJUnit4ClassRunner.class)//junit整合spring的测试//立马开启了spring的注解
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoImplTest {
    @Autowired
    private Session session;
    @Test
    public void testSelectUserByName(){
        //开启事务
        Transaction tx = session.beginTransaction();
        //核心代码
        String loginName = "zujj";
        String hql = "from com.sclience.survey.common.base.entity.User u where u.loginName = ?";
//        Query query = session.createQuery(hql);
//        User user = (User) query.setParameter(0, loginName).uniqueResult();

        User user = (User) session.createQuery(hql).setParameter(0,loginName).uniqueResult();
        System.out.println(user);
        //提交事务
        tx.commit();
        //关闭相关资源
        session.close();
    }

    @Test
    public void testSelectRoleByUserId(){
        //开启事务
        Transaction tx = session.beginTransaction();
        //核心代码

        //提交事务
        tx.commit();
        //关闭相关资源
        session.close();
    }
}
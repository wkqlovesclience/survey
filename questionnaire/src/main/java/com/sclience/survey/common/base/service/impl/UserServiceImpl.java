package com.sclience.survey.common.base.service.impl;

import com.sclience.survey.common.base.dao.UserDao;
import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-18 21:54:27
 */
@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private Session session;

    /**
     * 根据用户登录名获取用户的全部信息
     * @param loginName 用户登录名
     * @return 用户信息
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public User selectUserByName(String loginName){
        User user = userDao.selectUserByName(loginName);
        return user;
    }

    /**
     * 保存一个用户信息
     * @param user 用户对象
     * @return true：保存成功，false：保存失败
     */
    @Override
    @Transactional
    public void saveUser(User user) {
        //使用Hibernate操作数据库，都要开启事务,得到事务对象
       // Transaction transaction = session.getTransaction();
        //开启事务
        //transaction.begin();
        userDao.saveUser(user);
        //transaction.commit();
       // session.close();
    }
}
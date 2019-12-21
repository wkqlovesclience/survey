package com.sclience.survey.common.base.service.impl;

import com.sclience.survey.common.base.dao.UserDao;
import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-18 21:54:27
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public User selectUserByName(String loginName){
        User user = userDao.selectUserByName(loginName);
        return user;
    }

    @Override
    public Boolean saveUser(User user) {
        boolean result = userDao.saveUser(user);
        return result;
    }
}
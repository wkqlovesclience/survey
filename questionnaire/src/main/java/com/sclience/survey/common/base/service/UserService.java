package com.sclience.survey.common.base.service;

import com.sclience.survey.common.base.entity.User;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-18 21:49:59
 */
public interface UserService {
    /**
     * 根据用户登录名获取用户信息
     * @param loginName 用户登录名
     * @return 用户信息
     */
    User selectUserByName(String loginName);

    /**
     * 保存用户对象信息
     * @param user 用户对象
     * @return 保存成功返回true，失败返回false
     */
    Boolean saveUser(User user);
}

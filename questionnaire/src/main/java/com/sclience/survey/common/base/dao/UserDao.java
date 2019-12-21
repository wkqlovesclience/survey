package com.sclience.survey.common.base.dao;

import com.sclience.survey.common.base.entity.Role;
import com.sclience.survey.common.base.entity.User;

import java.util.List;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-18 16:26:37
 */
public interface UserDao {
    //通过用户名获取用户信息
    User selectUserByName(String loginName);

    //保存用户信息
    boolean saveUser(User user);

    //根据用户id获取该用户的角色信息
    List<Role> selectRoleByUserId(String userId);
}

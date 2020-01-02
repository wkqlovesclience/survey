package com.sclience.survey.common.base.dao.impl;

import com.sclience.survey.common.base.dao.UserDao;
import com.sclience.survey.common.base.entity.Role;
import com.sclience.survey.common.base.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-18 16:31:16
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private Session session;

    /**
     * 根据用户id获取该用户的角色信息
     * @param userId 用户id
     * @return 角色信息
     */
    @Override
    public List<Role> selectRoleByUserId(String userId) {

        return null;
    }

    /**
     * 根据登录用户名获取用户信息
     * @param loginName 登录名
     * @return 用户信息
     * @throws Exception
     */
    @Override
    public User selectUserByName(String loginName){
        String hql = "from com.sclience.survey.common.base.entity.User as u where u.loginName = ?0";
        User user = (User) session.createQuery(hql).setParameter(0,loginName).uniqueResult();
        session.close();
        return user;
    }

    /**
     * 保存用户对象信息
     * @param user 用户对象
     * @return 保存失败返回false，成功返回true
     */
    @Override
    public boolean saveUser(User user) {
        Boolean result = false;
        try {
            session.save(user);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        session.close();
        return result;
    }
}

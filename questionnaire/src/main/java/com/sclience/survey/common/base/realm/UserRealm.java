package com.sclience.survey.common.base.realm;

import com.sclience.survey.common.base.entity.Permission;
import com.sclience.survey.common.base.entity.Role;
import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.apache.shiro.realm.AuthorizingRealm;

import java.util.Set;


/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-19 12:52:53
 */
@Component
@Transactional
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;



    /**
     *  授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情
     * @param principals 身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权信息......");
        //从principals中获取登陆用户输入的登录名
        String loginName = (String) principals.fromRealm(getName()).iterator().next();//用迭代器
        //根据用户登录名，从数据库中获取用户信息
        User user = userService.selectUserByName(loginName);
        if (user != null){
            // info 用于聚合授权信息
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //获取该用户的角色信息
            Set<Role> roles = user.getRoles();
            for (Role role : roles) {
                //把角色的名字添加到授权信息中
                info.addRole(role.getRoleName());
                //获取角色的对应权限
                Set<Permission> permissions = role.getPermissions();
                for (Permission permission : permissions) {
                    //为角色授权
                    info.addStringPermission(permission.getValidateurl());
                }
            }
            return info;
        }
        return null;
    }

    /**
     * 身份认证/登录，验证用户是不是拥有相应的身份
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("验证信息......");
        //转换成为更简单的UsernamePasswordToken
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        User user = userService.selectUserByName(usertoken.getUsername());
        if (user != null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginName(), token, getName());
            return info;
        }
        return null;//如果返回为null值,则表示用户不存在
    }
}

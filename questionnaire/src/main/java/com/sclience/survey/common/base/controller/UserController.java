package com.sclience.survey.common.base.controller;

import com.sclience.survey.common.base.entity.Role;
import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-20 17:46:41
 */
@RestController("user")
public class UserController{

    @Resource
    private UserService userService;



    @RequestMapping("register")
    public String register(User user){
        System.out.println("-----------------------------------");
        System.out.println("接收到的User对象信息："+user);
        //使用盐值对密码进行加密
       String finalPassword = new Md5Hash(user.getShaPassword(), ByteSource.Util.bytes(user.getLoginName()), 3).toString();
        user.setShaPassword(finalPassword);
        user.setSalt(user.getLoginName());
        userService.saveUser(user);
        if (userService.selectUserByName(user.getLoginName()) != null){
            return "redirect:login";
        }

        return "redirect:login01.jsp";
    }

    @RequestMapping("login")
    public String login(User user){
        System.out.println("开始登录......");
        //使用SecurityUtils把当前登陆的用户作为主体
        try {
            user.setLastLoginTime(new Date());
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getLoginName(),user.getShaPassword()));
            return "redirect:index.jsp";
        }catch (AuthenticationException e){
            System.out.println("认证没有通过......");
            //认证没有通过 1、该用户之前已经认证通过 2、账号或密码不匹配
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()){
                return "redirect:index.jsp";
            }
            return "redirect:login01.jsp";
        }
    }


}

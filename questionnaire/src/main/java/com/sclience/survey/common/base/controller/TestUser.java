package com.sclience.survey.common.base.controller;

import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2020-01-02 14:47:07
 */
@RestController("test")
public class TestUser {

    @Resource
    private UserService userService;

    @RequestMapping("loginTest")
    public String login(User user){
        System.out.println("打印接收到的用户信息："+user.toString());
        //根据用户登录名获取用户信息
        User loginUser = userService.selectUserByName(user.getLoginName());
        //判断用户输入的密码是否正确
        if (loginUser.getShaPassword().equals(user.getShaPassword())){
            //密码正确
            return "redirect:index.jsp";
        }
        return "redirect:login01.jsp";
    }
}

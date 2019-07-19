package com.pikaqiu.springcloud.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕梁山
 * @date 2019/7/19
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @RequestMapping(value = "getUser")
    public String getUser(String userId){
        return "查找用户：" + userId;
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(String userName){
        return "新增用户姓名：" + userName;
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.PUT)
    public String updateUser(String userName){
        return "更新用户姓名：" + userName;
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.DELETE)
    public String deleteUser(String userId){
        return "删除用户：" + userId;
    }
}

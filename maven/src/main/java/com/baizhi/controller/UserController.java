package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/queryAll")
    public List<User> queryAll(){
        return userService.queryAll();
    }

    /**
     * 用户判断用户填写的用户名是否已存在(存在--不能注册  不存在--可以注册)
     * @param name
     * @return
     */
    @RequestMapping("/userValidation")
    public String userValidation(String name){
        List<String> names = userService.names();
        if(names.contains(name)){
            return "1";
        } else{
            return "0";
        }
    }



    @RequestMapping("queryOne")
    public void queryOne(User user){
        User user1 = userService.findUserByNameAndPassword(user);
        if(user1 != null){

        }
    }
}

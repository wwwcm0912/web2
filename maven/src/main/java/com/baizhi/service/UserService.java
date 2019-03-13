package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 展示所有用户信息
     * @return
     */
    List<User> queryAll();

    /**
     * 查询所有用户名 用户注册
     * @return
     */
    List<String> names();

    /**
     * 判断输入的用户名密码是否存在 用户登录
     * @param user
     * @return
     */
    User findUserByNameAndPassword(User user);

    /**
     * 添加功能
     * @param user
     */
    void addUser(User user);
}

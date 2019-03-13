package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 查询所有用户名字
     * @return
     */
    List<String> findNames();

    /**
     * 根据用户名和密码进行查询 用户登录
     * @param name
     * @param password
     * @return
     */
   // User findUserBynameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     * 向用户表中添加数据
     * @param user
     */
    void insertUser(User user);
}

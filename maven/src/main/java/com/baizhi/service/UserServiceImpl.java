package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
   @Override
    public List<User> queryAll() {
        return userDao.findAll();
    }

    @Override
    public List<String> names(){
        return userDao.findNames();
    }

    @Override
    public User findUserByNameAndPassword(User user){
       return userDao.findUserBynameAndPassword(user.getName(),user.getPassword());
    }

    @Override
    public void addUser(User user){
       userDao.insertUser(user);
    }

}

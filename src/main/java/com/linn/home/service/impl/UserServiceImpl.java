package com.linn.home.service.impl;

import com.linn.home.dao.UserDao;
import com.linn.home.entity.User;
import com.linn.home.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理service层
 * Created by Administrator on 2018-03-06.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User findUserByName(User user) {
        return userDao.findUserByName(user);
    }

    @Override
    public User findUserByNameAndPwd(User user) {
        return userDao.findUserByNameAndPwd(user);
    }

    @Override
    public List<User> findUserList() throws Exception {
        return userDao.findUserList();
    }

    @Override
    public int addUser(User user) throws Exception {
        return userDao.addUser(user);
    }

    @Override
    public int updateUserByUserName(User user) throws Exception {
        return userDao.updateUserByUserName(user);
    }

    @Override
    public int deleteUserById(int id) throws Exception {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<String> getRolesByUsername(String username) {
        return userDao.getRolesByUsername(username);
    }

    @Override
    public User getPasswordByUsername(String username) {
        return userDao.getPasswordByUsername(username);
    }

    @Override
    public List<String> getPermisionByUsername(String username) {
        return userDao.getPermisionByUsername(username);
    }
}

package com.linn.home.service.impl;

import com.linn.home.dao.UserDao;
import com.linn.home.entity.User;
import com.linn.home.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018-03-06.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User findUserByNameAndPwd(User user) {
        return userDao.findUserByNameAndPwd(user);
    }
}

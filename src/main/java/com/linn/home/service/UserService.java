package com.linn.home.service;

import com.linn.home.entity.User;

import java.util.List;

/**
 * 用户service层
 * Created by Administrator on 2018-03-06.
 */
public interface UserService {
    User findUserByName(User user);

    User findUserByNameAndPwd(User user);

    List<User> findUserList() throws Exception;

    int addUser(User user) throws  Exception;

    int updateUserByUserName(User user) throws Exception;

    int deleteUserById(int id) throws Exception;
}

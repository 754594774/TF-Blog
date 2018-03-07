package com.linn.home.service;

import com.linn.home.entity.User;

/**
 * 用户service层
 * Created by Administrator on 2018-03-06.
 */
public interface UserService {
    User findUserByNameAndPwd(User user);
}

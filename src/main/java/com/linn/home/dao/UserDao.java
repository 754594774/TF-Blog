package com.linn.home.dao;

import com.linn.home.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户dao层
 * Created by Administrator on 2018-03-06.
 */
@Repository("userDao")
public interface UserDao {
    User findUserByNameAndPwd(User user);
}

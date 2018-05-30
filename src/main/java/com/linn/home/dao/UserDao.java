package com.linn.home.dao;

import com.linn.home.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao层
 * Created by Administrator on 2018-03-06.
 */
@Repository("userDao")
public interface UserDao {

    /**
     * 查找所用用户
     * @param
     * @return
     */
    List<User> findUserList() throws Exception;
    /**
     * 根据用户名和密码查找用户
     * @param user
     * @return
     */
    User findUserByNameAndPwd(User user);

    /**
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    int addUser(User user) throws  Exception;

    /**
     * 更新用户密码
     * @param user
     * @return
     * @throws Exception
     */
    int updateUserByUserName(User user) throws Exception;

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    int deleteUserById(int id) throws Exception;

    /**
     * 根据用户名查找用户
     * @param user
     * @return
     */
    User findUserByName(User user);

    /**
     * 根据用户名查找用户的角色
     * @param username
     * @return 角色集合
     */
    List<String> getRolesByUsername(String username);

    /**
     * 根据用户名查找用户密码
     * @param username
     * @return 用户
     */
    User getPasswordByUsername(String username);

    /**
     * 通过用户名查找用户权限集合
     * @param username
     * @return
     */
    List<String> getPermisionByUsername(String username);
}

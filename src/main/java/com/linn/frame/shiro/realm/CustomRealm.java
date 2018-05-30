package com.linn.frame.shiro.realm;

import com.linn.home.dao.UserDao;
import com.linn.home.entity.User;
import com.linn.home.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义shiro的realm
 * Created by Administrator on 2018/5/29/029.
 */
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = getRolesByUsername(username);
        Set<String> permissions = getPermisionByUsername(username);

        SimpleAuthorizationInfo authorization  = new SimpleAuthorizationInfo();
        authorization.setRoles(roles);
        authorization.setStringPermissions(permissions);
        return authorization;
    }

    private Set<String> getPermisionByUsername(String username) {
        List<String> list = userService.getPermisionByUsername(username);
        Set<String> roles = new HashSet<String>(list);
        return roles;
    }

    private Set<String> getRolesByUsername(String username) {
        List<String> list = userService.getRolesByUsername(username);
        Set<String> roles = new HashSet<String>(list);
        return roles;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //1,从主体传过来的认证信息中，获得用户名
        String username = (String) authenticationToken.getPrincipal();
        //2,通过用户名从数据库获取凭证
        String password = getPasswordByUsername(username);

        if(password == null){
            return  null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,"customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));//将用户名作为盐加密密码
        return authenticationInfo;
    }

    private String getPasswordByUsername(String username) {
        User user = userService.getPasswordByUsername(username);
        if(user != null){
            return user.getPassWord();
        }
        return null;
    }
}

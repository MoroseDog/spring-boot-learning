package com.jj.learning.springboot.chapter41.config;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.jj.learning.springboot.chapter41.domain.UserRepository;
import com.jj.learning.springboot.chapter41.entity.Menu;
import com.jj.learning.springboot.chapter41.entity.Role;
import com.jj.learning.springboot.chapter41.entity.User;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserRepository userRepository;

    // 授權
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User) principals.getPrimaryPrincipal();
        for (Role role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRoleName());
            for (Menu menu : role.getMenuList()) {
                authorizationInfo.addStringPermission(menu.getMenuName());
            }
        }
        return authorizationInfo;
    }

    // 認證
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 獲得當前用戶的用戶名
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        // 根據用戶名找到對象
        // 實際項目中，這裡可以根據實際情況做緩存，如果不做，Shiro自己也是有時間間隔機制，2分鐘內不會重複執行該方法
        User userInfo = userRepository.findByUserName(username);
        if (userInfo == null) {
            return null;
        }
        // 這裡會去校驗密碼是否正確
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, // 用戶名
                userInfo.getPassWord(), // 密碼
                getName());
        return authenticationInfo;
    }
}

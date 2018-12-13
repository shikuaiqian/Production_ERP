package com.cskaoyan.shiro;

import com.cskaoyan.domain.User;
import com.cskaoyan.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AdminRealm   extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    public String getName() {
        return "adminRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User  user = (User) principalCollection.getPrimaryPrincipal();
        String username = user.getUsername();
        String   role= userService.getRoleByusername(username);
        List<String> perssions= userService.getPerssionByrole(role);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(role);
        if(perssions!=null)
        simpleAuthorizationInfo.addStringPermissions(perssions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user=userService.getByUsernamePassword(username);
        if(user==null)
        {
            return null;
        }
        String password = user.getPassword();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,password,getName());
        return simpleAuthenticationInfo;
    }
}

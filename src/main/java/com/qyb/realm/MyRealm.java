package com.qyb.realm;

import com.qyb.pojo.User;
import com.qyb.service.PermissionService;
import com.qyb.service.RoleService;
import com.qyb.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;


@Setter
public class MyRealm extends AuthorizingRealm {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("-------------------shiro 权限管理-------------------");
        String username = (String) principals.getPrimaryPrincipal();

        Set<String> roles = roleService.queryAllRolenameByUsername(username);
        Set<String> permissions = permissionService.queryAllPermissionByUsername(username);

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-------------------shiro 身份验证-------------------");

        String username = (String) token.getPrincipal();

        User user = userService.findUserByUsername(username);

        if(user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user.getUsername(),
                                            user.getPassword(),
                                            //ByteSource.Util.bytes(user.getSalt()),
                                            this.getName());
    }
}

package com.inter.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inter.pojo.system.Permission;
import com.inter.pojo.system.Role;
import com.inter.pojo.system.User;
import com.inter.service.system.PermissionService;
import com.inter.service.system.RoleService;
import com.inter.service.system.UserService;



@Service("userRealm")
public class UserRealm extends AuthorizingRealm{

    
	@Autowired
    private RoleService roleService;
    
    @Autowired
    private PermissionService permissionService;
    
    
    @Autowired
    private UserService userService;
   
    /**
     * 
    * @Title: doGetAuthorizationInfo 
    * @Description: 授权
    * @param pc
    * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
    	
    	
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据当前用户查询对应角色和权限
        Subject subject = SecurityUtils.getSubject();
        
        // 获得当前用户
        User user = (User) subject.getPrincipal();
        // 调用业务层,查询当前用户的角色
        List<Role> roles = roleService.findRoleByUser(user);
        // 给当前用户授权(角色)
        for (Role role : roles) {
            authorizationInfo.addRole(role.getKeyword());
        }

        // 调用业务层,查询当前用户的权限
        List<Permission> permissions = permissionService.findPermissionByUser(user);

        // 给当前用户授权(权限)
        for (Permission permission : permissions) {
            authorizationInfo.addStringPermission(permission.getKeyword());
        }
        
        return authorizationInfo;
    }

    /**
     * 
    * @Title: doGetAuthenticationInfo 
    * @Description: 认证
    * @param token
    * @return
    * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 根据用户名查询用户信息
        
        String username = usernamePasswordToken.getUsername();
        if(username == null) {
        	return null;
        }
        
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return null;
        } else {
            // 用户名存在,当返回用户密码时,安全管理器自动比较返回的密码和用户输入的密码是否一致,
            // 如果密码一致,登陆成功,如果密码不一致,报出错误异常.
            // 参数一: 期望登陆成功后,保存在subject中的信息
            // 参数二: 如果返回null,说明用户不存在,报异常
            // 参数三: realm的名字
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
    }
}
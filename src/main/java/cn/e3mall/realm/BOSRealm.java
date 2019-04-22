package cn.e3mall.realm;

import cn.e3mall.mapper.UserMapper;
import cn.e3mall.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class BOSRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("ProjectController_list");
        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("自定义的realm中认证方法执行了。。。。");
        UsernamePasswordToken passwordToken=(UsernamePasswordToken)token;
        //获取页面输入的用户名字
        String username = passwordToken.getUsername();
        //根据用户名查询数据库中的密码
        User user = userMapper.queryByusername(username);
        if(user==null){
            //用户名不存在
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        return info;


    }
}

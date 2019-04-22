package cn.e3mall.controller;

import cn.e3mall.pojo.User;
import com.sun.tools.corba.se.idl.ExceptionEntry;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("LoginController_login")
    public ModelAndView login(String username, String password, HttpServletRequest httpServletRequest){

            //使用shiro框架提供的方式进行认证操作
        Subject subject = SecurityUtils.getSubject();//获取当前用户对象，状态为未认证
        AuthenticationToken token = new UsernamePasswordToken(username, password);//创建用户密码令牌对象
        ModelAndView modelAndView=new ModelAndView();
        try {
            subject.login(token);
            modelAndView.setViewName("index");
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.setViewName("login");

        }
        User user = (User)subject.getPrincipal();
        httpServletRequest.getSession().setAttribute("user",user);

        return  modelAndView;
    }
}

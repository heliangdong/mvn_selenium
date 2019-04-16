package cn.e3mall.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("LoginController_login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView();
        //从session中获取验证码
        String key= (String) request.getSession().getAttribute("key");
        //获取请求中的验证码
        String validatecode = request.getParameter("validatecode");
        if(validatecode!=null&&validatecode.equals(key)){
            //使用shiro框架提供的方式进行认证操作
            SecurityUtils.getSubject();
        }
        return  modelAndView;
    }
}

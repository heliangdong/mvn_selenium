package cn.e3mall.utils;

import cn.e3mall.pojo.User;
import com.sun.net.httpserver.HttpServer;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getUserName {
    @Autowired
    private HttpServletRequest request;

    public  User getUser(){
        User user = (User)request.getSession().getAttribute("User");
        return user;
    }
}

package cn.e3mall.controller;

import cn.e3mall.pojo.User;
import cn.e3mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("UserController_save")
    public ModelAndView save(User user){
        ModelAndView modelAndView=new ModelAndView();
        userService.save(user);
        modelAndView.setViewName("admin/userlist");
        return modelAndView;
    }

}

package cn.e3mall.controller;

import cn.e3mall.pojo.Function;
import cn.e3mall.pojo.TestCaseFunction;
import cn.e3mall.pojo.User;
import cn.e3mall.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class FunctionController {
    @Autowired
    private FunctionService functionService;


    @RequestMapping("FunctionController_list")
    @ResponseBody
    public List<Function> list(){
        return  functionService.list();
    }

    @RequestMapping("FunctionController_save")
    public ModelAndView add(Function function){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/admin/function");
        functionService.save(function);
        return  modelAndView;
    }


    @RequestMapping(value = "FunctionController_textlist",method = RequestMethod.POST)
    public  void  getall(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Function> list = functionService.list();
        response.getWriter().write(String.valueOf(list));
    }

    @RequestMapping("FunctionController_querymenu")

    public void querymenu(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User)request.getSession().getAttribute("user");
        List<Function> list = functionService.querymenu(user);
        response.getWriter().write(String.valueOf(list));
    }

}

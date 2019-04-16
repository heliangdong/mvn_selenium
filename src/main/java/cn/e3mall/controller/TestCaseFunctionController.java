package cn.e3mall.controller;

import cn.e3mall.pojo.TestCaseFunction;
import cn.e3mall.service.TestCaseFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TestCaseFunctionController {
    @Autowired
    private TestCaseFunctionService testCaseFunctionService;

    @RequestMapping(value = "TestCaseFunctionController_list",method = RequestMethod.POST)
    public  void  getall(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<TestCaseFunction> list = testCaseFunctionService.queryall();
        response.getWriter().write(String.valueOf(list));
    }



}

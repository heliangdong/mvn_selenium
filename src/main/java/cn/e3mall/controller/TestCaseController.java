package cn.e3mall.controller;

import cn.e3mall.pojo.TestCase;
import cn.e3mall.pojo.TestCaseDetail;
import cn.e3mall.service.TestCaseDetailService;
import cn.e3mall.service.TestCaseService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService1;

    @RequestMapping("TestCaseController_list")
    @ResponseBody
    public List<TestCase> getalllist(TestCase testCase){
        //testCase为查询条件
        return  testCaseService1.getalllist(testCase);
    }

    //保存
    @RequestMapping(value = "TestCaseController_save" ,method = RequestMethod.POST)
    public ModelAndView save(@RequestParam String name, @RequestParam String[] id, @RequestParam String[] element,@RequestParam String projectid){
        testCaseService1.save(name,id,element,projectid);
        //把结果传递到页面
        ModelAndView modelAndView=new ModelAndView();
        //
        modelAndView.setViewName("subarea");
        return modelAndView;
    }

    @Autowired
    private TestCaseDetailService testCaseDetailService;
    //修改--回显
    @RequestMapping("TestCaseController_update")
    public ModelAndView updae(HttpServletRequest request){
        String id=request.getParameter("id");
        List<TestCaseDetail> TestCaseDetailList = testCaseDetailService.getlistbyid(Integer.parseInt(id));
        //根据ID获取TestCase
        TestCase testCase = testCaseService1.queryTestCaseById(Integer.parseInt(id));
        for(TestCaseDetail testCaseDetail:TestCaseDetailList){
            System.out.println(testCaseDetail);
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("testCase",testCase);
        modelAndView.addObject("TestCaseDetailList",TestCaseDetailList);
        modelAndView.setViewName("TestCase_edit");
        return modelAndView;
    }

    //修改保存
    @RequestMapping(value = "TestCaseController_updateAndSave",method = RequestMethod.POST)
    public ModelAndView update_save(HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String[] element=request.getParameterValues("element");
        String[] caseactionid=request.getParameterValues("caseactionid");
        testCaseService1.update_save(id,name,element,caseactionid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("subarea");
        return modelAndView;
    }

    //批量删除
    @RequestMapping(value = "TestCaseController_deletes",method = RequestMethod.GET)
    public ModelAndView  deletes(String ids){
        ModelAndView modelAndView=new ModelAndView();
        testCaseService1.TestCaseDelete(ids);
        modelAndView.setViewName("subarea");
        return modelAndView;
    }
}

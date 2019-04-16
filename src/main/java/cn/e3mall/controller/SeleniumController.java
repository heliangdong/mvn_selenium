package cn.e3mall.controller;

import cn.e3mall.service.SeleniumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.io.IOException;

@Controller
public class SeleniumController {

    @Autowired
    private SeleniumService seleniumService;

    @RequestMapping("SeleniumController_run")
    public ModelAndView run(String ids) throws InterruptedException, IOException, AWTException {
        seleniumService.run(ids);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("run1");
        return  modelAndView;
    }


}

package cn.e3mall.controller;

import cn.e3mall.pojo.OperationPool;
import cn.e3mall.service.OperationPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OperationPoolController {
    @Autowired
    private OperationPoolService operationPoolService;


    @RequestMapping("OperationPoolController_add")
    public ModelAndView save(String functionIds){
        String[] ids = functionIds.split(",");
        operationPoolService.OperationPool_add(ids);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("run1");
        return modelAndView;
    }

    @RequestMapping("OperationPoolController_list")
    @ResponseBody
    public List<OperationPool> list(){
        return operationPoolService.list();
    }

    @RequestMapping("OperationPoolController_delete")
    @ResponseBody
    public ModelAndView deletes(String ids){
        operationPoolService.deletes(ids);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("run1");
        return modelAndView;

    }
}

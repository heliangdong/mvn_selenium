package cn.e3mall.controller;

import cn.e3mall.pojo.CaseAction;
import cn.e3mall.service.CaseActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CaseActionController {
    @Autowired
    private CaseActionService caseActionService;


    @RequestMapping("/CaseActionList")
    @ResponseBody
    public List<CaseAction> list(){
        return caseActionService.getCaseActionList();
    }

}

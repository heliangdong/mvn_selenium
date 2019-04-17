package cn.e3mall.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    //ajax加载菜单
    @RequestMapping(value = "json/menu", method = RequestMethod.POST)
    public void ajaxDatas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("[\n" +
                "\t\t{ \"id\":\"11\", \"pId\":\"0\", \"name\":\"基础数据\"},\n" +
                "\t\t{ \"id\":\"112\", \"pId\":\"11\", \"name\":\"项目管理\",  \"page\":\"staff1\"},\n" +
                "\t\t{ \"id\":\"113\", \"pId\":\"11\", \"name\":\"买卖家管理\",\"page\":\"region\"},\n" +
                "\t\t{ \"id\":\"114\", \"pId\":\"11\", \"name\":\"测试用例管理\", \"page\":\"subarea\"},\n" +
                "\t\t{ \"id\":\"115\", \"pId\":\"11\", \"name\":\"管理定区/调度排班\",\"page\":\"decidedzone\"},\n" +
                "\t\t{ \"id\":\"12\", \"pId\":\"0\", \"name\":\"运行池管理\"},\n" +
                "\t\t{ \"id\":\"121\", \"pId\":\"12\", \"name\":\"运行池\" ,\"page\":\"run1\"},\n" +
                "\t\t{ \"id\":\"122\", \"pId\":\"12\", \"name\":\"工作单快速录入\" ,\"page\":\"page_qupai_quickworkorder.action\"},\n" +
                "\t\t{ \"id\":\"124\", \"pId\":\"12\", \"name\":\"工作单导入\" ,\"page\":\"page_qupai_workorderimport.action\"},\n" +
                "\t\t{ \"id\":\"13\", \"pId\":\"0\", \"name\":\"调度\"},\n" +
                "\t\t{ \"id\":\"131\", \"pId\":\"13\", \"name\":\"查台转单\",\"page\":\"\"},\n" +
                "\t\t{ \"id\":\"132\", \"pId\":\"13\", \"name\":\"人工调度\",\"page\":\"page_qupai_diaodu.action\"}\n" +
                "]");
    }



}

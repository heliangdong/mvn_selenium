package cn.e3mall.controller;

import cn.e3mall.pojo.Project;
import cn.e3mall.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("ProjectController_list")
    @ResponseBody
    public List<Project> list(){
        return projectService.list();
    }

    @RequestMapping("ProjectController_save")
    public ModelAndView save(String Projectname){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("staff1");
        projectService.save(Projectname);
        return modelAndView;
    }

    @RequestMapping("ProjectController_delete")
    public ModelAndView delete(String ids){
        String[] id = ids.split(",");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("staff1");
        projectService.deletes(id);
        return modelAndView;
    }


}

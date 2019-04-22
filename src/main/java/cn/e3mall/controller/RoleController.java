package cn.e3mall.controller;

import cn.e3mall.pojo.Role;
import cn.e3mall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Access;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("RoleController_save")
    public ModelAndView save(Role role){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("admin/role");
        roleService.save(role);
        return  modelAndView;
    }

    @RequestMapping("RoleController_list")
    @ResponseBody
    public List<Role> list(){
        return roleService.list();

    }

}

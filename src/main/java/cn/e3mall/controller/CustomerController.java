package cn.e3mall.controller;

import cn.e3mall.pojo.Customer;
import cn.e3mall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("CustomerController_save")
    public ModelAndView save(Customer customer){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("region");
        customerService.save(customer);
        return modelAndView;
    }

    @RequestMapping("CustomerController_list")
    @ResponseBody
    public List<Customer> list(){
        return customerService.list();
    }

    @RequestMapping("CustomerController_update")
    public ModelAndView update(Customer customer){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("region");
        customerService.update(customer);
        return modelAndView;
    }
}

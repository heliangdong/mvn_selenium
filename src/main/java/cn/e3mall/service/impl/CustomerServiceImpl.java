package cn.e3mall.service.impl;

import cn.e3mall.mapper.CustomerMapper;
import cn.e3mall.pojo.Customer;
import cn.e3mall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public void save(Customer customer) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        customer.setCtime(df.format(new Date()));
        customer.setUtime(df.format(new Date()));
        customerMapper.insert(customer);
    }

    public List<Customer> list() {
        return customerMapper.queryListResultMap();
    }

    public void update(Customer customer) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        customer.setUtime(df.format(new Date()));
        customerMapper.update(customer);
    }
}

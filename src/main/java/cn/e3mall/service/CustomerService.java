package cn.e3mall.service;

import cn.e3mall.pojo.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    List<Customer> list();

    void update(Customer customer);
}

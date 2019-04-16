package cn.e3mall.mapper;

import cn.e3mall.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    void insert(Customer customer);
    List<Customer> queryListResultMap();
    void update(Customer customer);
    Customer queryByProjectid(String projectid);
}

package cn.e3mall.service;

import cn.e3mall.pojo.OperationPool;

import java.util.List;

public interface OperationPoolService {
     void OperationPool_add(String[] ids);

    List<OperationPool> list();

    void deletes(String ids);
}

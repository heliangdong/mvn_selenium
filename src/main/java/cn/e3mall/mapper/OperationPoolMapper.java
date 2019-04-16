package cn.e3mall.mapper;

import cn.e3mall.pojo.OperationPool;

import java.util.List;

public interface OperationPoolMapper {
    void insert(OperationPool operationPool);
    List<OperationPool> QueryList();
    List<OperationPool> queryListResultMap();
    void deleteById(int id);
    OperationPool querybyid(int id);
    void update(OperationPool operationPool);
}

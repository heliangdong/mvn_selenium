package cn.e3mall.service;

import cn.e3mall.pojo.Function;

import java.util.List;

public interface FunctionService {
    List<Function> list();

    void save(Function function);

}

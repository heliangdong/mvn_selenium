package cn.e3mall.service.impl;


import cn.e3mall.mapper.FunctionMapper;
import cn.e3mall.pojo.Function;
import cn.e3mall.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl  implements FunctionService {
    @Autowired
    private FunctionMapper functionMapper;

    public List<Function> list() {
        return functionMapper.selectAll();
    }

    public void save(Function function) {
        functionMapper.saveFunction(function);
    }
}

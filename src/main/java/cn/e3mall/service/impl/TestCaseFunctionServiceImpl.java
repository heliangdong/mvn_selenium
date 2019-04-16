package cn.e3mall.service.impl;

import cn.e3mall.mapper.TestCaseFunctionMapper;
import cn.e3mall.pojo.TestCaseFunction;
import cn.e3mall.service.TestCaseFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseFunctionServiceImpl implements TestCaseFunctionService {

    @Autowired
    private TestCaseFunctionMapper testCaseFunctionMapper;

    public List<TestCaseFunction> queryall() {
        return testCaseFunctionMapper.queryall();
    }
}

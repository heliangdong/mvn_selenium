package cn.e3mall.service.impl;

import cn.e3mall.mapper.TestCaseDetailMapper;
import cn.e3mall.pojo.TestCaseDetail;
import cn.e3mall.service.TestCaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseDetailServiceImpl implements TestCaseDetailService {
    @Autowired
    private TestCaseDetailMapper testCaseDetailMapper;


    public List<TestCaseDetail> getlistbyid(int testcaseid) {
        return testCaseDetailMapper.queryTestCaseDetailBytestcaseid(testcaseid);
    }
}

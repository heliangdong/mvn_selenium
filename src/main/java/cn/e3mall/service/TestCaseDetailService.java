package cn.e3mall.service;

import cn.e3mall.pojo.TestCaseDetail;

import java.util.List;

public interface TestCaseDetailService {
    List<TestCaseDetail> getlistbyid(int testcaseid);
}

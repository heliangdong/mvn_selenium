package cn.e3mall.service;

import cn.e3mall.pojo.TestCase;

import java.util.List;

public interface TestCaseService {
    List<TestCase> getalllist(TestCase testCase);

    void save(String name, String[] id, String[] element ,String projectid);

    TestCase queryTestCaseById(int id);

    void update_save(String id, String name, String[] element, String[] caseactionid);

    void TestCaseDelete(String ids);
}

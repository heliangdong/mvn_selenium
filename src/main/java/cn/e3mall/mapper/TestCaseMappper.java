package cn.e3mall.mapper;

import cn.e3mall.pojo.TestCase;

import java.util.List;

public interface TestCaseMappper {
    List<TestCase> queryall();
    void TestCaseSave(TestCase testCase);
    //获取ID，用于新增
    int queryMaxId();
    TestCase queryTestCaseById(int id);
    void TestCaseUpdateAndSave(TestCase testCase);
    //删除
    void TestCaseDeleteByid(int id);
    //条件查询
    List<TestCase> queryaByCondition(TestCase testCase);

}

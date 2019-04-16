package cn.e3mall.mapper;

import cn.e3mall.pojo.TestCaseFunction;

import java.util.List;

public interface TestCaseFunctionMapper {
    List<TestCaseFunction> queryall();

    TestCaseFunction queryallByid(int id);

    void insert(TestCaseFunction testCaseFunction);
    Integer queryZindex();

    void deleteByProjectid(String projectid);

    String querypIdByprojectid(String projectid);

    void updateNameByTestcaseid(TestCaseFunction testCaseFunction);

    void deleteByTestcaseid(int testcaseid);
}

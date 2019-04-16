package cn.e3mall.mapper;

import cn.e3mall.pojo.TestCaseDetail;

import java.util.List;

public interface TestCaseDetailMapper {
    List<TestCaseDetail> queryTestCaseDetailBytestcaseid(int testcaseid);
    void TestCaseDetailSave(TestCaseDetail testCaseDetail);
    List<TestCaseDetail> queryElementBycaseactionid(int testcaseid);
    //删除
    void deleteTestcaseDetailBytestcaseid(int testcaseid);
}

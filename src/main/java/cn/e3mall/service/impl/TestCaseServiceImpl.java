package cn.e3mall.service.impl;

import cn.e3mall.mapper.TestCaseDetailMapper;
import cn.e3mall.mapper.TestCaseFunctionMapper;
import cn.e3mall.mapper.TestCaseMappper;
import cn.e3mall.pojo.TestCase;
import cn.e3mall.pojo.TestCaseDetail;
import cn.e3mall.pojo.TestCaseFunction;
import cn.e3mall.service.TestCaseService;
import cn.e3mall.utils.getTestCaseIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseMappper testCaseMappper;
    @Autowired
    private TestCaseDetailMapper testCaseDetailMapper;
    @Autowired
    private TestCaseFunctionMapper testCaseFunctionMapper;

    //获取Testcase列表
    public List<TestCase> getalllist(TestCase testCase) {
        return testCaseMappper.queryaByCondition(testCase);
    }

    @Autowired
    private getTestCaseIdUtil getTestCaseIdUtil1;
    //保存测试用例和元素
    public void save(String name, String[] id, String[] element,String projectid) {
        //保存测试用例
        TestCase testCase=new TestCase();
        String Strid= String.valueOf(getTestCaseIdUtil1.getTestCaseId());
        testCase.setId(Integer.parseInt(Strid));
        testCase.setName(name);
        testCase.setCtime(new Date());
        testCase.setUtime(new Date());
        testCase.setRemarks("测试");
        testCase.setStatus(1);
        testCase.setProjectid(projectid);
        testCaseMappper.TestCaseSave(testCase);
        //保存元素
        for(int i=0;i<id.length;i++){
            TestCaseDetail testCaseDetail=new TestCaseDetail();
            testCaseDetail.setCaseactionid(Integer.parseInt(id[i]));
            testCaseDetail.setElement(element[i]);
            testCaseDetail.setCtime(new Date());
            testCaseDetail.setTestcaseid(Strid);
            testCaseDetailMapper.TestCaseDetailSave(testCaseDetail);
        }
        //保存TestCaseFunction 用于ztree展示
        TestCaseFunction testCaseFunction=new TestCaseFunction();
        //根据projectid 获取PID
        String pid = testCaseFunctionMapper.querypIdByprojectid(projectid);
        testCaseFunction.setpId(Integer.parseInt(pid));
        testCaseFunction.setName(name);
        testCaseFunction.setId(11);
        testCaseFunction.setTestcaseid(Strid);
        testCaseFunctionMapper.insert(testCaseFunction);

    }

    public TestCase queryTestCaseById(int id) {
        return testCaseMappper.queryTestCaseById(id);
    }
//修改
    public void update_save(String id, String name, String[] element, String[] caseactionid) {
        //保存测试用例
        TestCase testCase=new TestCase();
        testCase.setId(Integer.parseInt(id));
        testCase.setName(name);
        testCase.setUtime(new Date());
        testCaseMappper.TestCaseUpdateAndSave(testCase);
        //保存测试用例detail  先删除后新增
        testCaseDetailMapper.deleteTestcaseDetailBytestcaseid(Integer.parseInt(id));
        //保存元素
        for(int i=0;i<caseactionid.length;i++){
            TestCaseDetail testCaseDetail=new TestCaseDetail();
            testCaseDetail.setCaseactionid(Integer.parseInt(caseactionid[i]));
            testCaseDetail.setElement(element[i]);
            testCaseDetail.setCtime(new Date());
            testCaseDetail.setTestcaseid(id);
            testCaseDetailMapper.TestCaseDetailSave(testCaseDetail);
        }
        //修改Ztree名称,用于ztree展示
        TestCaseFunction testCaseFunction=new TestCaseFunction();
        testCaseFunction.setName(name);
        testCaseFunction.setTestcaseid(id);
        testCaseFunctionMapper.updateNameByTestcaseid(testCaseFunction);
    }

    public void TestCaseDelete(String ids) {
        String[] idStr = ids.split(",");
        //批量
        for(String id:idStr){
            testCaseMappper.TestCaseDeleteByid(Integer.parseInt(id));
            testCaseDetailMapper.deleteTestcaseDetailBytestcaseid(Integer.parseInt(id));
            //删除Ztree
            testCaseFunctionMapper.deleteByTestcaseid(Integer.parseInt(id));
        }

    }
}

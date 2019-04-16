package cn.e3mall.service.impl;

import cn.e3mall.mapper.OperationPoolMapper;
import cn.e3mall.mapper.TestCaseFunctionMapper;
import cn.e3mall.mapper.TestCaseMappper;
import cn.e3mall.pojo.OperationPool;
import cn.e3mall.pojo.TestCase;
import cn.e3mall.pojo.TestCaseFunction;
import cn.e3mall.service.OperationPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OperationPoolServiceImpl implements OperationPoolService {
    @Autowired
    private TestCaseFunctionMapper testCaseFunctionMapper;
    @Autowired
    private TestCaseMappper testCaseMappper;
    @Autowired
    private OperationPoolMapper operationPoolMapper;

    public void OperationPool_add(String[] ids) {
        int[] testcaseid = new int[ids.length];
        //根据IDS获取testcaseid
        for(int i=0;i<ids.length;i++){
            TestCaseFunction testCaseFunction = testCaseFunctionMapper.queryallByid(Integer.parseInt(ids[i]));
            if(testCaseFunction.getTestcaseid()!=null){
            testcaseid[i]= Integer.parseInt(testCaseFunction.getTestcaseid());
            System.out.println("testcaseid="+testcaseid[i]);
            }
        }
        //根据testcaseid获取testcase对象，并且保存
        for(int i=0;i<testcaseid.length;i++){
            if(testcaseid[i]!=0){
                TestCase testCase = testCaseMappper.queryTestCaseById(testcaseid[i]);
                OperationPool operationPool=new OperationPool();
                operationPool.setName(testCase.getName());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                operationPool.setCtime(df.format(new Date()));
                operationPool.setResult("0");//0未运行
                operationPool.setRemarks("test");
                operationPool.setTestcaseid(testCase.getId());
                //根据testcaseid 获取projectid，用于保存
                operationPool.setProject_id(testCase.getProjectid());
                operationPoolMapper.insert(operationPool);
            }
        }
    }

    public List<OperationPool> list() {
        List<OperationPool> operationPools = operationPoolMapper.queryListResultMap();
        for(OperationPool operationPool:operationPools){
            System.out.println(operationPool);
        }

        return operationPoolMapper.queryListResultMap();
    }

    public void deletes(String ids) {
        String[] id = ids.split(",");
        for(int i=0;i<id.length;i++){
            operationPoolMapper.deleteById(Integer.parseInt(id[i]));
        }
    }
}

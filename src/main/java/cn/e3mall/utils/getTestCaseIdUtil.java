package cn.e3mall.utils;

import cn.e3mall.mapper.TestCaseMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getTestCaseIdUtil {
    @Autowired
    private TestCaseMappper testCaseMappper;

    public int getTestCaseId(){
        return testCaseMappper.queryMaxId();
    }


}

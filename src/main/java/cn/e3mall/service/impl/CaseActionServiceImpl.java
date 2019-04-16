package cn.e3mall.service.impl;

import cn.e3mall.mapper.CaseActionlMapper;
import cn.e3mall.pojo.CaseAction;
import cn.e3mall.service.CaseActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseActionServiceImpl implements CaseActionService {

    @Autowired
    private CaseActionlMapper actionlMapper;


    public List<CaseAction> getCaseActionList() {
        return actionlMapper.QueryCaseActionList();
    }
}
